/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.server.frontend.FrontEndService;
import com.gemicle.tanksgame.server.frontend.MsgReplyAllClients;
import com.gemicle.tanksgame.server.frontend.MsgToFE;
import com.gemicle.tanksgame.server.frontend.Player;
import com.gemicle.tanksgame.server.messagesystem.Address;
import com.gemicle.tanksgame.server.messagesystem.Message;
import lombok.Getter;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgProcessingAction extends MsgToGM {

    private Player player;
    private String command;

    public MsgProcessingAction(Address from, Address to, Player player, String command) {
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
