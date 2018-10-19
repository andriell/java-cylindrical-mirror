package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

public class MathVector {
    /**
     * Получить вектор по двум точкам
     *
     * @param p1 Point
     * @param p2 Point
     * @return Vector
     */
    public static Vector getVector(Point p1, Point p2) {
        return new Vector(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
    }

    /**
     * Получить вектор по двум точкам и нормализовать его на величину d
     *
     * @param p1 Point
     * @param p2 Point
     * @return Vector
     */
    public static Vector getVector(Point p1, Point p2, double d) {
        double l = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2) + Math.pow(p2.z - p1.z, 2));
        if (l <= 0) {
            return null;
        }
        return new Vector((p2.x - p1.x) / l * d, (p2.y - p1.y) / l * d, (p2.z - p1.z) / l * d);
    }

    /**
     * Сумма векторов
     *
     * @param v1 Vector
     * @param v2 Vector
     * @return Vector
     */
    public static Vector sum(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    /**
     * Сумма вектора и точки
     *
     * @param v Vector
     * @param p Point
     * @return Vector
     */
    public static Vector sum(Vector v, Point p) {
        return new Vector(p.x + v.x, p.y + v.y, p.z + v.z);
    }

    /**
     * Разность векторов
     *
     * @param v1 Vector
     * @param v2 Vector
     * @return Vector
     */
    public static Vector dif(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    /**
     * Разность вектора и точки
     *
     * @param v Vector
     * @param p Point
     * @return Vector
     */
    public static Vector dif(Vector v, Point p) {
        return new Vector(p.x - v.x, p.y - v.y, p.z - v.z);
    }

    /**
     * Скалярное произведение
     *
     * @param v1 Vector
     * @param v2 Vector
     * @return double
     */
    public static double dotProduct(Vector v1, Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    /**
     * Умножение вектора на число
     *
     * @param v Vector
     * @param d double
     * @return Point p
     */
    public static Vector product(Vector v, double d) {
        return new Vector(v.x * d, v.y * d, v.z * d);
    }

    /**
     * Модуль вектора, она же длинна
     *
     * @param v Vector
     * @return double
     */
    public static double module(Vector v) {
        return Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);
    }

    /**
     * Нормализация вектора
     *
     * @param v Vector
     * @return Vector
     */
    public static Vector normalize(Vector v) {
        double l = module(v);
        if (l <= 0) {
            return null;
        }
        return new Vector(v.x / l, v.y / l, v.z / l);
    }

    /**
     * Нормализация вектора и умножение на d
     *
     * @param v Vector
     * @return Vector
     */
    public static Vector normalize(Vector v, double d) {
        double l = module(v);
        if (l <= 0) {
            return null;
        }
        return new Vector(v.x / l * d, v.y / l * d, v.z / l * d);
    }

    /**
     * Косинус угла между векторами
     *
     * @param v1 Vector
     * @param v2 Vector
     * @return double
     */
    public static double cos(Vector v1, Vector v2) {
        return dotProduct(v1, v2) / (module(v1) * module(v2));
    }

    /**
     * Преобразует вектор в точку
     *
     * @param v Vector
     * @return Point
     */
    public static Point toPoint(Vector v) {
        return new Point(v.x, v.y, v.z);
    }
}
