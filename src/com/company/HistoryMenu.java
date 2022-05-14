package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryMenu extends Container {
    public static JTextArea textArea;
    public HistoryMenu(){
        setSize(600,400);
        setLayout(null);

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        JLabel historyLabel = new JLabel("  TRANSACTIONS HISTORY");
        historyLabel.setBorder(solidBorder);
        historyLabel.setFont(new Font("Courier New", Font.PLAIN, 16));
        historyLabel.setBounds(185,20,240,40);
        add(historyLabel);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(100, 70, 400, 30);
        add(listButton);

        textArea = new JTextArea();
        textArea.setBounds(100, 105, 400, 180);
        add(textArea);

        JButton backButton = new JButton("BACK TO MENU");
        backButton.setBounds(100, 290, 400, 30);
        add(backButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackegeData pd = new PackegeData("LIST_info", Login.customer.getUsername());
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.historyMenu.setVisible(false);
                Main.frame.Lmenu.setVisible(true);
            }
        });
    }
}
