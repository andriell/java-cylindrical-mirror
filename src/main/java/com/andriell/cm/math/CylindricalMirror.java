package com.andriell.cm.math;

import com.andriell.cm.service.ImgDpi;
import com.andriell.cm.shape.CylinderZ;
import com.andriell.cm.shape.PlaneImageInterface;
import com.andriell.cm.shape.Point2d;
import com.andriell.geometry.d3.math.MathLine;
import com.andriell.geometry.d3.math.MathPlaneLine;
import com.andriell.geometry.d3.math.MathVector;
import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CylindricalMirror {
    private Point pointEay;
    private CylinderZ cylinder;
    private Plane planeGround = new Plane(new Point(0, 0, 0), new Vector(0, 0, 1));
    private PlaneImageInterface image;
    private ImgDpi imgDpi = new ImgDpi();;
    private double r = 25.4;

    public CylindricalMirror(PlaneImageInterface image) {
        this.image = image;
        int imageWidth = image.getWidth();
        if (imageWidth % 2 != 0) {
            imageWidth++;
        }
        this.cylinder = new CylinderZ(0, imageWidth / 2, imageWidth / 2 + 1);
    }

    public void setPointEay(Point pointEay) {
        this.pointEay = pointEay;
    }


    /**
     * Получить плоскость на цилиндре с клоторой соприкосается линия
     *
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
        return new Plane(p, MathVector.getVector(new Point(p.x, p.y, 0), new Point(cylinder.x, cylinder.y, 0), 1));
    }

    public Point2d[][] matrix() {
        int imageW = image.getWidth();
        int imageH = image.getHeight();
        Point2d[][] r = new Point2d[imageW][];
        for (int y = 0; y < imageW; y++) {
            r[y] = new Point2d[imageH];
            Line lineEay0 = MathLine.getLine(new Point(0, y, 0), pointEay, 1);
            Plane planeCylinder = getPlane(lineEay0);

            //System.out.print(y);
            //System.out.print(planeCylinder);
            for (int z = 0; z < imageH; z++) {
                Point pointOnImage = new Point(0, y, imageH - z - 1);
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

    public void writeImage(File file) throws IOException {
        writeImage(file, false);
    }

    public void writeImage(File file, boolean debug) throws IOException {
        Point2d[][] matrix = matrix();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                minX = Math.min(minX, matrix[x][y].x);
                minY = Math.min(minY, matrix[x][y].y);
                maxX = Math.max(maxX, matrix[x][y].x);
                maxY = Math.max(maxY, matrix[x][y].y);
            }
        }
        BufferedImage image = new BufferedImage(maxX - minX + 1, maxY - minY + 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, image.getWidth() - 2, image.getHeight() - 2);

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                try {
                    int xStart = maxX - matrix[x][y].x;
                    int yStart = maxY - matrix[x][y].y;
                    //image.setRGB(xStart, yStart, this.image.getRGB(x, y));
                    int xEnd = xStart;
                    int yEnd = yStart;
                    if (x != matrix.length - 1 && y != matrix[x].length - 1) {
                        xEnd = maxX - matrix[x + 1][y + 1].x - 1;
                        yEnd = maxY - matrix[x + 1][y + 1].y - 1;
                    } else {
                        if (x != matrix.length - 1) {
                            xEnd = maxX - matrix[x + 1][y].x - 1;
                        }
                        if (y != matrix[x].length - 1) {
                            yEnd = maxY - matrix[x][y + 1].y - 1;
                        }
                    }
                    //image.setRGB(xEnd, yEnd, this.image.getRGB(x, y));
                    for (int x2 = Math.min(xStart, xEnd); x2 <= Math.max(xStart, xEnd); x2++) {
                        for (int y2 = Math.min(yStart, yEnd); y2 <= Math.max(yStart, yEnd); y2++) {
                            image.setRGB(x2, y2, this.image.getRGB(x, y));
                        }
                    }
                } catch (Exception e) {
                    System.err.println("x=" + x + " y=" + y);
                }
            }
        }

        g.setColor(Color.GREEN);
        g.draw(new Ellipse2D.Float((int) (maxX - cylinder.x - cylinder.r), (int) (maxY - cylinder.y - cylinder.r), (int) (cylinder.r * 2), (int) (cylinder.r * 2)));

        if (debug) {
            ImageIO.write(image, "png", new File(file.getAbsolutePath() + ".png"));
        }

        imgDpi.addImage(image, ImgDpi.dpi(r, cylinder.r));
        imgDpi.save(file);
    }

    public ImgDpi getImgDpi() {
        return imgDpi;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
