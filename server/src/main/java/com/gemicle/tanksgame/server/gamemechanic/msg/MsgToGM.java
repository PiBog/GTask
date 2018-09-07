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
 * Abstract class that for implements different messages to game mechanic service
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public abstract class MsgToGM extends Message {

    public MsgToGM(Address from, Address to) {
        super(from, to);
    }

    /**
     * Checks if message system subscriber is GameMechService
     */
    @Override
    public final void execute(Subscriber subscriber) {
        if (subscriber instanceof GameMechService) {
            execute((GameMechServiceImpl) subscriber); /*???*/
        }
    }

    /**
     * For execute concrete action
     */
    protected abstract void execute(GameMechServiceImpl service);
}
