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

public class BigBerta extends Unit {

    private BigBerta() {

    }

    public BigBerta(EntryPoint position) {
        setPosX(position.getXPos());
        setPosY(position.getYPos());
        setSpeed(1000);
        setArmor(5);
        setFiring(3);
        this.type = ID.TANK;
        setDirection(position.getDirection());
        setSize(this.OBJECT_SIZE);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unit of(int newPosX, int newPosY) {

        BigBerta newUnit = new BigBerta();
        newUnit.setPosX(newPosX);
        newUnit.setPosY(newPosY);
        newUnit.setSpeed(this.getSpeed());
        newUnit.setArmor(this.getArmor());
        newUnit.setFiring(this.getFiring());
        newUnit.type = this.getType();
        newUnit.setSize(this.getSize());
        return newUnit;
    }
}
