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
 * Class initiate cleaning disconnected players in current game session
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgCleanPlayers extends MsgToGM {

    /**
     * Contains set of connected players
     */
    private Set<Player> players;

    public MsgCleanPlayers(Address from, Address to, Set<Player> players) {
        super(from, to);
        this.players = players;
    }

    /**
     * Creates new message to frontend that contains updated game session and
     * initiates replication task it
     * @param service that will process task
     */
    @Override
    protected void execute(GameMechServiceImpl service) {
        Message response = new MsgReplyAllClients(this.getTo(), this.getFrom(),
                service.refreshPlayers(players));
        service.getMessageSystem().sendMsg(response);
    }
}
