package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.cm.shape.Point2d;
import com.andriell.geometry.d3.shape.Point;
import org.junit.Test;

import java.util.Arrays;

public class CylindricalMirrorTest {
    @Test
    public void matrix() {
        CylindricalMirror mirror = new CylindricalMirror();
        mirror.setCylinder(new CylinderZ(0, 0, 500));
        mirror.setPointEay(new Point(10000, 0, 10000));
        Point2d[][] matrix = mirror.matrix();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print("[" + matrix[x][y].x + " " + matrix[x][y].y + "] ");
            }
            System.out.println();
        }

    }
}
