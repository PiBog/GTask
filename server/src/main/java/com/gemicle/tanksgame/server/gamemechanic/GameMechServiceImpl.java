/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.Map;
import java.util.Set;

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
     * Period of game mechanics cycle iteration
     */
    private static final int GM_CYCLE_PERIOD = 15;

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
            Thread.sleep(GM_CYCLE_PERIOD);
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
    public Map refreshPlayers(Set<Player> players) {
         this.gameSession.updatePlayers(players);
        return this.gameSession.getActivePlayers();
    }

    @Override
    public Map processingPlayerCommand(Player player, String command) {
        this.gameSession.toDoAction(player, command);
        return this.gameSession.getActivePlayers();
    }


}
