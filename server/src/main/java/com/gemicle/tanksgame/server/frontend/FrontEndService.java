/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.server.gamemechanic.GameSession;

/**
 * Interface for working with {@code FrontEndService}
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public interface FrontEndService {

    /**
     * Connects new user to game
     */
    void connect(String name);

    /**
     * Returns information about current game to client
     */
    boolean isConnected(UserSession, GameSession);

    /**
     * Gets command from client
     */
    void userCommand(Object);

    /**
     * Refreshes information about current game session to clients
     */
    void reply(GameSession);

}
