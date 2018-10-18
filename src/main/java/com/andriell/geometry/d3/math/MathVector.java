package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

public class MathVector {
    /**
     * Сумма векторов
     * @param v1 Vector
     * @param v2 Vector
     * @return Point
     */
    public static Point sum(Vector v1, Vector v2) {
        return new Point(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    /**
     * Сумма вектора и точки
     * @param v Vector
     * @param p Point
     * @return Point
     */
    public static Point sum(Vector v, Point p) {
        return new Point(p.x + v.x, p.y + v.y, p.z + v.z);
    }

    /**
     * Разность векторов
     * @param v1 Vector
     * @param v2 Vector
     * @return Point
     */
    public static Point dif(Vector v1, Vector v2) {
        return new Point(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    /**
     * Разность вектора и точки
     * @param v Vector
     * @param p Point
     * @return Point
     */
    public static Point dif(Vector v, Point p) {
        return new Point(p.x - v.x, p.y - v.y, p.z - v.z);
    }

    /**
     * Скалярное произведение
     * @param v1 Vector
     * @param v2 Vector
     * @return double
     */
    public static double dotProduct(Vector v1, Vector v2) {
        return v1.x + v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    /**
     * Умножение вектора на число
     * @param v Vector
     * @param d double
     * @return Point p
     */
    public static Point product(Vector v, double d) {
        return new Point(v.x * d, v.y * d, v.z * d);
    }

    /**
     * Преобразует вектор в точку
     * @param v Vector
     * @return Point
     */
    public static Point toPoint(Vector v) {
        return new Point(v.x, v.y, v.z);
    }
}
