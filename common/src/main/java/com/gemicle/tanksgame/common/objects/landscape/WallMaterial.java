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
public abstract class WallMaterial extends GameObject {

        /**
         * Can fire through wall
         */
        protected boolean isTransparent;
        /**
         * Can move through wall
         */
        protected boolean isCanCrossed;

}
