package gem.task.tanksgame.client.core;

import gem.task.tanksgame.client.objects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler  {

    private static LinkedList<GameObject> objects = new LinkedList<GameObject>();

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


}
