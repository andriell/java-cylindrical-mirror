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
        for (double d = 1; d < 5; d++) {
            Line line = new Line(new Point(0, 0, 0), MathVector.normalize(new Vector(1, d, 0)));
            Plane plane = new Plane(new Point(0, 0, 0), new Vector(0, 1, 0));
            Line reflection = MathPlaneLine.reflection(plane, line);

            System.out.println(line);
            System.out.println(plane);
            System.out.println(reflection);

            assertTrue(Math.abs(reflection.p.x + line.p.x) < 0.000000001);
            assertTrue(Math.abs(reflection.p.y - line.p.y) < 0.000000001);
        }
    }
}
