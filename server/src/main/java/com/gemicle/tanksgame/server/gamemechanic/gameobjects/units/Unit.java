/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameobjects.units;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.Destroyable;
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
public abstract class Unit extends GameObject implements Destroyable {

    public static final int OBJECT_SIZE = 40000;

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

    protected Unit(){}

    /**
     * Method creates new instance of unit with same features on the new position.
     * If the new position will be able to moving, new instance will be saved in game session ,
     * otherwise it will be destroyed by garbage collector
     *
     * @param newPosX new X co-ordinate of upper-left corner
     * @param newPosY new Y co-ordinate of upper-left corner
     * @return new instance of the unit with same parameters and new position
     */
    public abstract Unit of(int newPosX, int newPosY) ;

}
