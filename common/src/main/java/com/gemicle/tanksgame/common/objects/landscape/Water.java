package com.gemicle.tanksgame.common.objects.landscape;

import com.gemicle.tanksgame.common.objects.ID;

import java.awt.*;

public class Water extends WallMaterial{

    public Water(int xPos, int yPos, int width, int height) {
        this.setPosX(xPos);
        this.setPosY(yPos);
        this.setWidth(width);
        this.setHeight(height);
    }

}
