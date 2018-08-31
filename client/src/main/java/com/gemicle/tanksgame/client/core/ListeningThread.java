/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;


import lombok.extern.log4j.Log4j;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
public class ListeningThread implements Runnable {

    private Connector server;
    private boolean isListen = false;

    public ListeningThread(Connector connector){
        this.server = connector;
        this.isListen = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        log.info("start listen");
        server.listen();
//        while(isListen){
//        }
        log.info("ending process");
    }
}
