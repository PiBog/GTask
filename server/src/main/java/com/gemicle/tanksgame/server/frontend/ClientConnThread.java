/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import lombok.extern.log4j.Log4j;

import java.io.*;
import java.net.Socket;

/**
 * Implementation of the main class of the server part of the Tanksgame application.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */

@Log4j
public class ClientConnThread implements Runnable{

    Socket clientSocket;
    int clientId;
    boolean isRunning = true;

    /**
     * I/O streams
     */
    BufferedReader in;

    /**
     * I/O streams
     */
    PrintWriter out;

    public ClientConnThread(Socket socket, int id) throws IOException {
        this.clientSocket = socket;
        this.clientId = id;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        log.info("Accepted Client : ID - " + clientId + " : Address - "
                + clientSocket.getInetAddress().getHostName());
    }

    @Override
    public void run() {


        try {

            while (isRunning) {
                String clientCommand = in.readLine();
                log.info("Client " + this.clientId + " Says :" + clientCommand);
                if (clientCommand.equalsIgnoreCase("stop")) {
                    isRunning = false;
                    log.info("Stopping client thread for client : " + clientId);
                }
                else {
                    for (ClientConnThread conn : SocketServer.clientsList){
                        if(conn.isAlive()){
                        conn.sendMsg(clientCommand);
                        log.info("Sending to client " + conn.clientId + ": " + clientCommand);}
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendMsg(String msg){
        out.println(msg);
        out.flush();
    }
}
