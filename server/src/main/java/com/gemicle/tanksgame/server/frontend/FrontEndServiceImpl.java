/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import com.gemicle.tanksgame.server.config.ThreadsSettings;
import com.gemicle.tanksgame.server.gamemechanic.GameSession;
import com.gemicle.tanksgame.server.gamemechanic.MsgProcessingAction;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.HashSet;
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
public class FrontEndServiceImpl implements FrontEndService, Subscriber, Runnable {

    /**
     * Field contains an address of service
     */
    private final Address address = new Address();

    /**
     * Field contains an instance of message system
     */
    private final MessageSystem messageSystem;
    private final Map<Player, ClientConnThread> connectedUsers = new HashMap<>();
//    private final SocketServer socketServer;

    private boolean isRun = false;


    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public FrontEndServiceImpl(MessageSystem ms) {
        this.messageSystem = ms;
        Thread socketServerThread = new Thread(new SocketServer(this));
        socketServerThread.start();

//        this.messageSystem = ms;
//        this.socketServer = new SocketServer(connectedUsers);
//        Thread socketServerThread = new Thread(socketServer);
//        socketServerThread.start();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        this.isRun = true;
        while (this.isRun) {
            messageSystem.executeForSubscriber(this);
            try {
                Thread.sleep(ThreadsSettings.SERVICE_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void executePlayerCommand(Player player, String command) {
        Message msgDoAction = new MsgProcessingAction(getAddress(),
                getMessageSystem().getGameMechAddress(), player, command);
        this.messageSystem.sendMsg(msgDoAction);
    }

    @Override
    public void replicateToClients(GameSession gameSession) {
        Set<Player> activePlayers = new HashSet<>();
        activePlayers = gameSession.getActivePlayers().keySet();
        for (Player player : activePlayers){
            if(connectedUsers.containsKey(player)){
                connectedUsers.get(player).getOut();
            }
        }
    }
}
