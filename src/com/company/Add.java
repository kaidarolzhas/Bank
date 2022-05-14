package com.company;

import Checker.Checker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.company.DBManager.connection;

public class Add extends Container {

    public Add() {
        setSize(500,500);
        setLayout(null);

        JLabel cardLabel = new JLabel("CARD :");
        cardLabel.setBounds(125, 50, 100, 30);
        add(cardLabel);

        JTextField cardField = new JTextField();
        cardField.setBounds(225, 50, 150, 30);
        add(cardField);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(125, 100, 70, 30);
        add(cvvLabel);

        JTextField cvvField = new JTextField();
        cvvField.setBounds(225, 100, 150, 30);
        add(cvvField);

        JLabel amountLabel = new JLabel("AMOUNT:");
        amountLabel.setBounds(125, 150, 70, 30);
        add(amountLabel);


        JTextField amountField = new JTextField();
        amountField.setBounds(225, 150, 150, 30);
        add(amountField);

        JButton addButton = new JButton("SUBMIT");
        addButton.setBounds(150, 250, 240, 30);;
        add(addButton);

        JButton backButton = new JButton("BACK TO MENU");
        backButton.setBounds(150, 300, 240, 30);
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

                        String sql = "select * from  customer where username='" + Login.usname + "' ";
                        PreparedStatement statement1 = connection.prepareStatement(sql);
                        ResultSet resultSet = statement1.executeQuery();
                        while (resultSet.next()) {
                            double userMoney = resultSet.getDouble("money");
                            PreparedStatement statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + Login.usname + "'");
                            statement.setDouble(1, userMoney + Double.parseDouble(amountField.getText()));
                            statement.executeUpdate();
                            statement.close();
                            JOptionPane.showMessageDialog(null, "SUCCESSFUL!");
                            Info infoADDBALANCE = new Info(null, Login.usname, "Tops up his balance to " + Double.parseDouble(amountField.getText()) + " tg");
                            PackegeData pdp = new PackegeData("ADD_info", infoADDBALANCE);
                            Main.connect(pdp);
                            double totall = userMoney + Double.parseDouble(amountField.getText());
                            LoginedMenu.myMoney.setText("Balance: " + totall + " tg");
                        }
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
