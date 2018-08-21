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

/**
 * Implementation of the socket server class.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */

@Getter
@Log4j
public class SocketServer {

    private static int idCounter = 0;

    private ServerSocket server = null;
    private int port;
    private Socket clientSocket = null;
    private boolean isListen = false;

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

    }

    private void startServer() {
        /*Listen to client*/
        while (isListen) {
            try {
                clientSocket = server.accept();
                ClientConnThread clientThread = new ClientConnThread(clientSocket, idCounter++);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
