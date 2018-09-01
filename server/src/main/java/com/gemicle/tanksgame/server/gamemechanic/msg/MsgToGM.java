/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.msg;

import com.gemicle.tanksgame.server.gamemechanic.GameMechService;
import com.gemicle.tanksgame.server.gamemechanic.GameMechServiceImpl;
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
public abstract class MsgToGM extends Message {

    public MsgToGM(Address from, Address to) {
        super(from, to);
    }

    @Override
    public final void execute(Subscriber subscriber) {
        if (subscriber instanceof GameMechService) {
            execute((GameMechServiceImpl) subscriber); /*???*/
        }
    }

    protected abstract void execute(GameMechServiceImpl service);
}
