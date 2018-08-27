/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public abstract class MsgToFE extends Message {

    public MsgToFE(Address from, Address to) {
        super(from, to);
    }

    @Override
    public final void execute(Subscriber subscriber) {
        if (subscriber instanceof FrontEndService) {
            execute((FrontEndServiceImpl) subscriber);
        }
    }

    protected abstract void execute(FrontEndServiceImpl service);

}
