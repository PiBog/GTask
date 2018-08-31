/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client;

import com.gemicle.tanksgame.client.core.Frame;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.io.IOException;

/**
 * Implementation of the main class of the client part of the Tanksgame application.
 *
 * @author  Bohdan Pysarenko
 * @version 1.0
 */
@Log4j
public class TanksgameApplicationClient {

    /**
     * Application entry point. Starts client.
     *
     * @param  args array of input string parameters(not uses)
     * @throws IOException {@inheritDoc}
     */
    public static void main(String[] args) throws IOException {

        JFrame myWindow = new Frame("TG");

    }
}
