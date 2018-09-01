/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implementation of the socket server class.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */

@Getter
@Setter
@Log4j
public class SocketServer implements Runnable {

    private final FrontEndServiceImpl frontEndService;
    private ServerSocket server = null;
    private int port;
    private Socket clientSocket = null;
    private boolean isActive = true;

    public SocketServer(FrontEndServiceImpl frontEndService){
        this.port = 8080;
        this.frontEndService = frontEndService;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*Creates the socket*/
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Error creating socket: " + e.getMessage());
            e.printStackTrace();
        }
        log.info("Server started.");
        while (this.isActive) {
            try {
                clientSocket = server.accept();
                ClientConnThread clientThread = new ClientConnThread(frontEndService, clientSocket);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
