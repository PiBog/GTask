/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.weapons;

import com.gemicle.tanksgame.common.objects.Direction;
import com.gemicle.tanksgame.common.objects.ID;

/**
 * This POJO class describes kind of bullets.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class CrazyBullet extends Bullet{

    public CrazyBullet(int xPos, int yPos, Direction direction) {
        setPosX(xPos);
        setPosY(yPos);
        setSpeed(5);
        setArmor(1);
        setPower(3);
        this.type = ID.BULLET;
        setDirection(direction);
    }
}
