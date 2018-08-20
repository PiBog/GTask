package gem.task.tanksgame.client;

import gem.task.tanksgame.client.core.Connector;
import gem.task.tanksgame.client.core.Display;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TanksgameApplicationClient {
    private static final Logger logger = Logger.getLogger(TanksgameApplicationClient.class.getName());

    public static void main(String[] args) throws Exception {

        /*creat new window*/
        Display.create(800, 600, "The Game - A, S, D, W", Color.LIGHT_GRAY);

        /*connect to game server*/
        Connector connect = new Connector("localhost", 8888);
        Thread connThread = new Thread(connect);
        connThread.start();

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
