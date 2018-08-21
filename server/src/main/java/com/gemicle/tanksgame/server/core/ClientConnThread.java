/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.core;

import java.io.*;
import java.net.Socket;

/**
 * Implementation of the main class of the server part of the Tanksgame application.
 *
 * @author  Bohdan Pysarenko
 * @since 1.0
 */

public class ClientConnThread extends Thread {

    Socket clientSocket;
    int clientId;
    boolean isRunning = true;

    /**I/O streams*/
    BufferedReader in;

    /**I/O streams*/
    PrintWriter out;

    public ClientConnThread(Socket socket, int id) {
        this.clientSocket = socket;
        this.clientId = id;
    }

    @Override
    public void run() {
        System.out.println("Accepted Client : ID - " + clientId + " : Address - " + clientSocket.getInetAddress().getHostName());

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (isRunning){
                String clientCommand = in.readLine();
                System.out.println("Client Says :" + clientCommand);
                if (clientCommand.equalsIgnoreCase("quit")) {
                    isRunning = false;
                    System.out.print("Stopping client thread for client : " + clientId);
                } else {
                    out.println(clientCommand);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
