package com.gemicle.tanksgame.client.objects.landscape;

import com.gemicle.tanksgame.client.objects.ID;

import java.awt.*;

public class FieldBorderWall extends WallMaterial {

    public FieldBorderWall(int xPos, int yPos, int width, int height) {
        this.setPosX(xPos);
        this.setPosY(yPos);
        this.setId(ID.Wall);
        this.setWidth(width);
        this.setHeight(height);
    }
    @Override
    public void render(Graphics g) {

    }
}
