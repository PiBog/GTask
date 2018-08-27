/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.auth;

import com.gemicle.tanksgame.server.frontend.Player;
import com.gemicle.tanksgame.server.sandbox.Address;
import lombok.Getter;

/**
 * A class describes object for confirmation connected player
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public class MsgAuthAgree extends MsgToAS {

    private Player confirmedPlayer;
    private long sessionId;

    public MsgAuthAgree(Address to, Address from, Player result, long sessionId) {
        super(from, to);
        this.confirmedPlayer = result;
        this.sessionId = sessionId;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    void execute(AuthService authService) {

    }
}
