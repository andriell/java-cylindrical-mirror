package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Plane;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathPlaneLineTest {
    @Test
    public void intersection() {
        Line line;
        Plane plane;
        Point intersection;

        line = new Line(new Point(1, 1, 1), new Vector(-1, -1, -1));
        plane = new Plane(new Point(0, 0, 0), new Vector(0, 1, 0));
        intersection = MathPlaneLine.intersection(plane, line);
        assertEquals(intersection, new Point(0, 0, 0));

        line = new Line(new Point(12, 12, 12), new Vector(10, 10, 10));
        plane = new Plane(new Point(0, 0, 0), new Vector(0, 1, 0));
        intersection = MathPlaneLine.intersection(plane, line);
        assertEquals(intersection, new Point(0, 0, 0));
    }

    @Test
    public void reflection() {
        Line line = new Line(new Point(10, 10, 12), MathVector.normalize(new Vector(3, 3, 3)));
        Plane plane = new Plane(new Point(0, 0, 0), new Vector(0, 0, 1));
        Line reflection = MathPlaneLine.reflection(plane, line);

        System.out.println(line);
        System.out.println(reflection);

        assertEquals(reflection.m, new Point(-2, -2, 0));
        assertTrue(Math.abs(reflection.p.x + line.p.x) < 0.000000001);
        assertTrue(Math.abs(reflection.p.y + line.p.y) < 0.000000001);
        assertTrue(Math.abs(reflection.p.z - line.p.z) < 0.000000001);
    }
}
