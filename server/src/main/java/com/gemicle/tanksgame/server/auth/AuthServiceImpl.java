/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.auth;

import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class AuthServiceImpl implements AuthService, Subscriber, Runnable {

    /**
     * Field contains an instance of message system
     */
    private MessageSystem messageSystem;

    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public AuthServiceImpl(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address getAddress() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

    }
}
