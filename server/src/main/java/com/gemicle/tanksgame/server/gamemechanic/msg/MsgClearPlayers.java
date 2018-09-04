/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.msg;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.server.frontend.msg.MsgReplyAllClients;
import com.gemicle.tanksgame.server.gamemechanic.GameMechServiceImpl;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;

import java.util.Set;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgClearPlayers extends MsgToGM {

    private Set<Player> players;

    public MsgClearPlayers(Address from, Address to, Set<Player> players) {
        super(from, to);
        this.players = players;
    }

    @Override
    protected void execute(GameMechServiceImpl service) {
        Message replyAllPlayers = new MsgReplyAllClients(this.getTo(), this.getFrom(),
                service.refreshPlayers(players));
        service.getMessageSystem().sendMsg(replyAllPlayers);
    }
}
