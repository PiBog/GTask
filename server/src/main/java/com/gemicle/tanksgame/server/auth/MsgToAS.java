/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.auth;

import com.gemicle.tanksgame.server.auth.AuthService;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import com.gemicle.tanksgame.server.sandbox.Address;

/**
 * Abstract class describes a message model for AuthService
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public abstract class MsgToAS extends Message {

    /**
     * {@inheritDoc}
     * */
    public MsgToAS(Address from, Address to){
        super(from, to);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Subscriber subscriber) {
        if (subscriber instanceof AuthService){
            execute((AuthService) subscriber);
        }
    }

    /**
     * Method executes some action with {@code AuthService} type subscriber
     *
     * @param authService messaging system {@code AuthService} subscriber
     */
    abstract void execute (AuthService authService);

}
