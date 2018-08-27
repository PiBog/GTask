/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.landscape;

import lombok.Getter;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public enum RebirthPlace {
    FIRST(380, 540),
    SECOND(380, 20),
    THIRD(20, 280),
    FOURTH(740, 280);

    private final int xPos;
    private final int yPos;

    RebirthPlace(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }


}
