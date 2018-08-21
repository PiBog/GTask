/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Log4j
public class Connector extends Thread {

    private String ipAdress;
    private int port;
    private boolean isActive = false;


    public Connector(String ip, int port) {
        this.ipAdress = ip;
        this.port = port;
        this.isActive = true;
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
            log.info("Connected");
            while (isActive) {
                sendData();



            }
            log.info("Disconnected...");
        } catch (Throwable cause) {
            System.out.println("error: " + cause.getMessage());
        }
    }

    public void sendData(){

    }
}
