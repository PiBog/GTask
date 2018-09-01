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

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MsgAddNewPlayer extends MsgToGM {

    private Player player;

    public MsgAddNewPlayer(Address from, Address to, Player player){
        super(from, to);
        this.player = player;
    }


    @Override
    protected void execute(GameMechServiceImpl service) {
        Message replyAllPlayers = new MsgReplyAllClients(this.getTo(), this.getFrom(),
                service.addNewPlayer(player));
        service.getMessageSystem().sendMsg(replyAllPlayers);
    }
}
