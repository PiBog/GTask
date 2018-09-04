/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects;

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
    UP(380, 0, Direction.SOUTH),
    BOTTOM(380, 560, Direction.NORD),
    LEFT(0, 280, Direction.SOUTH),
    RIGHT(760, 280, Direction.WEST);

    private final int xPos;
    private final int yPos;
    private final Direction direction;

    EntryPoint(int xPos, int yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }


}
