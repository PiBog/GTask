/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape.WallFactory;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * A class needs for reading map structure from xml configuration file
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
public class MapFromXmlReader {

    public MapFromXmlReader() {
    }

    public LinkedList<GameObject> loadMapFromResources(String fileName) throws FileNotFoundException{

        LinkedList<GameObject> landscape = new LinkedList<>();

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            log.info(file.getAbsolutePath());

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = dBuilder.parse(file);
            document.getDocumentElement().normalize();

            log.info("Root element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("wall");
            log.info("Node list: " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {

                Element item = (Element) nList.item(i);
                log.info("X: " + item.getElementsByTagName("type").item(0).getTextContent());
                int posX = Integer.parseInt(item
                        .getElementsByTagName("posX")
                        .item(0).getTextContent());
                int posY = Integer.parseInt(item
                        .getElementsByTagName("posY")
                        .item(0).getTextContent());
                String type = item
                        .getElementsByTagName("type")
                        .item(0).getTextContent();

                landscape.add(WallFactory.newWall(posX*1000, posY*1000, type));

                /*if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) node;
                    landscape.add(WallFactory.newWall(Integer.valueOf(item.getAttribute("posX")),
                            Integer.valueOf(item.getAttribute("posY")), item.getAttribute("type")));
                }*/
            }


        } catch (Exception e) {
            log.error("sos", e);
            throw new FileNotFoundException("File \""+fileName+"\" not found");
        }

        return landscape;
    }


}
