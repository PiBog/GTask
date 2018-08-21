
package com.gemicle.tanksgame.client;

import com.gemicle.tanksgame.client.core.Connector;
import com.gemicle.tanksgame.client.core.Display;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TanksgameApplicationClient {
    private static final Logger logger = Logger.getLogger(TanksgameApplicationClient.class.getName());

    public static void main(String[] args) throws Exception {

        /*creat new window*/
        Display.create(800, 600, "The Game - A, S, D, W", Color.LIGHT_GRAY);


        /*start rendering game*/
        Timer t = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.clear();
                Display.render();
                Display.swapBuffers();
            }
        });

        t.setRepeats(true);
        t.start();

    }
}
