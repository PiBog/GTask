package com.gemicle.tanksgame.common.objects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class GameObject {

    protected int posX, posY, width, height, placingPrioryty;
    protected ID id;

    abstract public void render (Graphics g);
}
