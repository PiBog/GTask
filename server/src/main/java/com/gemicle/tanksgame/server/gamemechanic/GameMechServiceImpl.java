/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import com.gemicle.tanksgame.server.frontend.msg.MsgReplyAllClients;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible game mechanics
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class GameMechServiceImpl implements GameMechService, Subscriber, Runnable {

    /**
     * Field contains an address of service
     */
    private final Address address = new Address();

    /**
     * Field contains an instance of message system
     */
    private MessageSystem messageSystem;

    private boolean isRun = false;

    /**
     * Current game
     */
    private GameSession gameSession;

    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public GameMechServiceImpl(MessageSystem ms) {
        this.messageSystem = ms;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        this.isRun = true;
        log.info("Game mechanic started");

        while (this.isRun) {
            messageSystem.executeForSubscriber(this);
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            log.error(""+e.getStackTrace()[0].toString());
        }
    }

    @Override
    public Map addNewPlayer(Player player) {
        if (gameSession == null) {
            gameSession = new GameSession();
        }
        this.gameSession.addPlayer(player);
        return this.gameSession.getActivePlayers();
    }

    @Override
    public Map processingUserCommand(Player player, String command) {
        this.gameSession.toDoAction(player, command);
        return this.gameSession.getActivePlayers();
    }


}
