package com.gemicle.tanksgame.common.objects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;

@Getter
@Setter
public abstract class GameObject implements Serializable{

    protected int posX, posY, width, height, placingPrioryty;

}
