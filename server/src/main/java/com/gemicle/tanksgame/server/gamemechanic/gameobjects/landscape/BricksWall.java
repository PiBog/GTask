/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape;

import com.gemicle.tanksgame.server.gamemechanic.gameobjects.Destroyable;
import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.ID;
import lombok.Getter;
import lombok.Setter;

/**
 * This POJO class describes kind of wall.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter

public class BricksWall extends AbstractWall implements Destroyable {

    private int armor;


    public BricksWall(int xPos, int yPos) {
        setPosX(xPos);
        setPosY(yPos);
        this.isCanCrossed = false;
        this.isTransparent = false;
        this.type = ID.WALL;
        setDirection(Direction.NORD);
        setArmor(10);
        setSize(this.OBJECT_SIZE);

    }

}