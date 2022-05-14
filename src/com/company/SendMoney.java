package com.company;

import com.company.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMoney extends Container{

    public static JLabel Error;
    public static Customer customer;

    public SendMoney() {
        setSize(600, 400);
        setLayout(null);

        Error = new JLabel();
        Error.setBounds(10, 10, 200, 50);
        add(Error);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(150, 100, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(250, 100, 200, 30);
        add(nameField);

        JLabel amountLabel = new JLabel("AMOUNT:");
        amountLabel.setBounds(150, 150, 100, 30);
        add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(250, 150, 200, 30);
        add(amountField);

        JButton SubmitButton = new JButton("SUBMIT");
        SubmitButton.setBounds(150, 200, 145, 40);
        add(SubmitButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(305, 200, 145, 40);
        add(backButton);


        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackegeData pd0 = new PackegeData("GET CUSTOMER", Login.customer.getUsername());
                    Main.connect(pd0);
                    if(customer.getMoney()>Double.parseDouble(amountField.getText())){
                        PackegeData pd = new PackegeData("SEND_MONEY",customer.getUsername(),nameField.getText(),Double.parseDouble(amountField.getText()));
                        Main.connect(pd);
                        Info sendMoneyInfo = new Info(null,Login.customer.getUsername());
                        PackegeData pd2 = new PackegeData("ADDSEND_info", sendMoneyInfo, nameField.getText(), Double.parseDouble(amountField.getText()));
                        Main.connect(pd2);
                        JOptionPane.showMessageDialog(null,"SUCCESSFUL SENT");
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
                Main.frame.smoney.setVisible(false);
                Main.frame.Lmenu.setVisible(true);
            }
        });
    }
}
