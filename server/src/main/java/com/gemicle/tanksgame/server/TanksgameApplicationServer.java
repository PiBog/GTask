/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server;

import com.gemicle.tanksgame.server.frontend.FrontEndServiceImpl;
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
        final FrontEndServiceImpl fe = new FrontEndServiceImpl(ms);
        ms.registerFrontEnd(fe);
        final Thread frontendSrvThread = new Thread(fe);
        frontendSrvThread.setDaemon(true);
        frontendSrvThread.setName("FrontEnd");

        final GameMechServiceImpl gm = new GameMechServiceImpl(ms);
        ms.registerGameMech(gm);
        final Thread gmSrvThread = new Thread(gm);
        gmSrvThread.setDaemon(true);
        gmSrvThread.setName("GameMechanics");

        gmSrvThread.start();
        frontendSrvThread.start();



    }
}
