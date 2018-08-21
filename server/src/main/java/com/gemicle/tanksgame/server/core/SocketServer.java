/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.core;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Implementation of the socket server class.
 *
 * @author Bogdan Pisarenko
 * @since 1.0
 */

@Getter
@Log4j
public class SocketServer {

    /**connection id counter*/
    static int idCounter = 0;

    /*static ServerSocket variable*/
    private static ServerSocket server = null;
    /*socket server port on which it will listen*/
    private static int port;
    private Socket clientSocket = null;
    private boolean isListen = false;

    List

    public SocketServer() throws IOException {
        this(8080);
    }

    public SocketServer(int port) throws IOException {
        this.port = port;

        /*Creates the socket*/
        try {
            server = new ServerSocket(port);
            this.isListen = true;
        } catch (IOException e) {
            System.err.println("Error creating socket: " + e.getMessage());
            e.printStackTrace();
            throw (e);
        }
        log.info("Server started.");
        startServer();
        ArrayList
    }

    private void startServer() {
        /*Listen to client*/
        while (isListen) {
            try {
                clientSocket = server.accept();
                ClientConnHandler clientThread = new ClientConnHandler(clientSocket, idCounter++);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
