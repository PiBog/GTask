package com.gemicle.tanksgame.client.controls;

import com.gemicle.tanksgame.client.core.Handler;
import com.gemicle.tanksgame.client.objects.units.Machine;
import org.apache.log4j.Logger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    private static final Logger LOGGER = Logger.getLogger(Keyboard.class.getName());

    public Handler handler;

    public Keyboard(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        for (int i = 0; i < handler.getObjList().size(); i++) {
            if (handler.getObjList().get(i) instanceof Machine) {
                Machine temp = (Machine) handler.getObjList().get(i);
                int keyCode = event.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_W:
                        temp.moveY(-1);
                        break;
                    case KeyEvent.VK_S:
                        temp.moveY(1);
                        break;
                    case KeyEvent.VK_A:
                        temp.moveX(-1);
                        break;
                    case KeyEvent.VK_D:
                        temp.moveX(1);
                        break;
                    default:
                        break;
                }
//                LOGGER.info("offset: " + temp.getPosX() + "," + temp.getPosY());
            }
        }
    }

//    public void keyReleased(KeyEvent event){
//        for (int i = 0; i < handler.getObjList().size(); i++) {
//            Machine temp = handler.getObjList().get(i);
//            int keyCode = event.getKeyCode();
//            switch (keyCode) {
//                case KeyEvent.VK_W:
//                    yPos = 0;
//                    break;
//                case KeyEvent.VK_S:
//                    yPos = 0;
//                    break;
//                case KeyEvent.VK_A:
//                    xPos = 0;
//                    break;
//                case KeyEvent.VK_D:
//                    xPos = 0;
//                    break;
//                default:
//                    break;
//            }
////            temp.moveX(xPos);
////            temp.moveY(yPos);
//        }
//    }


}
