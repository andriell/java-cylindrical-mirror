package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;

public class MathPlaneLine {
    /**
     * Координаты точки пересечения прямой и плоскости
     * @param plane Plane
     * @param line Line
     * @return Point|null
     */
    public static Point intersection(Plane plane, Line line) {
        double divider = MathVector.dotProduct(plane.n, line.p);
        if (divider == 0) {
            // Линия лежит в плоскости или параллельна плоскости
            return null;
        }
        double t = MathVectorPoint.dotProduct(plane.n, MathPoint.dif(plane.m, line.m)) / divider;
        return MathLine.getPoint(line, t);
    }
}
