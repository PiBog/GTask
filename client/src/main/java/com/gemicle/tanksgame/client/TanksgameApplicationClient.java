/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client;

import com.gemicle.tanksgame.client.core.UserInterface;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Implementation of the main class of the client part of the Tanksgame application.
 *
 * @author  Bohdan Pysarenko
 * @version 1.0
 */
public class TanksgameApplicationClient {
    private static final Logger logger = Logger.getLogger(TanksgameApplicationClient.class.getName());

    /**
     * Application entry point. Starts client.
     *
     * @param  args array of input string parameters(not uses)
     * @throws IOException {@inheritDoc}
     */
    public static void main(String[] args) throws IOException {

        /*creat UI*/
        UserInterface startUI = new UserInterface(800, 600, "The Game - A, S, D, W", Color.LIGHT_GRAY);

        /*start rendering game*/
        Timer t = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startUI.clear();
                startUI.render();
                startUI.swapBuffers();
            }
        });
        t.setRepeats(true);
        t.start();

    }
}
