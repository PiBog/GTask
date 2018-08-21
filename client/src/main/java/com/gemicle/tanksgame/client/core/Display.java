package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.client.controls.Keyboard;
import com.gemicle.tanksgame.client.objects.landscape.Bricks;
import com.gemicle.tanksgame.client.objects.landscape.Water;
import com.gemicle.tanksgame.client.objects.units.SimpleTank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {

    private static boolean isCreated = false;
    private static JFrame window;
    private static Canvas content;
    private static BufferedImage buffer;
    private static int[] bufferedData;
    private static Graphics bufferedGraphics;
    private static int clearColor;
    private static Handler handler;


    public static void create(int width, int height, String title, Color color) {
        if (isCreated) return;

        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setFocusable(true);
        content = new Canvas();

        Dimension contentSize = new Dimension(width, height);
        content.setPreferredSize(contentSize);

        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferedData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferedGraphics = buffer.getGraphics();
        clearColor = color.getRGB();

        isCreated = true;
        startGame();
    }

    public static void clear() {
        Arrays.fill(bufferedData, clearColor);

    }

    public static void render() {
        handler.render(bufferedGraphics);
    }

    public static void swapBuffers() {
        Graphics graphics = content.getGraphics();
        graphics.drawImage(buffer, 0, 0, null);

    }

    public static void startGame() {
        handler = new Handler();
        handler.addObj(new SimpleTank(200, 200));
        handler.addObj(new Bricks(500,500,50,50));
        handler.addObj(new Water(300,50,50,100));
        window.addKeyListener(new Keyboard(handler));

    }

}
