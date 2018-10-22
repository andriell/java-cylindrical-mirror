package com.andriell.cm.gui;

import com.andriell.cm.math.CylindricalMirror;
import com.andriell.cm.shape.PlaneImage;
import com.andriell.geometry.d3.shape.Point;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private JFrame frame;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserWrite;
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

        fileChooserOpen = new JFileChooser();
        fileChooserWrite = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE FILES (*.png)", "png");
        fileChooserOpen.setAcceptAllFileFilterUsed(false);
        fileChooserOpen.setFileFilter(filter);
        fileChooserWrite.setAcceptAllFileFilterUsed(false);
        fileChooserWrite.setFileFilter(filter);

        buttonFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int retOpen = fileChooserOpen.showOpenDialog(rootPanel);
                if (retOpen == JFileChooser.APPROVE_OPTION) {
                    int retWrite = fileChooserWrite.showSaveDialog(rootPanel);
                    if (retWrite == JFileChooser.APPROVE_OPTION) {
                        try {
                            File fileWrite = fileChooserWrite.getSelectedFile();
                            if (!fileWrite.toString().toLowerCase().endsWith(".png")) {
                                fileWrite = new File(fileWrite.toString() + ".png");
                            }
                            CylindricalMirror mirror = new CylindricalMirror(new PlaneImage(fileChooserOpen.getSelectedFile()));
                            mirror.setR((Double) spinnerR.getValue());
                            mirror.getImgDpi().setDpi(Double.parseDouble(String.valueOf(comboBoxDpi.getSelectedItem())));
                            mirror.getImgDpi().setWidth((Integer) spinnerW.getValue());
                            mirror.getImgDpi().setHeight((Integer) spinnerH.getValue());
                            double angle = (Integer) spinnerAngle.getValue();
                            angle = (angle / 180f) * Math.PI;
                            mirror.setPointEay(new Point(1E7 * Math.cos(angle), 0, 1E7 * Math.sin(angle)));
                            mirror.writeImage(fileWrite);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
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
