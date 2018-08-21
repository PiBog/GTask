package com.gemicle.tanksgame.client.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connector implements Runnable{

    private static String ipAdress;
    private static int port;

    public Connector (String ip, int port){
        this.ipAdress = ip;
        this.port = port;
    }
    /**

     */
    @Override
    public void run() {
        try (
                Socket socket = new Socket(ipAdress, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String inputLine;
            out.println(1);

            while ((inputLine = in.readLine()) != null) {
                System.out.println("have read from server: " + inputLine);
                int number = Integer.valueOf(inputLine);
//                if (number >= 10) {
//                    break;
//                }

                number++;
                System.out.println("sending to server:" +number);
                out.println(number);
                Thread.sleep(2000);
            }
            System.out.println("disconected...");
        } catch (Throwable cause){
            System.out.println("error: "+ cause.getMessage());
        }
    }
}
