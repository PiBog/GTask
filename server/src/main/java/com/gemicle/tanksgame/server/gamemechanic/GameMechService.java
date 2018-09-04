/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;

import java.util.Map;
import java.util.Set;

/**
 * Interface for working with subscribers of {@code GameMechService}
 * type inside messaging system
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public interface GameMechService {

    Map addNewPlayer(Player player);

    Map refreshPlayers(Set<Player> players);

    Map processingPlayerCommand(Player player, String command);

}
