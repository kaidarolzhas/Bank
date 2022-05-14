package MainMenu;

import Main.MainFrame;
import Database.DBManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static Database.DBManager.connection;
import static UserMenu.LoginedMenu.myMoney;
import static UserMenu.LoginedMenu.uname;

public class Login extends Container {
    public static String name;
    public static String lname;
    public static String usname;

    public Login() {
        setSize(600, 400);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(150, 100, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(250, 100, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(150, 150, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(250, 150, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setBounds(150, 200, 140, 40);
        add(logInButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(300, 200, 150, 40);
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
                    if(rs.next()){
                        lname = rs.getNString("surname");
                        name = rs.getNString("name");
                        usname = rs.getNString("username");


                        uname.setText("User: " + lname + " " + name);

                        MainFrame.login.setVisible(false);
                        MainFrame.Lmenu.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Welcome " + lname + " " + name);
                        myMoney.setText( "balance: " + result.getMyMoney(loginField.getText()) + " tg");



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
