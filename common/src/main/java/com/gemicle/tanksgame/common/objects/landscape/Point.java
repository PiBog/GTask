/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.landscape;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An ?
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@XmlRootElement
public class Point {
    private int posX;
    private int posY;
    private String type;

    public Point(int posX, int posY, String type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }

    @XmlElement
    public void setPosX(int posX) {
        this.posX = posX;
    }
    @XmlElement
    public void setPosY(int posY) {
        this.posY = posY;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }
}
