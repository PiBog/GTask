package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.common.objects.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Handler  {

    private static LinkedList<GameObject> objects = new LinkedList<>();

    private Connector currentConn;

    public Handler() {
    }

    public Handler(Connector currentConn){
        this.currentConn = currentConn;
    }

    public void addObj(GameObject machine) {
        objects.add(machine);
    }

    public LinkedList<GameObject> getObjList(){
        return  objects;
    }

    public void render(Graphics g){
        for (int i=0; i< objects.size(); i++){
            objects.get(i).render(g);
        }
    }

    public void sendKeyAction(KeyEvent keyEvent){
        currentConn.buffer=keyEvent.toString();
    }


}
