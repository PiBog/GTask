/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.messagesystem;

import com.gemicle.tanksgame.server.sandbox.Address;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An class implements message system for messaging between services
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class MessageSystem {
    /**
     * A field contains the instance of MessageSystem
     */
    private static MessageSystem ourInstance = new MessageSystem();

    /**
     *  Pole mistyt' povidomlenia dlia obminu mij igrovymy servisamy
     */
    private final Map<Address, ConcurrentLinkedQueue<Message>> messages =
            new HashMap<>();

    /**
     * Method returns the instans of MessageSystem
     *
     * @return instance of {@code MessageSystem}
     */
    public static MessageSystem getInstance() {
        if (ourInstance == null) {
            return new MessageSystem();
        }
        return ourInstance;
    }

    private MessageSystem() {
    }

    public void sendMsg(Message message){
        Queue<Message> messageQueue = messages.get(message.getTo());
        messageQueue.add(message);
    }

    public void executeForSubscriber(Subscriber subscriber){
        Queue<Message> messageQueue = messages.get(subscriber.getAddress());
        while (!messageQueue.isEmpty()){
            Message message = messageQueue.poll();
            message.execute(subscriber);
        }
    }
}
