/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.client.controls.Keyboard;
import com.gemicle.tanksgame.client.window.MainFrame;
import com.gemicle.tanksgame.common.objects.landscape.Bricks;
import com.gemicle.tanksgame.common.objects.landscape.Water;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class realize user interface. Contains graphics elements and control commands.
 *
 * @author  Bohdan Pysarenko
 * @since  1.0
 */
@Log4j
@Getter
public class UserInterface {

    private MainFrame window;
    private Connector connector;
    private Keyboard kbdListener;
    private int[] bufferedData;
    private int clearColor;
    private Handler handler;

    /**
     * Initializes a newly created {@code UserInterface} object so that it generates
     * main window and starts program.
     * @param width The width of window content
     * @param height The height of window content
     * @param title The name of window placed in window header
     * @param color The background color of window content
     * */
    public UserInterface(int width, int height, String title, Color color) {

        this.window = new MainFrame(width, height, title);
        this.handler = new Handler();
        this.kbdListener = new Keyboard(handler);
        this.bufferedData = ((DataBufferInt) window.getBuffer().getRaster().getDataBuffer()).getData();
        this.clearColor = color.getRGB();
        startGame();
    }

    /**
     * Method  generate map and adds input commands handlers
     * */
    public void startGame() {

        connect();
        handler.setConnector(this.connector);
        /*todo: replace by getMapParams()*/
        handler.addObj(new SimpleTank(200, 200));
        handler.addObj(new Bricks(500, 500, 50, 50));
        handler.addObj(new Water(300, 50, 50, 100));

        this.window.addKeyListener(kbdListener);
        this.window.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                log.info("focus received");
            }
            public void focusLost(FocusEvent e){
                log.info("focus lost");
            }
        });
        this.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.getContent().requestFocus();

            }
        });

    }

    /**
     * Method create connection with server socket
     * */
    private void connect() {
        try {
            this.connector = new Connector("localhost", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method clear game area before repainting
     * */
    public void clear() {
        Arrays.fill(this.bufferedData, this.clearColor);

    }

    /**
     * Method creates buffered repainting of game object
     * */
    public void render() {
        this.handler.render(this.window.getBufferedGraphics());
    }


    /**
     * Method repaint game area on screen
     * */
    public void swapBuffers() {
        Graphics graphics = window.getContent().getGraphics();
        graphics.drawImage(window.getBuffer(), 0, 0, null);

    }



}
