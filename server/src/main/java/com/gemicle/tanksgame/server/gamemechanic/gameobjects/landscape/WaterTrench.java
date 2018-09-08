/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape;

import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.ID;

/**
 * This POJO class describes kind of wall.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */

public class WaterTrench extends AbstractWall {

    public WaterTrench(int xPos, int yPos) {
        setPosX(xPos);
        setPosY(yPos);
        this.isCanCrossed = false;
        this.isTransparent = true;
        this.type = ID.WALL;
        setDirection(Direction.NORD);
        setSize(this.OBJECT_SIZE);

    }

}
