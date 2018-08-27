/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server;

import com.gemicle.tanksgame.server.auth.AuthServiceImpl;
import com.gemicle.tanksgame.server.frontend.FrontEndServiceImpl;
import com.gemicle.tanksgame.server.frontend.SocketServer;
import com.gemicle.tanksgame.server.gamemechanic.GameMechServiceImpl;
import com.gemicle.tanksgame.server.messagesystem.MessageSystem;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

/**
 * Main class of server part
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */

@Log4j
public class TanksgameApplicationServer {

    /**
     * Entry point starts server.
     *
     * @param args input arguments. (don't used)
     * @throws IOException {@inheritDoc}
     */
    public static void main(String[] args) throws IOException {

        final MessageSystem ms = MessageSystem.getInstance();
        final Thread frontendSrvThread = new Thread(new FrontEndServiceImpl(8888, ms));
        frontendSrvThread.setDaemon(true);
        frontendSrvThread.setName("FrontEnd");
        final Thread authtSrvThread = new Thread(new AuthServiceImpl(ms));
        authtSrvThread.setDaemon(true);
        authtSrvThread.setName("AuthSrv");
        final Thread gmSrvThread = new Thread(new GameMechServiceImpl(ms));
        gmSrvThread.setDaemon(true);
        gmSrvThread.setName("GameMechanics");

        authtSrvThread.start();
        gmSrvThread.start();
        frontendSrvThread.start();

        log.info("Server shutdown");
    }


}
