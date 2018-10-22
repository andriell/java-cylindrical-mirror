package com.andriell.cm.shape;

import java.awt.*;

public class PlaneImageCell2 implements PlaneImageInterface {
    private int width = 300;
    private int height = 500;

    public PlaneImageCell2(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getRGB(int x, int y) {
        if (x % 2 == 0) {
            if (y % 2 == 0) {
                return Color.RED.getRGB();
            }
            return Color.GREEN.getRGB();
        } else {
            if (y % 2 == 0) {
                return Color.BLUE.getRGB();
            }
            return Color.BLACK.getRGB();
        }
    }
}
