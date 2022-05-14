package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Container {

    public Menu(){
        setSize(500,500);
        setLayout(null);


        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(125,100,300,40);
        add(loginButton);

        JButton signupButton = new JButton("SING");
        signupButton.setBounds(125,160,300,40);
        add(signupButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(125,220,300,40);
        add(exitButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.login.setVisible(true);
                Main.frame.menu.setVisible(false);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.signup.setVisible(true);
                Main.frame.menu.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
}
