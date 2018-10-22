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
    private JPanel centerPanelDpi;
    private JButton buttonFile;
    private JSpinner spinnerR;
    private JSpinner spinnerAngle;
    private JComboBox comboBoxDpi;
    private JSpinner spinnerH;
    private JSpinner spinnerW;
    private JButton buttonA4;
    private JButton buttonA3;
    private JButton buttonA2;
    private JButton buttonA1;
    private JButton buttonRotation;

    public void show() {
        frame = new JFrame("Cylindrical mirror");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 280);
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

        buttonA1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spinnerW.setValue(594);
                spinnerH.setValue(841);
            }
        });
        buttonA2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spinnerW.setValue(420);
                spinnerH.setValue(594);
            }
        });
        buttonA3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spinnerW.setValue(297);
                spinnerH.setValue(420);
            }
        });
        buttonA4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spinnerW.setValue(210);
                spinnerH.setValue(297);
            }
        });
        buttonRotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer w = (Integer) spinnerW.getValue();
                Integer h = (Integer) spinnerH.getValue();
                spinnerW.setValue(h);
                spinnerH.setValue(w);
            }
        });
        frame.setVisible(true);
    }

    private void createUIComponents() {
        comboBoxDpi = new JComboBox();
        comboBoxDpi.addItem("50");
        comboBoxDpi.addItem("100");
        comboBoxDpi.addItem("150");
        comboBoxDpi.addItem("300");
        comboBoxDpi.setSelectedIndex(3);
        spinnerR = new JSpinner(new SpinnerNumberModel(25.4, 0, 1000.0, 0.1));
        spinnerAngle = new JSpinner(new SpinnerNumberModel(45, 10, 80, 1));
        spinnerW = new JSpinner(new SpinnerNumberModel(210, 10, 10000, 1));
        spinnerH = new JSpinner(new SpinnerNumberModel(297, 10, 10000, 1));
    }
}
