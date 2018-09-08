/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects;

import lombok.Getter;

/**
 * Class contains all possible directions for tank movement
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public enum Direction  {
    NORD(0,-1),
    SOUTH(0,1),
    WEST(-1,0),
    EAST(1,0);
    private final int dX;
    private final int dY;

    Direction(int dX, int dY){
        this.dX=dX;
        this.dY=dY;
    }
}
