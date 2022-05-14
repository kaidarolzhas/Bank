package UserMenu;

import Database.PackegeData;
import Main.Main;
import MainMenu.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginedMenu extends Container {
    public static  JTextArea textArea;
    public static JLabel myMoney;

    public static JLabel uname;

    public LoginedMenu(){
        setSize(600,400);
        setLayout(null);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(50,75,150,40);
        add(listButton);

        JButton addButton = new JButton("ADD BALANCE");
        addButton.setBounds(50,125,150,40);
        add(addButton);

        JButton Send = new JButton("SEND");
        Send.setBounds(50,175,150,40);
        add(Send);

        JButton LogutButton = new JButton("BACK");
        LogutButton.setBounds(50,215,150,40);
        add(LogutButton);


        JLabel title = new JLabel("TRANSACTIONS HISTORY");
        title.setBounds(240,5,300,40);
        add(title);

        JLabel tip = new JLabel("CLICK TO THE 'LIST' TO RELOAD ");
        tip.setBounds(240,20,300,50);
        add(tip);

        myMoney = new JLabel( );
        myMoney.setBounds(10,20,300,40);
        add(myMoney);

        uname = new JLabel();
        uname.setBounds(10,5,300,40);
        add(uname);

        textArea = new JTextArea();
        textArea.setBounds(210, 75, 300, 250);
        textArea.setEditable(false);
        add(textArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addStudent.setVisible(true);
                Main.frame.Lmenu.setVisible(false);
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackegeData pd = new PackegeData("LIST_info", Login.usname);
                Main.connect(pd);
                System.out.println(Login.usname);
            }
        });



        Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.smoney.setVisible(true);
                Main.frame.Lmenu.setVisible(false);
            }
        });

        LogutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Main.frame.menu.setVisible(true);
                Main.frame.Lmenu.setVisible(false);
            }
        });



    }

}
