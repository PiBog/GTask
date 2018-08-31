/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.common.objects.game.Player;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.io.*;
import java.net.Socket;

/**
 * Class implement instance of server connector. Contains.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */
@Log4j
@Getter
public class Connector {

    public Object game;
    private Socket socket;
    @Getter(AccessLevel.NONE)
    private PrintWriter out;
    private ObjectInputStream ois;
    private boolean isAlive = false;


    /**
     * Initializes a newly created {@code UserInterface} object so that it generates
     * main window and starts program. Switch on socket connection.
     *
     * @param ip   The ip address of server for connection
     * @param port The port on wich server listens new connections
     */
    public Connector(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.ois = new ObjectInputStream(socket.getInputStream());
        this.isAlive = true;
        log.info("Connected");
        Thread listener = new Thread(new ListeningThread(this));
        listener.setDaemon(true);
        listener.setName("Listen server");
        listener.start();
    }

    /**
     * Method send information about client's action to server
     */
    public void sendCmd(String str) {
        out.println(str);
        log.info("data sent");
    }

    public void listen() {
        while (isAlive) {
            try /*(ObjectInputStream inputStream = this.ois)*/ {
                log.info("ready to listen");
                game = this.ois.readObject();
                log.info("read object " + game.toString());
                Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}


