/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects.weapons;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.Destroyable;
import lombok.Getter;
import lombok.Setter;

/**
 * This abstract class groups common features for different tipes of bullets
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public abstract class Bullet extends GameObject implements Destroyable {

    public static final int OBJECT_SIZE = 10;

    /*machine features*/
    /**
     * Speed of movement
     */
    protected int speed;

    /**
     * Value of armor
     */
    protected int armor;

    /**
     * Firing speed
     */
    protected int power;
}
