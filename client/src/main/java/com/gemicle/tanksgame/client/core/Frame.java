/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.core;

import com.gemicle.tanksgame.client.core.Connector;
import com.gemicle.tanksgame.common.objects.game.Player;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
@Log4j
@Getter
public class Frame extends JFrame {

    public static Player player;
    private Game game;


    private JPanel field = new JPanel();
    private JLabel waiting = new JLabel("Not connected.");
    private JLabel label3;

    private JTextArea chat = new JTextArea();
    private JTextField inputField = new JTextField();
    private JButton buttonSubmit = new JButton("Send");
    private JButton buttonCon = new JButton("Connect");
    private JButton buttonStart = new JButton("Start game");

    private JTextField ipInput;
    private Connector connector;


    public Frame(String title) {
        super(title);
        setBounds(30, 30, 1100, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setVisible(true);

        this.setLayout(null);
        field.setBounds(20, 20, 800, 600);
        field.setBackground(Color.BLACK);
        field.requestFocusInWindow();
        this.add(field);

        waiting.setBounds(20, 625, 800, 40);
        waiting.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(waiting);

        buttonCon.setBounds(840, 20, 240, 40);
        buttonCon.setHorizontalAlignment(SwingConstants.CENTER);
        buttonCon.setVerticalAlignment(SwingConstants.CENTER);
        buttonCon.addMouseListener(new MouseInputAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("Click");
                conectToServer();
            }
        });
        this.add(buttonCon);

        buttonStart.setBounds(840, 80, 240, 40);
        buttonStart.setHorizontalAlignment(SwingConstants.CENTER);
        buttonStart.setVerticalAlignment(SwingConstants.CENTER);
        buttonStart.setEnabled(false);
        buttonStart.addMouseListener(new MouseInputAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("Click");
//                getPlayer();
                startGame();
            }
        });
        this.add(buttonStart);

        chat.setBounds(840, 220, 240, 400);
        chat.setEditable(false);
        this.add(chat);

        inputField.setBounds(840, 630, 160, 30);
        this.add(inputField);

        buttonSubmit.setBounds(1010, 630, 70, 30);
        buttonSubmit.setHorizontalAlignment(SwingConstants.CENTER);
        buttonSubmit.setVerticalAlignment(SwingConstants.CENTER);
        this.add(buttonSubmit);

    }


    private void conectToServer() {
        log.info("try conect");

        try {
            connector = new Connector("localhost", 8080);
            if (connector.getSocket() != null) {
                buttonCon.setEnabled(false);
                buttonStart.setEnabled(true);
                waiting.setText(connector.getSocket().getRemoteSocketAddress().toString());
                addKeyBinding(field);

            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Error" + e.getStackTrace()[0]);
        }
    }

    private void addKeyBinding(JComponent component) {
        InputMap keyMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "Up");
        keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "Down");
        keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "Left");
        keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "Right");
        keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Fire");

        component.getActionMap().put("Up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action("up");
            }
        });
        component.getActionMap().put("Down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action("down");
            }
        });

        component.getActionMap().put("Left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action("left");
            }
        });
        component.getActionMap().put("Right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action("right");
            }
        });
        component.getActionMap().put("Fire", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action("fire");
            }
        });

        component.addMouseListener(new MouseInputAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("Click on field");
                component.requestFocus();
            }
        });


    }

    private void action(String string) {
        log.info("do action \"" + string + "\"");
        connector.sendCmd(string);
    }

    private void startGame() {
        this.game = new Game(this.field);
        this.action("getPlayer");
    }

}
