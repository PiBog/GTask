/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;


import lombok.extern.log4j.Log4j;

/**
 * Class describes thread tha listen server
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
public class ListeningThread implements Runnable {

    private Connector server;

    public ListeningThread(Connector connector){
        this.server = connector;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        log.info("start listening");
        server.listen();
        log.info("end listening");
    }
}
