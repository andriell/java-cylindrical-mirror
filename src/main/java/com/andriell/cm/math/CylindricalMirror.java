package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.cm.shape.Point2d;
import com.andriell.geometry.d3.math.MathLine;
import com.andriell.geometry.d3.math.MathPlaneLine;
import com.andriell.geometry.d3.math.MathVector;
import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

import java.awt.geom.Point2D;

public class CylindricalMirror {
    private Point pointEay;
    private CylinderZ cylinder;
    private Plane planeGround = new Plane(new Point(0, 0, 0), new Vector(0, 0, 1));
    private int imageW = 500;
    private int imageH = 500;

    public CylindricalMirror() {

    }

    public void setPointEay(Point pointEay) {
        this.pointEay = pointEay;
    }

    public void setCylinder(CylinderZ cylinder) {
        this.cylinder = cylinder;
    }

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
        double c = Math.pow(l.m.x - cylinder.x, 2) + Math.pow(l.m.y - cylinder.y, 2) - Math.pow(cylinder.r, 2);
        double t = (Math.sqrt(b * b - 4 * a * c) - b) / (2 * a);
        Point p = MathLine.getPoint(l, t);
        return new Plane(p, MathVector.getVector(new Point(p.x, p.y, 0), new Point(l.m.x, l.m.y, 0), 1));
    }

    public Point2d[][] matrix() {
        Point2d[][] r = new Point2d[imageW][];
        for (int y = 0; y < imageW; y++) {
            r[y] = new Point2d[imageH];
            Line lineEay0 = MathLine.getLine(new Point(0, y, 0), pointEay, 1);
            Plane planeCylinder = getPlane(lineEay0);
            //System.out.print(y);
            //System.out.print(planeCylinder);
            for (int z = 0; z < imageH; z++) {
                Point pointOnImage = new Point(0, y, z);
                Line lineEay = MathLine.getLine(pointOnImage, pointEay, 1);
                Line lineReflection = MathPlaneLine.reflection(planeCylinder, lineEay);
                Point pointOnGround = MathPlaneLine.intersection(planeGround, lineReflection);
                r[y][z] = new Point2d(Math.round(pointOnGround.x), Math.round(pointOnGround.y));

                //System.out.print(pointOnImage);
                //System.out.print(lineEay);
                //System.out.print(lineReflection);
                //System.out.print(pointOnGround);
                //System.out.print("{x=" + y + ", y=" + z + "} => " + r[y][z]);
                //System.out.println();
            }
            //System.out.println();
        }
        return r;
    }
}
