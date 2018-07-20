package com.andriell.cm.gui;

import javax.swing.*;

public class MainFrame {
    JFrame frame;
    private JPanel rootPanel;

    public void show() {
        frame = new JFrame("Cylindrical mirror");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1252, 875);
        frame.setContentPane(rootPanel);

        frame.setVisible(true);
    }
}
