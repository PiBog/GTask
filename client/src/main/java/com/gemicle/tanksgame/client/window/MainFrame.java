/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.window;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class realizes a {@code MainFrame} graphical object with concrete
 * dimension and window title.
 *
 * @author Bohdan Pysarenko
 * @since 1.0
 */

@Getter
@Log4j
public class MainFrame extends JFrame {

    private Canvas content;
    private BufferedImage buffer;
    private Graphics bufferedGraphics;

    /**
     * Initializes a newly created {@code MainFrame} object with parametrized size and title.
     *
     * @param width The width of window content
     * @param height The height of window content
     * @param title The name of window placed in window header
     * */
    public MainFrame(int width, int height, String title) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        content = new Canvas();
        Dimension contentSize = new Dimension(width, height);
        content.setPreferredSize(contentSize);

        this.setResizable(false);
        this.getContentPane().add(content);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.content.requestFocusInWindow();

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferedGraphics = buffer.getGraphics();
    }
}
