/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import lombok.Getter;

/**
 * A class contains information about connected player
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public class Player {
    private final String name;
    private final String gameNick;

    public Player(String name, String gameNick) {
        this.name = name;
        this.gameNick = gameNick;
    }
}
