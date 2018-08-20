package gem.task.tanksgame.client.core;

import gem.task.tanksgame.client.objects.Machine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Handler  {

    private static LinkedList<Machine> objects = new LinkedList<Machine>();

    public void addObj(Machine machine) {
        objects.add(machine);
    }

    public LinkedList<Machine> getObjList(){
        return  objects;
    }

    public void render(Graphics g){
        for (int i=0; i< objects.size(); i++){
            objects.get(i).render(g);
        }
    }


}
