package com.andriell.cm.shape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlaneImage implements PlaneImageInterface {
    private BufferedImage image;

    public PlaneImage(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    }

    public PlaneImage(File file) throws IOException {
        image = ImageIO.read(file);;
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getRGB(int x, int y) {
        return image.getRGB(x,y);
    }
}
