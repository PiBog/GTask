package gem.task.tanksgame.client;

import gem.task.tanksgame.client.core.Display;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TanksgameApplicationClient {
    private static final Logger logger = Logger.getLogger(TanksgameApplicationClient.class.getName());

    private static String ipAdress = "localhost";
    private static int port = 8888;

    public static void main(String[] args) throws Exception {

        Display.create(800, 600, "The Game - A, S, D, W", Color.LIGHT_GRAY);

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

//        try (
//                Socket socket = new Socket(ipAdress, port);
//                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
//        ) {
//            String inputLine;
//            out.println(1);
//
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println("have read from server: " + inputLine);
//                int number = Integer.valueOf(inputLine);
////                if (number >= 10) {
////                    break;
////                }
//
//                number++;
//                System.out.println("sending to server:" +number);
//                out.println(number);
//                Thread.sleep(2000);
//            }
//            System.out.println("disconected...");
//        } catch (Throwable cause){
//            System.out.println("error: "+ cause.getMessage());
//        }


    }
}
