/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import com.gemicle.tanksgame.server.messagesystem.Subscriber;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Service for working with connected players
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class FrontEndServiceImpl implements FrontEndService, Subscriber, Runnable {

    /**
     * Field contains an instance of message system
     */
    private final MessageSystem messageSystem;

    private final Map<> conectedUsers = new HashMap<>();

    private ServerSocket serverSocket = null;
    private int port
    private Socket clientSocket = null;


    /**
     * Constructs new object instance and initializes message system as parameter
     */
    public FrontEndServiceImpl(int port,MessageSystem ms) {
        this.messageSystem = ms;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void connect(String name) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConnected(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void userCommand() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reply() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

    }



}
