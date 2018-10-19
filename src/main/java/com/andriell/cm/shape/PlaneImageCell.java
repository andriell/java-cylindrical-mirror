package com.andriell.cm.shape;

import java.awt.*;

public class PlaneImageCell implements PlaneImageInterface {
    private int width = 300;
    private int height = 500;
    private int step = 10;

    public PlaneImageCell(int width, int height, int step) {
        this.width = width;
        this.height = height;
        this.step = step;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getRGB(int x, int y) {
        if (x % step == 0 || y % step == 0) {
            return Color.BLACK.getRGB();
        }
        return Color.WHITE.getRGB();
    }
}
