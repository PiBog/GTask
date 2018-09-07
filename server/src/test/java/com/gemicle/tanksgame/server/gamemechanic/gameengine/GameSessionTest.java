package com.gemicle.tanksgame.server.gamemechanic.gameengine;/*Bohdan Pysarenko © All right reserved.
 *
 */

import com.gemicle.tanksgame.common.objects.GameObject;
import com.gemicle.tanksgame.common.objects.ID;
import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.landscape.WallFactory;
import com.gemicle.tanksgame.common.objects.units.AverageJoe;
import com.gemicle.tanksgame.common.objects.units.Unit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameSessionTest {

    @Mock
    GameSession gameSession;

    @Mock
    Player player;

    @Test
    public void getPlayersTank() {
    }

    @Test
    public void updPlayersTank() {
    }

    @Test
    public void addNewPlayer() {
    }

    @Test
    public void addBullet() {
    }

    @Test
    public void testGetAllGameObjects_whenOneOfCollectionsNullAndOtherEmpty_passed() {
        HashMap<ID, LinkedList<GameObject>> map = new HashMap<>();
        gameSession = new GameSession(map);

        List<GameObject> resultObject = gameSession.getAllGameObjects();

        Assert.assertTrue(resultObject.isEmpty());

    }

    @Test
    public void testGetAllGameObjects_whenSomeoneOfCollectionsHasOnlyOneValue_passed() {
        List<GameObject> expectedList = new ArrayList<>();
        expectedList.add(WallFactory.newWall(1,1,"brick"));

        HashMap<ID, LinkedList<GameObject>> map = new HashMap<>();
        map.put(ID.WALL, new LinkedList<>());
        map.put(ID.BULLET, new LinkedList<>());
        gameSession = new GameSession(map);
        gameSession.addNewPlayer(player);

        List<GameObject> resultObject = gameSession.getAllGameObjects();

        Assert.assertEquals(expectedList.size(),resultObject.size());

    }

    @Test
    public void updatePlayers() {
    }
}