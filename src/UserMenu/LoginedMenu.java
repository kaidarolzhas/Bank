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




        setSize(500,500);
        setLayout(null);

        JLabel title = new JLabel("TRANSACTIONS HISTORY");
        title.setBounds(240,5,300,40);
        add(title);

        JLabel tip = new JLabel("CLICK TO THE 'LIST' TO RELOAD ");
        tip.setBounds(240,20,300,50);
        add(tip);


        JButton addButton = new JButton("ADD BALANCE");
        addButton.setBounds(10,160,130,20);
        add(addButton);

        JButton listButton = new JButton("List");
        listButton.setBounds(10,210,130,20);
        add(listButton);



        myMoney = new JLabel( );
        myMoney.setBounds(10,20,300,40);
        add(myMoney);

        uname = new JLabel();
        uname.setBounds(10,5,300,40);
        add(uname);







        textArea = new JTextArea();
        textArea.setBounds(180, 60, 400, 250);
        textArea.setEditable(false);
        add(textArea);

        JButton LogutButton = new JButton("LOGOUT");
        LogutButton.setBounds(10,60,130,20);
        add(LogutButton);

        JButton Send = new JButton("SEND");
        Send.setBounds(10,110,130,20);
        add(Send);

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
