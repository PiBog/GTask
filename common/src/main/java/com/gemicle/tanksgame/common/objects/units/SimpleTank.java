package com.gemicle.tanksgame.common.objects.units;

import com.gemicle.tanksgame.common.objects.ID;

import java.awt.*;

public class SimpleTank extends Machine {


    public SimpleTank(int xPos, int yPos) {
        setPosX(xPos);
        setPosY(yPos);
        setId(ID.Tank);
        this.setArmor(5);
        this.setFirePower(2);
        this.setSpeed(3);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getPosX(), getPosY(), 50, 50);
    }
}
