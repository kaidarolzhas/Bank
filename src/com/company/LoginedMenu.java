package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginedMenu extends Container {
    public LoginedMenu(){
        setSize(600,400);
        setLayout(null);

        JLabel infoButton = new JLabel("INFO");
        infoButton.setBounds(125,65,350,40);
        add(infoButton);

        JButton historyButton = new JButton("TRANSACTIONS HISTORY");
        historyButton.setBounds(125,115,350,40);
        add(historyButton);

        JButton addButton = new JButton("ADD BALANCE");
        addButton.setBounds(125,165,350,40);
        add(addButton);

        JButton sendButton = new JButton("SEND TO MONEY");
        sendButton.setBounds(125,215,350,40);
        add(sendButton);

        JButton LogutButton = new JButton("EXIT");
        LogutButton.setBounds(125,265,350,40);
        add(LogutButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addStudent.setVisible(true);
                Main.frame.Lmenu.setVisible(false);
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.historyMenu.setVisible(true);
                Main.frame.Lmenu.setVisible(false);
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.Lmenu.setVisible(false);
                Main.frame.smoney.setVisible(true);
            }
        });

        LogutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Main.frame.Lmenu.setVisible(false);
                Main.frame.menu.setVisible(true);
            }
        });
    }
}
