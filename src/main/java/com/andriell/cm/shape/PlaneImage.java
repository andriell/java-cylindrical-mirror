package com.andriell.cm.shape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlaneImage implements PlaneImageInterface {
    private BufferedImage image;

    public PlaneImage(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
    }

    public PlaneImage(File file) throws IOException {
        image = ImageIO.read(file);;
    }

    public int getRGB(int x, int y) {
        int rgb =  image.getRGB(x,y);
        int red   = (rgb & 0x00ff0000) >> 16;
        int green = (rgb & 0x0000ff00) >> 8;
        int blue  =  rgb & 0x000000ff;
        //System.out.println("RGB[" + red + ", " + green + ", " + blue + "]");
        System.out.println("x=" + x + ", y=" + y + " rgb = " + String.format("0x%08X", rgb));
        return rgb;
    }


}
