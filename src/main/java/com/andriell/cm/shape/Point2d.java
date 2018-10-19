package com.andriell.cm.shape;

import java.io.Serializable;

public class Point2d implements Serializable {
    public int x;
    public int y;

    public Point2d() {

    }

    public Point2d(long x, long y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
