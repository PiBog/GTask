/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class implement instance of server connector. Contains.
 *
 * @author  Bohdan Pysarenko
 * @since  1.0
 */
@Log4j
@Getter
public class Connector {

    Socket socket;
    PrintWriter out;
    BufferedReader in;
    private boolean isActive = false;


    /**
     * Initializes a newly created {@code UserInterface} object so that it generates
     * main window and starts program. Switch on socket connection.
     *
     * @param ip The ip address of server for connection
     * @param port The port on wich server listens new connections
     * */
    public Connector(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.isActive = true;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        log.info("Connected");
        new ReadThread().start();
    }

    /**
     * Method send information about event to server
     * */
    public void sendMsg(String str) {
        out.println(str);
        out.flush();
        log.info("data sending");
    }


    /**
     * Class used for start new thread for server listening
     * */
    private class ReadThread extends Thread {
        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         * @see #Thread(ThreadGroup, Runnable, String)
         */
        @Override
        public void run() {
            String msg;
            while (isActive) {
                try {
                    msg = in.readLine();
                    log.info("Receive " + msg);
                    if (msg.equalsIgnoreCase("stop")) {
                        isActive = false;
                    } else {
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

}


