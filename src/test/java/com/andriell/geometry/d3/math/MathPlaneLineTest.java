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
    public void reflection() {
        Line line = new Line(new Point(0, 0, 0), MathVector.normalize(new Vector(1, 1, 0)));
        Plane plane = new Plane(new Point(0, 0, 0), new Vector(0, 1, 0));
        Line reflection = MathPlaneLine.reflection(plane, line);

        System.out.println(line);
        System.out.println(plane);
        System.out.println(reflection);

        assertTrue(Math.abs(MathVector.dotProduct(reflection.p, line.p)) < 0.000000001);
    }

}
