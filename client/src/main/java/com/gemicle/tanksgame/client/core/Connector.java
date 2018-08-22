/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Log4j
public class Connector {

    public String buffer = "";
    Socket socket;
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    private boolean isActive = false;


    public Connector(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.isActive = true;
        log.info("Connected");
        new ReadThread().start();
        new WriteThread().start();

    }


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
                    if (msg.equalsIgnoreCase("stop")){
                        isActive=false;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    private class WriteThread extends Thread {
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
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (isActive) {
                String msg;
                try {
                    msg = in.readLine();
                    if (msg.equalsIgnoreCase("stop")){
                        isActive=false;
                    } else {
                        out.println(msg);
                        out.flush();
                    }
                } catch (Exception e){
                    e.getMessage();
                }
            }
        }
    }
}


