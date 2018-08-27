/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class contains information about connected player
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
@Setter
public class Player {

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
