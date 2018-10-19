package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

public class MathLine {

    /**
     * Получить прямую проходящую через две точки
     *
     * @param p1 Point
     * @param p2 Point
     * @return Line
     */
    public static Line getLine(Point p1, Point p2) {
        return new Line(p1, new Vector(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z));
    }

    /**
     * Возвращает точку на прямой заданной в виде параметрического уравнения
     *
     * @param line Line
     * @param t    double
     * @return Point
     */
    public static Point getPoint(Line line, double t) {
        return new Point(line.p.x * t + line.m.x, line.p.y * t + line.m.y, line.p.z * t + line.m.z);
    }
}
