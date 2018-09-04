/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.common.objects.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A POJO class contains information about connected player
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@ToString
public class Player implements Serializable{

    /**
     * Initialize and keep integer value
     */
    private static final AtomicInteger ID_COUNTER = new AtomicInteger();

    /**
     * Field contains unique player's ID
     */
    private final int id;

    /**
     * Contains player's name
     */
    private String name;

    /**
     * Construct new object with unique ID
     */
    public Player() {
        this.id = ID_COUNTER.getAndIncrement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.id;
    }

}
