/*Gemicle Inc. © 2012 - 2018. All right reserved.
*
*
*
*/
package com.gemicle.tanksgame.server;

import com.gemicle.tanksgame.server.core.SocketServer;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

/**
 * Implementation of the main class of the server part of the Tanksgame application.
 *
 * @author  Bogdan Pisarenko
 * @version 1.0
 */

@Log4j
public class TanksgameApplicationServer {

    /**
     * Application entry point. Starts server.
     *
     * @param  args array of input string parameters
     * @throws IOException {@inheritDoc}
     */
    public static void main(String[] args) throws IOException {

        SocketServer server = new SocketServer(8888);
        log.info("Server shutdown");
    }


}
