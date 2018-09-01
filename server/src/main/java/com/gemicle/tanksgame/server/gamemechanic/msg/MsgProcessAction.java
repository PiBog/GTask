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
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgProcessAction extends MsgToGM {

    private Player player;
    private String command;

    public MsgProcessAction(Address from, Address to, Player player, String command) {
        super(from, to);
        this.player = player;
        this.command = command;
    }

    @Override
    protected void execute(GameMechServiceImpl service) {
        Message response = new MsgReplyAllClients(getTo(), getFrom(),
                service.processingUserCommand(player, command));
        service.getMessageSystem().sendMsg(response);
    }
}
