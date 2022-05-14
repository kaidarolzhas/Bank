package com.company;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static SendMoney smoney;
    public static Menu menu;
    public static Add addStudent;
    public static Login login;
    public static LoginedMenu Lmenu;
    public static HistoryMenu historyMenu;
    public static Signup signup;

    public MainFrame(){
        setSize(600,400);
        setTitle("Student Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        menu = new Menu();
        menu.setVisible(true);
        menu.setLocation(0,0);
        add(menu);




        addStudent = new Add();
        addStudent.setLocation(0,0);
        addStudent.setVisible(false );
        add(addStudent);

        smoney = new SendMoney();
        smoney.setLocation(0,0);
        smoney.setVisible(false);
        add(smoney);


        login = new Login();
        login.setLocation(0,0);
        login.setVisible(false);
        add(login);

        Lmenu = new LoginedMenu();
        Lmenu.setLocation(0,0);
        Lmenu.setVisible(false);
        add(Lmenu);

        signup = new Signup();
        signup.setLocation(0,0);
        signup.setVisible(false);
        add(signup);

        /*success = new Success("dd");
        success.setLocation(0,0);
        success.setVisible(false);
        add(success);*/

        historyMenu = new HistoryMenu();
        historyMenu.setLocation(0,0);
        historyMenu.setVisible(false);
        add(historyMenu);

    }




}
