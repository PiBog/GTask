/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.units;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.Destructable;
import lombok.Getter;
import lombok.Setter;
/**
 * This abstract class groups common features for all battle units i.e.
 *  speed, armor and firing speed.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public abstract class Unit extends GameObject implements Destructable {

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
    protected int firing;



}
