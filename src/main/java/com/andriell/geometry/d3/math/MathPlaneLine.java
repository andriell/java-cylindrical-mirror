package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

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

    /**
     * Отражение линии от плоскости.
     * Возвращается новая линия с началом в точке пересечения исходной линии и плоскости
     * Угол падения равен углу отражения
     * @param plane Plane
     * @param line Line
     * @return Line
     */
    public static Line reflection(Plane plane, Line line) {
        Line reflection = new Line();
        reflection.m = intersection(plane, line);
        if (reflection.m == null) {
            // Линия лежит в плоскости или параллельна плоскости
            return null;
        }
        reflection.p = MathVector.dif(MathVector.normalize(plane.n, 1 / MathVector.cos(plane.n, line.p)), MathVector.normalize(line.p));
        return reflection;
    }
}
