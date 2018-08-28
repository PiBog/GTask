/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.sandbox;

import lombok.Getter;
import lombok.Setter;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public class CurrentPlayer {

     /**
     * Field contains unique player's ID
     */
    private int id;

    /**
     * Contains player's name
     */
    private String name;

    /**
     * Construct new object with unique ID
     */
    public CurrentPlayer() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.id;
    }
}
