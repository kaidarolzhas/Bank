package com.company;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import javax.sound.midi.Soundbank;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import static com.company.DBManager.connection;

public class SendMoney extends Container{
    public static JLabel Error;

    public SendMoney() {
        setSize(500, 500);
        setLayout(null);

        Error = new JLabel();
        Error.setBounds(10, 10, 200, 50);
        add(Error);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(100, 100, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 200, 30);
        add(nameField);

        JLabel amountLabel = new JLabel("AMOUNT:");
        amountLabel.setBounds(100, 150, 100, 30);
        add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(200, 150, 200, 30);
        add(amountField);

        JButton SubmitButton = new JButton("SUBMIT");
        SubmitButton.setBounds(100, 200, 140, 40);
        add(SubmitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 200, 150, 40);
        add(backButton);


        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {


                    DBManager db = new DBManager();
                    db.connect();

                    if(db.getMyMoney(Login.usname)>Double.parseDouble(amountField.getText())){
                        PackegeData pd = new PackegeData("SEND_MONEY", nameField.getText(), Login.usname, Double.parseDouble(amountField.getText()));

                        Main.connect(pd);
                        JOptionPane.showMessageDialog(null,"SUCCESSFUL SENT");
                        Info sendMoneyInfo = new Info(null,Login.usname, " Sent " + Double.parseDouble(amountField.getText()) + " tg to " + nameField.getText() );
                        PackegeData pdd = new PackegeData("ADD_info",sendMoneyInfo);
                        Main.connect(pdd);
                        double totalMoney = db.getMyMoney(Login.usname)-Double.parseDouble(amountField.getText());
                        LoginedMenu.myMoney.setText("balance: " + totalMoney + " tg");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"NOT ENOUGH MONEY");
                        amountField.setText(null);
                        nameField.setText(null);
                    }








                    /*
                    String sql = "select * from  customer where username='" + Login.usname + "' ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();

                    if(resultSet.next()) {
                        double myMoney = resultSet.getDouble("money");
                        if (myMoney > Double.parseDouble(amountField.getText())) {

                            statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + nameField.getText() + "'");
                            statement.setDouble(1, Double.parseDouble(amountField.getText()));
                            statement.executeUpdate();
                            statement.close();

                            statement = connection.prepareStatement("UPDATE customer SET money=? WHERE username= '" + Login.usname + "'");
                            statement.setDouble(1, myMoney - Double.parseDouble(amountField.getText()));
                            statement.executeUpdate();
                            statement.close();

                        }

                    }
                    statement.close();



                */
                }
                catch (Exception a){
                    a.printStackTrace();

                }



                amountField.setText(null);
                nameField.setText(null);
            }

        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.smoney.setVisible(false);
                MainFrame.Lmenu.setVisible(true);
            }
        });
    }
}
