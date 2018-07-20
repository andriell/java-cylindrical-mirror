package com.andriell.cm.service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CylindricalMirror {
    private File imgFile;
    private File outputFile;
    private BufferedImage imageOutput;

    private int dpi;
    private int listW;
    private int listH;
    private int cylinderR;
    private int cylinderX;
    private int cylinderY;
    private int eyeH;
    private int eyeL;
    private int objectW;
    private int objectH;
    private int objectRise;

    private void init() {
        imageOutput = new BufferedImage(listW, listH, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = (Graphics2D) imageOutput.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, listW, listH);
    }

    private void point2point(int x, int y) {
        double eyeAV = Math.atan2(eyeH - y - objectH, eyeL); // Угол от глаза до точки на объекте в вертикальной плоскости
        double eyeAH = Math.atan2(objectW / 2 - x, eyeL); // Угол от глаза до точки на объекте в горизонтальной плоскости
        double cylinderA = Math.PI - Math.asin(eyeL * Math.sin(eyeAH) / cylinderR) - eyeAH; // Угол между центральной осью и радиусом
        double cylinderX = cylinderR * Math.sin(cylinderA); // X координата на цилиндре относительно его центра
        double cylinderY = cylinderR * Math.cos(cylinderA); // Y координата на цилиндре относительно его центра
        double cylinderZ = Math.tan(eyeAV) * cylinderX + x + objectRise; // Z координата на цилиндре

    }
}
