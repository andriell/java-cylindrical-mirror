package com.andriell.cm.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame {
    private JFrame frame;
    private JFileChooser fileChooser;
    private File dataFile;


    private JPanel rootPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JButton buttonFile;

    public void show() {
        frame = new JFrame("Cylindrical mirror");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1252, 875);
        frame.setContentPane(rootPanel);

        fileChooser = new JFileChooser();

        buttonFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ret = fileChooser.showOpenDialog(rootPanel);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    dataFile = fileChooser.getSelectedFile();
                }
            }
        });

        frame.setVisible(true);
    }
}
