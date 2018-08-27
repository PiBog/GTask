package com.gemicle.tanksgame.common.objects.units;

import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.common.objects.landscape.RebirthPlace;
import lombok.Getter;

import java.awt.*;

@Getter
public class SimpleTank extends Machine {


    public SimpleTank(RebirthPlace position) {
        this.posX = position.getXPos();
        this.posY = position.getYPos();
        this.speed=3;
        this.armor = 3;
        this.firePower = 3;

    }


}
