package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.geometry.d3.math.MathLine;
import com.andriell.geometry.d3.math.MathPoint;
import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;

public class CylindricalMirror {
    private CylinderZ cylinder;


    /**
     * Получить плоскость на цилиндре с клоторой соприкосается линия
     * @param l Line
     * @return Plane
     */
    public Plane getPlane(Line l) {
        // Находим пересечение прямой и круга решая квадратное уравнение через дискриминант
        // Исходные уравнения
        // x = l.p.x * t + l.m.x
        // y = l.p.y * t + l.m.y
        // (x - cylinder.x) ^ 2 + (y - cylinder.y) ^ 2 = cylinder.r ^ 2
        // Подставляем первые два уравнения в третье
        // (l.p.x * t + l.m.x - cylinder.x) ^ 2 + (l.p.y * t + l.m.y - cylinder.y) ^ 2 = cylinder.r ^ 2
        // t ^ 2 * (l.p.x ^ 2 + l.p.y ^ 2) + t * 2 * (l.p.x * (l.m.x - cylinder.x) + l.p.y * (l.m.y - cylinder.y)) + (l.m.x - cylinder.x) ^ 2 + (l.m.y - cylinder.y) ^ 2 - cylinder.r ^ 2 = 0
        double a = Math.pow(l.p.x, 2) + Math.pow(l.p.y, 2);
        double b = 2 * (l.p.x * (l.m.x - cylinder.x) + l.p.y * (l.m.y - cylinder.y));
        double c = Math.pow(l.m.x - cylinder.x, 2) + Math.pow(l.m.y - cylinder.y, 2) + Math.pow(cylinder.r, 2);
        double t = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
        Point p = MathLine.getPoint(l, t);
        return new Plane(p, MathPoint.getVector(p, l.m));
    }


}
