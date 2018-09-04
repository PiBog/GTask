/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.frontend;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * Implementation of the main class of the server part of the Tanksgame application.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */

@Log4j
@Getter
public class ClientConnThread extends Thread {

    private final FrontEndServiceImpl frontEndService;
    private final Socket clientSocket;
    private final Player player;

    /**
     * I/O streams
     */
    private final BufferedReader in;
    private final PrintWriter out;
    private final ObjectOutputStream oos;


    public ClientConnThread(FrontEndServiceImpl frontEndService, Socket clientSocket) throws IOException {
        this.frontEndService = frontEndService;
        this.clientSocket = clientSocket;
        this.player = new Player();
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        log.info("Accepted Client: " + "Address - "
                + clientSocket.getInetAddress().getHostName());
        this.oos = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
//        oos.writeObject(player);
        oos.flush();
    }

    @Override
    public void run() {
        frontEndService.getConnectedUsers().put(this.player, this);

        try {

            while (!isInterrupted()) {
                String clientCommand = in.readLine();
                log.info("Client " + this.player.toString() + " Says :" + clientCommand);
                if (clientCommand != null) {
                    if (clientCommand.startsWith("getPlayer")) {
                        this.player.setName(clientCommand.substring(10));
                        this.oos.writeObject(player);
                        this.oos.flush();
                    } else if (clientCommand.startsWith("startGame")) {
                        this.frontEndService.addPlayer(this.player);
                    } else {
                        this.frontEndService.executePlayerCommand(this.player, clientCommand);
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    log.error(e.getStackTrace()[0]);
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
            log.error(e.getStackTrace().toString());
        }

    }

    void sendData(Map<Player, SimpleTank> activePlayers) {
        try {
            this.oos.writeObject(activePlayers);
            this.oos.flush();
            this.oos.reset();
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getStackTrace()[0].toString(), e);
        }
    }

}
