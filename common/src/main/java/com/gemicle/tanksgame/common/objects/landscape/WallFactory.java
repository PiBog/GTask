/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.landscape;

import com.sun.istack.internal.NotNull;

/**
 * An class implement wall factory that return different kinds of walls depending on
 * input parameter
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class WallFactory {

    /**
     * Method return an instance of one of subclasses AbstractWall
     *
     *@param posX sets co-ordinate X
     *@param posY sets co-ordinate Y
     *@param type type of output wall
     *@return instance of wall or null if type unknown
     */
    public static AbstractWall newWall(@NotNull int posX, @NotNull int posY, @NotNull String type) {

        if (type.equalsIgnoreCase("brick")) {
            return new BricksWall(posX,posY);
        } else if (type.equalsIgnoreCase("iron")) {
            return new IronWall(posX,posY);
        } else if (type.equalsIgnoreCase("forest")) {
            return new Forest(posX,posY);
        } else if (type.equalsIgnoreCase("water")) {
            return new WaterTrench(posX,posY);
        } else {
            return null;
        }

    }
}
