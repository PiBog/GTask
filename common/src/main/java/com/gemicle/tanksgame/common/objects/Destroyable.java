/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects;

/**
 * An interface contains method to change armor from destructable objects
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */

public interface Destroyable {
    int getArmor();
    void setArmor(int armor);
}
