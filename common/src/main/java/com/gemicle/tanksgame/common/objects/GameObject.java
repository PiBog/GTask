/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
/**
 * This abstract class groups common features for all game objects i.e.
 * upper-right corner coordinates, type of object and object direction in space.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public abstract class GameObject implements Serializable {

    protected int posX;
    protected int posY;
    protected int size;
    @Setter(AccessLevel.NONE)
    protected ID type;
    protected Direction direction;
    protected boolean isBroken = false;

}
