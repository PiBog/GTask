/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.messagesystem;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Abstract class describes a general message model in a messaging system
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Getter(AccessLevel.PROTECTED)
public abstract class Message {

    /**
     * Field contains information about a message sender
     */
    private final Address from;


    /**
     * Field contains information about a message receiver
     */
    private final Address to;

    /**
     * Constructs new object with addresses of subscribers
     *
     * @param from address of a message sender
     * @param to   address of a message receiver
     */
    public Message(Address from, Address to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Method executes some action with subscriber
     *
     * @param subscriber messaging system subscriber
     */
    public abstract void execute(Subscriber subscriber);

}
