package MainMenu;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Container {
    public Menu(){
        setSize(600,400);
        setLayout(null);

        JLabel welcome = new JLabel("WELCOME TO OUR BANK");
        welcome.setBounds(160, 50, 380, 30);
        welcome.setFont(new Font("Verdana", Font.BOLD, 20));
        add(welcome);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(125,120,350,40);
        add(loginButton);

        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBounds(125,170,350,40);
        add(signupButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(125,220,350,40);
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
