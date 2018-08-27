/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.server.config.ThreadsSettings;
import com.gemicle.tanksgame.server.frontend.Player;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;

/**
 * Class responsible game mechanics
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
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
        while (this.isRun) {
            messageSystem.executeForSubscriber(this);
        }
    }

    @Override
    public GameSession processingUserCommand(Player player, String command) {
        return null;
    }


}
