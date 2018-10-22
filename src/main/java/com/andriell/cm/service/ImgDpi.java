package com.andriell.cm.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgDpi {
    // Размеры листа в миллиметрах
    private double width = 297;
    private double height = 210;
    private double dpi = 300;
    private BufferedImage image;

    public ImgDpi() {
        image = new BufferedImage(mm2px(width, dpi), mm2px(height, dpi), BufferedImage.TYPE_INT_ARGB);
    }

    public static int mm2px(double mm, double dpi) {
        return (int) Math.round(mm /  25.4 * dpi);
    }

    public static double px2mm(int px, double dpi) {
        return ((double) px) / dpi * 25.4;
    }

    public static double dpi(double mm, int px) {
        return dpi((double) px, mm);
    }

    public static double dpi(double mm, double px) {
        return px / (mm / 25.4);
    }


    public static BufferedImage resize(BufferedImage img, double d) {
        int newW = (int) Math.round(img.getWidth() * d) + 1;
        int newH = (int) Math.round(img.getHeight() * d) + 1;
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }

    public void addImage(BufferedImage img, double imgDpi) {
        BufferedImage imgResized = resize(img, dpi / imgDpi);

        Graphics2D d = (Graphics2D) image.getGraphics();
        d.setColor(Color.WHITE);
        d.fillRect(0, 0, image.getWidth(), image.getHeight());
        d.drawImage(imgResized, (image.getWidth() - imgResized.getWidth()) / 2, (image.getHeight() - imgResized.getHeight()) / 2,  null);
    }

    public void save(File file) throws IOException {
        ImageIO.write(image, "png", file);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDpi() {
        return dpi;
    }

    public void setDpi(double dpi) {
        this.dpi = dpi;
    }
}
