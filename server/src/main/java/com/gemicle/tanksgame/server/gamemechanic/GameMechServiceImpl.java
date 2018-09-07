/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.server.config.Settings;
import com.gemicle.tanksgame.server.gamemechanic.gameengine.Game;
import com.gemicle.tanksgame.server.gamemechanic.gameengine.GameSession;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

/**
 * Class responsible for game mechanics
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
    private Game game;

    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public GameMechServiceImpl(MessageSystem ms) {
        this.messageSystem = ms;
        this.game = new Game();
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
            Thread.sleep(Settings.GM_SERVICE_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error(""+e.getStackTrace()[0].toString());
        }
    }

    private List iterateGame(){

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List addNewPlayer(Player player) {
        if (!game.isActive()) {
            try {
                game.startGame();
            } catch (FileNotFoundException e) {
                log.error(e);
            }
        }
        this.game.getGameSession().addNewPlayer(player);
        return this.game.getGameSession().getAllGameObjects();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List refreshPlayers(Set<Player> players) {
         this.game.getGameSession().updatePlayers(players);
        return this.game.getGameSession().getAllGameObjects();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List processingPlayerCommand(Player player, String command) {
        this.game.processAction(player, command);
        return this.game.getGameSession().getAllGameObjects();
    }


}
