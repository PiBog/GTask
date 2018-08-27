/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.messagesystem;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class contains address, generates and keeps unique ID for services
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter
public final class Address {

    /**
     * Initialize and keep integer value
     */
    private static final AtomicInteger ID_COUNTER = new AtomicInteger();


    /**
     * Field contains unique ID of this address
     */
    private final int id;

    /**
     * Construct new object with unique ID
     */
    public Address(){
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
