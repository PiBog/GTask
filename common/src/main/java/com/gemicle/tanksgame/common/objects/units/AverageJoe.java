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
public class AverageJoe extends Unit {


    public AverageJoe(EntryPoint position) {
        this.posX = position.getXPos();
        this.posY = position.getYPos();
        this.speed=3;
        this.armor = 3;
        this.firing = 3;
        this.type = ID.TANK;

    }


}
