/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.common.objects.game.Player;
import com.gemicle.tanksgame.common.objects.units.SimpleTank;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

/**
 * An implementation of
 *
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
@Setter
public class Game {

    private Player player;
    private HashMap<Player,SimpleTank> activePlayers;

    private JComponent field;

    public Game(JComponent field) {
        this.field = field;
    }

}
