package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

public class MathPoint {
    /**
     * Сумма точек
     * @param p1 Point
     * @param p2 Point
     * @return Point
     */
    public static Point sum(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y, p1.z + p2.z);
    }

    /**
     * Сумма точеки и вектора
     * @param p Point
     * @param v Point
     * @return Point
     */
    public static Point sum(Point p, Vector v) {
        return new Point(p.x + v.x, p.y + v.y, p.z + v.z);
    }

    /**
     * Разность точек
     * @param p1 Point
     * @param p2 Point
     * @return Point
     */
    public static Point dif(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);
    }

    /**
     * Разность точеки и вектора
     * @param p Point
     * @param v Vector
     * @return Point
     */
    public static Point dif(Point p, Vector v) {
        return new Point(p.x - v.x, p.y - v.y, p.z - v.z);
    }

    /**
     * Скалярное произведение точек, по аналогии с векторами
     * @param p1 Point
     * @param p2 Point
     * @return double
     */
    public static double dotProduct(Point p1, Point p2) {
        return p1.x + p2.x + p1.y * p2.y + p1.z * p2.z;
    }

    /**
     * Умножение точки на число
     * @param p Point
     * @param d double
     * @return Point p
     */
    public static Point product(Point p, double d) {
        return new Point(p.x * d, p.y * d, p.z * d);
    }

    /**
     * Преобразует точку в вектор
     * @param p Point
     * @return Vector
     */
    public static Vector toVector(Point p) {
        return new Vector(p.x, p.y, p.z);
    }
}
