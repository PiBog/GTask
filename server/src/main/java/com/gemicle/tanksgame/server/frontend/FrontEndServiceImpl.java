/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.AverageJoe;
import com.gemicle.tanksgame.server.config.Settings;
import com.gemicle.tanksgame.server.gamemechanic.msg.MsgAddNewPlayer;
import com.gemicle.tanksgame.server.gamemechanic.msg.MsgCleanPlayers;
import com.gemicle.tanksgame.server.gamemechanic.msg.MsgProcessAction;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service for working with connected players
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class FrontEndServiceImpl implements FrontEndService, Runnable {

    /**
     * Field contains an address of service
     */
    private final Address address = new Address();

    /**
     * Field contains an instance of message system
     */
    private final MessageSystem messageSystem;
    private final Map<Player, ClientConnThread> connectedUsers = new HashMap<>();

    private boolean isRun = false;


    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public FrontEndServiceImpl(MessageSystem ms) {
        this.messageSystem = ms;
        Thread socketServerThread = new Thread(new SocketServer(this));
        socketServerThread.setName("SocketServer");
        socketServerThread.start();

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        this.isRun = true;
        log.info("Frontend started");
        while (this.isRun) {
//            refreshConnections();
            messageSystem.executeForSubscriber(this);
            try {
                Thread.sleep(Settings.FE_SERVICE_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void refreshConnections(){
        Map<Player, ClientConnThread> tmpConnectedUsers = new HashMap<>(connectedUsers);
        if (tmpConnectedUsers.size()>0){
            for (Map.Entry<Player, ClientConnThread> item: tmpConnectedUsers.entrySet()){
                if(!item.getValue().isAlive()){
                    connectedUsers.remove(item.getKey());
                }
            }
        }
        Set<Player> clearedSet = connectedUsers.keySet();
        if(clearedSet.size()!=tmpConnectedUsers.size()){
            clearGameSession(clearedSet);
        }
    }

    private void clearGameSession(Set<Player> players){
        Message msgClearPlayers = new MsgCleanPlayers(getAddress(),
                                messageSystem.getGameMechAddress(), players);
        this.messageSystem.sendMsg(msgClearPlayers);
    }

    @Override
    public void addPlayer(Player player) {
        Message msgAddPlayer = new MsgAddNewPlayer(getAddress(),
                                messageSystem.getGameMechAddress(), player);
        this.messageSystem.sendMsg(msgAddPlayer);
    }

    @Override
    public void executePlayerCommand(Player player, String command) {
        Message msgDoAction = new MsgProcessAction(getAddress(),
                getMessageSystem().getGameMechAddress(), player, command);
        this.messageSystem.sendMsg(msgDoAction);
    }

    @Override
    public void replicateToClients(List<GameObject> gameSessionObjects) {
        refreshConnections();
        Set<Player> activePlayers = connectedUsers.keySet();
        for (Player player : activePlayers){
            if(connectedUsers.containsKey(player)){
                connectedUsers.get(player).sendData(gameSessionObjects);

            }
        }
    }
}
