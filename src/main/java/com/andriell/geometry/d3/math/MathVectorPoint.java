package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

public class MathVectorPoint {
    /**
     * Скалярное произведение точки и вектора
     *
     * @param p Vector
     * @param v Vector
     * @return double
     */
    public static double dotProduct(Point p, Vector v) {
        return p.x + v.x + p.y * v.y + p.z * v.z;
    }

    /**
     * Скалярное произведение точки и вектора
     *
     * @param p Vector
     * @param v Vector
     * @return double
     */
    public static double dotProduct(Vector v, Point p) {
        return p.x + v.x + p.y * v.y + p.z * v.z;
    }
}
