/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.server.gamemechanic.gameobjects.Destroyable;
import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape.AbstractWall;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.units.Unit;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.weapons.Bullet;

/**
 * Class contains different static methods for checking game rules and conditions
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class GameRulesAsserts {

    /**
     * The method checks if two objects intersect and return boolean result
     *
     * @param obj1 game object whose position changed
     * @param obj2 game object with fixed position
     * @return result of checking is true if they intersect
     */
    public static boolean isIntersecting(GameObject obj1, GameObject obj2) {
        boolean isIntersect = false;
        if (obj1.getPosY() <= (obj2.getPosY() + obj2.getSize())) {
            if ((obj1.getPosX() + obj1.getSize()) >= obj2.getPosX()) {
                if ((obj1.getPosY() + obj1.getSize()) >= obj2.getPosX()) {
                    if (obj1.getPosX() <= (obj2.getPosX() + obj2.getSize())) {
                        isIntersect = true;
                    }
                }

            }
        }

        return isIntersect;
    }

    /**
     * The method checks if object Bullet  have collision with other intersected object
     * and return boolean result. Bullets have collision with other units, bullets and
     * all kinds of walls except Forest and WaterTrench
     *
     * @param bullet object Bullet whose position changed
     * @param object game object with fixed position at now
     * @return result of checking is true if they have collision
     */
    public static boolean checkIsCollision(Bullet bullet, GameObject object) {
        boolean isCollision = true;
        if (object.getType() == ID.WALL) {
            if (((AbstractWall) object).isTransparent()) {
                isCollision = false;
            }
        }
        return isCollision;
    }

    /**
     * The method checks if object Unit have collision with other intersected object
     * and return boolean result. Units have collision with other units, bullets and
     * all kinds of walls except Forest
     *
     * @param unit   object Unit whose position changed
     * @param object game object with fixed position at now
     * @return result of checking is true if they have collision
     */
    public static boolean checkIsCollision(Unit unit, GameObject object) {
        boolean isCollision = true;
        if (object.getType() == ID.WALL) {
            if (((AbstractWall) object).isCanCrossed()) {
                isCollision = false;
            }
        }
        return isCollision;
    }

//    public static boolean isExplode()

    /**
     * The method change object armor.
     *
     * @param object a game object that can be destroyed
     * @param bullet a object Bullet whose collided
     */
    public static void hitObject(Destroyable object, Bullet bullet) {  //!!! міняю стан вхідного об"єкуту?
        int armor = object.getArmor() - bullet.getPower();
        if (armor < 0) {
            armor = 0;
        }
        object.setArmor(armor);
    }

    /**
     * The method checks if game object destroyed.
     *
     * @param object a game object that can be destroyed
     * @return boolean value true if object destroyed and false otherwise
     */
    public static boolean isDestroyed(Destroyable object) {
        return (object.getArmor() == 0) ? true : false;
    }


}
