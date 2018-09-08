/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.game.Player;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;

import java.util.List;

/**
 * Interface for working with {@code FrontEndService}
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public interface FrontEndService extends Subscriber {

    void addPlayer(Player player);

    void executePlayerCommand (Player player, String command);

    void replicateToClients(List<GameObject> gameSession);

}
