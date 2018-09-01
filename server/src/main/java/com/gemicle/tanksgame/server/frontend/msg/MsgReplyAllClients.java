/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend.msg;

import com.gemicle.tanksgame.server.frontend.FrontEndServiceImpl;
import com.gemicle.tanksgame.server.gamemechanic.GameSession;
import com.gemicle.tanksgame.server.messagesystem.Address;

import java.util.Map;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgReplyAllClients extends MsgToFE {

    private Map gameSession;

    public MsgReplyAllClients(Address from, Address to, Map gameSession){
        super(from, to);
        this.gameSession = gameSession;
    }

    @Override
    protected void execute(FrontEndServiceImpl service) {
        service.replicateToClients(gameSession);
    }
}