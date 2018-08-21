package com.gemicle.tanksgame.client.objects.landscape;

import com.gemicle.tanksgame.client.objects.ID;

import java.awt.*;

public class Water extends WallMaterial{

    public Water(int xPos, int yPos, int width, int height) {
        this.setPosX(xPos);
        this.setPosY(yPos);
        this.setId(ID.Wall);
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getPosX(),getPosY(),getWidth(),getHeight());
    }
}
