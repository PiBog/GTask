/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.msg;

import com.gemicle.tanksgame.server.frontend.msg.MsgReplyAllClients;
import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.server.gamemechanic.GameMechServiceImpl;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;

/**
 * Class processes player's action in current game session
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgProcessAction extends MsgToGM {

    /**
     * Contains player who made action
     */
    private Player player;
    /**
     * Contains description of player's action
     */
    private String command;

    public MsgProcessAction(Address from, Address to, Player player, String command) {
        super(from, to);
        this.player = player;
        this.command = command;
    }

    /**
     * Creates new message to frontend that contains updated game session and
     * initiates replication task it
     * @param service that will process task
     */
    @Override
    protected void execute(GameMechServiceImpl service) {
        Message response = new MsgReplyAllClients(getTo(), getFrom(),
                service.processingPlayerCommand(player, command));
        service.getMessageSystem().sendMsg(response);
    }
}
