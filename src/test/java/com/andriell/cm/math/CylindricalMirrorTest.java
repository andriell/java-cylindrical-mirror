package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.cm.shape.PlaneImageCell;
import com.andriell.cm.shape.Point2d;
import com.andriell.geometry.d3.shape.Point;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CylindricalMirrorTest {
    @Test
    public void matrix() {
        CylindricalMirror mirror = new CylindricalMirror(new PlaneImageCell(10, 10, 2));
        mirror.setPointEay(new Point(1E7, 0, 1E7));
        Point2d[][] matrix = mirror.matrix();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print("[" + matrix[x][y].x + " " + matrix[x][y].y + "] ");
            }
            System.out.println();
        }
    }

    @Test
    public void writeImage() throws Exception {
        CylindricalMirror mirror = new CylindricalMirror(new PlaneImageCell(1001, 1001, 100));
        mirror.setPointEay(new Point(1E7, 0, 1E7));
        mirror.writeImage(new File("CylindricalMirror.png"));
    }
}
