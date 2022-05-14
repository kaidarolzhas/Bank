package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add extends Container {
    public Add() {
        setSize(600,400);
        setLayout(null);

        JLabel xLabel = new JLabel("XXXX-XXXX-XXXX-XXXX");
        xLabel.setBounds(285, 45, 190, 30);
        add(xLabel);

        JLabel cardLabel = new JLabel("CARD NUMBER:");
        cardLabel.setBounds(150, 75, 100, 30);
        add(cardLabel);

        JTextField cardField = new JTextField();
        cardField.setBounds(260, 75, 190, 30);
        add(cardField);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(150, 125, 100, 30);
        add(cvvLabel);

        JTextField cvvField = new JTextField();
        cvvField.setBounds(260, 125, 190, 30);
        add(cvvField);

        JLabel amountLabel = new JLabel("AMOUNT:");
        amountLabel.setBounds(150, 175, 100, 30);
        add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(260, 175, 190, 30);
        add(amountField);

        JButton addButton = new JButton("SUBMIT");
        addButton.setBounds(150, 225, 145, 30);;
        add(addButton);

        JButton backButton = new JButton("BACK TO MENU");
        backButton.setBounds(305, 225, 145, 30);
        add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Checker check = new Checker();
                try{
                    if(!check.checkCARD(cardField.getText()) || !check.checkCVV(cvvField.getText()) ){
                        JOptionPane.showMessageDialog(null, "WRONG CARD OR CVV!");

                        amountField.setText(null);
                        cardField.setText(null);
                        cvvField.setText(null);
                        amountField.setText(null);


                    }
                    else{

                        PackegeData pd = new PackegeData("ADD_MONEY",Login.customer.getUsername(),Double.parseDouble(amountField.getText()));
                        Main.connect(pd);
                        Info addMoneyInfo = new Info(null, Login.customer.getUsername());
                        PackegeData pd2 = new PackegeData("ADDMONEY_INFO", addMoneyInfo, Double.parseDouble(amountField.getText()));
                        Main.connect(pd2);
                        JOptionPane.showMessageDialog(null,"SUCCESSUl");


                    }



                }catch (Exception a){
                    a.printStackTrace();
                    JOptionPane.showMessageDialog(null,"SOMETHING WRONG!");

                    amountField.setText(null);
                    cardField.setText(null);
                    cvvField.setText(null);
                    amountField.setText(null);
                }

                amountField.setText(null);
                cardField.setText(null);
                cvvField.setText(null);
                amountField.setText(null);






            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addStudent.setVisible(false);
                Main.frame.Lmenu.setVisible(true);
            }
        });

    }
}
