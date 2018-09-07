/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.units;

import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.common.objects.EntryPoint;

/**
 * This POJO describes kind of tank.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */

public class BigBerta extends Unit{

    public BigBerta(EntryPoint position) {
        setPosX(position.getXPos());
        setPosY(position.getYPos());
        setSpeed(1);
        setArmor(5);
        setFiring(3);
        this.type = ID.TANK;
        setDirection(position.getDirection());
        setSize(this.OBJECT_SIZE);

    }
}
