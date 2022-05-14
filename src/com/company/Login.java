package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static com.company.DBManager.connection;


public class Login extends Container {
    public static Customer customer;
    public Login() {
        setSize(500, 500);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(125, 100, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(225, 100, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(125, 150, 100, 30);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(225, 150, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setBounds(125, 200, 140, 40);
        add(logInButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(275, 200, 150, 40);
        add(backButton);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBManager result = new DBManager();
                    result.connect();
                    Statement stmt = connection.createStatement();
                    String sql = "select * from  customer where username='"  + loginField.getText() + "' and password='" + passwordField.getText() +  "' ";
                    ResultSet rs = stmt.executeQuery(sql);

                    PackegeData pd = new PackegeData("GET CUSTOMER", loginField.getText());
                    Main.connect(pd);

                    if(rs.next()){
                        MainFrame.login.setVisible(false);
                        MainFrame.Lmenu.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Welcome " + customer.getName());
                        LoginedMenu.infoButton.setText("Username: " + customer.getUsername());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Login or Username wrong!");
                    }
                } catch(Exception a){
                    a.printStackTrace();
                }
                loginField.setText(null);
                passwordField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.login.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
    }
}
