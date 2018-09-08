/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects.units;

import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.EntryPoint;

/**
 * This POJO describes kind of tank.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class FastMicky extends Unit {

    private FastMicky(){}

    public FastMicky(EntryPoint position) {
        this.posX = position.getXPos();
        this.posY = position.getYPos();
        this.speed = 5000;
        this.armor = 1;
        this.firing = 3;
        this.type = ID.TANK;
        setSize(this.OBJECT_SIZE);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit of(int newPosX, int newPosY) {
        FastMicky newUnit = new FastMicky();
        newUnit.setPosX(newPosX);
        newUnit.setPosY(newPosY);
        newUnit.setSpeed(this.getSpeed());
        newUnit.setArmor(this.getArmor());
        newUnit.setFiring(this.getFiring());
        newUnit.type=this.getType();
        newUnit.setSize(this.getSize());
        return newUnit;
    }
}
