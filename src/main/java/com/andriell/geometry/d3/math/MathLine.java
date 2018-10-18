package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Point;

public class MathLine {

    /**
     * Возвращает точку на прямой заданной в виде параметрического уравнения
     * @param line Line
     * @param t double
     * @return Point
     */
    public static Point getPoint(Line line, double t) {
        return new Point(line.p.x * t + line.m.x, line.p.y * t + line.m.y, line.p.z * t + line.m.z);
    }
}
