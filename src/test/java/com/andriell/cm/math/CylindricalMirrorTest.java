package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.cm.shape.PlaneImage;
import com.andriell.cm.shape.PlaneImageCell;
import com.andriell.cm.shape.Point2d;
import com.andriell.geometry.d3.math.MathLine;
import com.andriell.geometry.d3.shape.Point;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CylindricalMirrorTest {
    @Test
    public void matrix() {
        CylindricalMirror mirror = new CylindricalMirror(new PlaneImageCell(10, 10, 2));
        mirror.setPointEay(new Point(1E7, 0, 1E7));
        Point2d[][] matrix = mirror.matrix();
        /*for (int x = 0; x < matrix.length; x++) {
            System.out.print("{");
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print("{" + matrix[x][y].x + "," + matrix[x][y].y + "},");
            }
            System.out.println("},");
        }*/
        int[][][] matrixTrue = {
                {{-1,-11},{-1,-10},{-1,-10},{0,-9},{0,-8},{0,-7},{1,-6},{1,-5},{2,-4},{2,-3},},
                {{6,-12},{6,-11},{6,-10},{6,-9},{6,-8},{5,-7},{5,-6},{5,-5},{5,-4},{5,-3},},
                {{12,-10},{12,-9},{11,-9},{11,-8},{10,-7},{10,-6},{9,-5},{9,-4},{8,-3},{8,-3},},
                {{17,-6},{16,-6},{16,-5},{15,-4},{14,-4},{13,-3},{12,-2},{12,-2},{11,-1},{10,-1},},
                {{20,-1},{19,-1},{18,0},{17,0},{16,0},{15,1},{14,1},{13,1},{12,2},{12,2},},
                {{21,5},{20,5},{19,5},{18,5},{17,5},{16,5},{15,5},{14,5},{13,5},{12,5},},
                {{20,11},{19,11},{18,10},{17,10},{16,10},{15,9},{14,9},{13,9},{12,8},{12,8},},
                {{17,16},{16,16},{16,15},{15,14},{14,14},{13,13},{12,12},{12,12},{11,11},{10,11},},
                {{12,20},{12,19},{11,19},{11,18},{10,17},{10,16},{9,15},{9,14},{8,13},{8,12},},
                {{6,22},{6,21},{6,20},{6,19},{6,18},{5,17},{5,16},{5,15},{5,14},{5,13},},
        };
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                assertEquals(matrix[x][y].x, matrixTrue[x][y][0]);
                assertEquals(matrix[x][y].y, matrixTrue[x][y][1]);
            }
        }
    }

    /*@Test
    public void writeImage() throws Exception {
        CylindricalMirror mirror = new CylindricalMirror(new PlaneImageCell(1001, 1001, 100));
        mirror.setPointEay(new Point(1E7, 0, 1E7));
        mirror.writeImage(new File("CylindricalMirror.png"));
    }

    @Test
    public void writeImage2() throws Exception {
        CylindricalMirror mirror = new CylindricalMirror(new PlaneImage(new File("1.png")));
        mirror.setPointEay(new Point(1E7, 0, 1E7));
        mirror.writeImage(new File("2.png"));
    }*/
}
