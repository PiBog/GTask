/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic;

import com.gemicle.tanksgame.server.gamemechanic.gameobjects.game.Player;

import java.util.List;
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

    /**
     * Method responsible for adding new player to game set
     *
     * @param player recently connected player
     */
    List addNewPlayer(Player player);

    /**
     * Method execute refreshing players list in game session
     *
     * @param players set of active players
     */
    List refreshPlayers(Set<Player> players);

    /**
     * Method execute players command
     *
     * @param player who sends command
     * @param command - player's command
     */
    List processingPlayerCommand(Player player, String command);

}
