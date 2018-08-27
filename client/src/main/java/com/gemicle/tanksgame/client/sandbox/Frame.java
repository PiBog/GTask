/*Gemicle Inc. © 2012 - 2018. All right reserved.
 *
 *
 *
 */
package com.gemicle.tanksgame.client.sandbox;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

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

    private JPanel field = new JPanel();
    private JLabel waiting = new JLabel("Not connected.");
    private JLabel label3;

    private JTextArea chat = new JTextArea();
    private JTextField inputField = new JTextField();
    private JButton buttonSubmit = new JButton("Send");
    private JButton buttonCon = new JButton("Connect");

    private JTextField ipInput;


    public Frame(String title){
        super(title);
        setBounds(30, 30, 1100, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.setVisible(true);

        this.setLayout(null);
        field.setBounds(20,20,800,600);
        field.setBackground(Color.BLACK);
        this.add(field);

        waiting.setBounds(20,625, 800,40);
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
//                super.mouseClicked(e);
            }
        });
        this.add(buttonCon);

        chat.setBounds(840, 220, 240, 400);
        this.add(chat);

        inputField.setBounds(840, 630, 160, 30);
        this.add(inputField);

        buttonSubmit.setBounds(1010, 630, 70, 30);
        buttonSubmit.setHorizontalAlignment(SwingConstants.CENTER);
        buttonSubmit.setVerticalAlignment(SwingConstants.CENTER);
        this.add(buttonSubmit);

    }

    void conectToServer(){
        log.info("try conect");
//        buttonCon.setVisible(false);
    }

}
