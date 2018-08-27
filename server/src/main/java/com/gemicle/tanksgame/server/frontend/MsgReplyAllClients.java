/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.server.gamemechanic.GameSession;
import com.gemicle.tanksgame.server.messagesystem.Address;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgReplyAllClients extends MsgToFE {

    private GameSession gameSession;

    public MsgReplyAllClients(Address from, Address to, GameSession gameSession){
        super(from, to);
        this.gameSession = gameSession;
    }

    @Override
    protected void execute(FrontEndServiceImpl service) {
        service.repicateToClients(gameSession);
    }
}
