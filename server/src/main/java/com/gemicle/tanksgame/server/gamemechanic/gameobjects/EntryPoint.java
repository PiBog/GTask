/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects;

import com.gemicle.tanksgame.common.objects.Direction;
import lombok.Getter;

/**
 * Class contains start position coordinates from which will starting and reviving players.
 * Every place has area 40x40px
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public enum EntryPoint {
    UP(380000, 0, Direction.SOUTH),
    BOTTOM(380000, 560000, Direction.NORD),
    LEFT(0, 280000, Direction.EAST),
    RIGHT(760000, 280000, Direction.WEST);

    private final int xPos;
    private final int yPos;
    private final Direction direction;

    EntryPoint(int xPos, int yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    /**
     * Method returns random start position
     *
     * @return one of enums
     */
    public static EntryPoint getRndLocation() {
        int rnd = (int) (Math.random() % 4);

        switch (rnd) {
            case 0:
                return BOTTOM;
            case 1:
                return UP;
            case 2:
                return LEFT;
            default:
                return RIGHT;
        }

    }


}
