/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.auth;

import com.gemicle.tanksgame.server.frontend.Player;
import com.gemicle.tanksgame.server.messagesystem.Message;
import com.gemicle.tanksgame.server.sandbox.Address;
import lombok.Getter;

/**
 * A class describes object for initialize checking and connecting new player
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public class MsgAuth extends MsgToAS {

    private String playerName;
    private String password;
    private long sessionId;

    public MsgAuth(Address from, Address to, String playerName, String password, long sessionId) {
        super(from, to);
        this.playerName = playerName;
        this.password = password;
        this.sessionId = sessionId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void execute(AuthService authService) {

        Player result = authService.auth(playerName, password);
        Message response = new MsgAuthAgree(getTo(), getFrom(), result, this.sessionId);
        authService.getMessageSystem().sendMsg(response);

    }
}
