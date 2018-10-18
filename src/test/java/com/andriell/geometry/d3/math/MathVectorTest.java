package com.andriell.geometry.d3.math;

import com.andriell.geometry.d3.shape.Line;
import com.andriell.geometry.d3.shape.Point;
import com.andriell.geometry.d3.shape.Vector;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MathVectorTest {
    @Test
    public void cos() {
        Vector v1;
        Vector v2;
        v1 = new Vector(1, 0, 0);
        v2 = new Vector(0, 10, 0);
        assertTrue(MathVector.cos(v1, v2) == 0);
        v1 = new Vector(1, 0, 0);
        v2 = new Vector(0, 0, 2);
        assertTrue(MathVector.cos(v1, v2) == 0);
        v1 = new Vector(0, 1, 0);
        v2 = new Vector(0, 0, 2);
        assertTrue(MathVector.cos(v1, v2) == 0);
        v1 = new Vector(1, 0, 0);
        v2 = new Vector(3, 4, 0);
        assertTrue(MathVector.cos(v1, v2) == 0.6);
    }
}
