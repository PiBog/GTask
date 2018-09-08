package com.gemicle.tanksgame.server.gamemechanic.gameengine;

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape.BricksWall;
import com.gemicle.tanksgame.server.gamemechanic.gameobjects.landscape.Forest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MapFromXmlReaderTest {

    @InjectMocks
    MapFromXmlReader reader;

    String FILE_NAME = "testMapConfiguration.xml";

    @Test
    public void testLoadMapFromResources_ifFileExist() throws FileNotFoundException{

        List<GameObject> expectedList = new ArrayList<>();
        expectedList.add(new Forest(50,50));
        expectedList.add(new BricksWall(100,100));

        List<GameObject> resultList = reader.loadMapFromResources(FILE_NAME);

        Assert.assertEquals(expectedList.size(), resultList.size());
        Assert.assertTrue(resultList.get(0) instanceof Forest);
        Assert.assertTrue(resultList.get(1) instanceof BricksWall);
    }

    @Test(expected = FileNotFoundException.class)
    public void testLoadMapFromResources_ifFileMissing() throws FileNotFoundException{
        reader.loadMapFromResources("");


    }


}