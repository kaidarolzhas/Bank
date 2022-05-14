package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginedMenu extends Container {
    public static Customer customer;
    public static JLabel infoButton;
    public static JTextArea balance;
    public LoginedMenu(){
        setSize(600,400);
        setLayout(null);

        infoButton = new JLabel();
        infoButton.setFont(new Font("Courier New", Font.BOLD, 20));
        infoButton.setBounds(200,20,350,40);
        add(infoButton);

        balance = new JTextArea();
        balance.setBounds(125,65,200,40);
        add(balance);

        JButton updateBalance = new JButton("UPDATE");
        updateBalance.setBounds(375,65,100,40);
        add(updateBalance);

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

        updateBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balance.setText(null);
                PackegeData pd = new PackegeData("GET MONEY", Login.customer.getUsername());
                Main.connect(pd);
            }
        });

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
