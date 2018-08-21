package com.gemicle.tanksgame.server.core;

import java.io.*;
import java.net.Socket;

public class ClientConnHandler extends Thread {

    Socket clientSocket;
    int clientId;
    boolean isRunning = true;

    /*I/O streams*/
    PrintWriter out;
    BufferedReader in;

    ClientConnHandler(Socket socket, int id) {
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
