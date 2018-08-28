/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.messagesystem;


/**
 * Interface for working with subscribers in messaging system
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public interface Subscriber {

    /**
     * Method returns address of the subscriber
     */
    Address getAddress();
}
