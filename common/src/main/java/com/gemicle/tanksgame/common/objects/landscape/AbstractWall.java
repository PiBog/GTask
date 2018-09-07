/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.landscape;

import com.gemicle.tanksgame.common.objects.GameObject;
import lombok.Getter;

/**
 * This abstract class groups common features for all landscape units i.e.
 *  ability to be destructed and crossed.
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public abstract class AbstractWall extends GameObject {

        public static final int OBJECT_SIZE = 40;

        /**
         * Can fire through wall. For checking collisions with bullets.
         */
        protected boolean isTransparent;
        /**
         * Can move through wall. For checking collisions with units.
         */
        protected boolean isCanCrossed;

}
