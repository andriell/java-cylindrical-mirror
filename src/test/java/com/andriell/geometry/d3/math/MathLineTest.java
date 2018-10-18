package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathLineTest {
    @Test
    public void getPoint() {
        Line line = new Line(new Point(1, 2, 3), new Vector(5, 7, 11));
        assertEquals(MathLine.getPoint(line, 0), new Point(1, 2, 3));
        assertEquals(MathLine.getPoint(line, 1), new Point(6, 9, 14));
    }
}
