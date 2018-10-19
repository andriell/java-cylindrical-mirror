package com.andriell.cm.math;

import com.andriell.cm.shape.CylinderZ;
import com.andriell.geometry.d3.shape.Point;
import org.junit.Test;

public class CylindricalMirrorTest {
    @Test
    public void matrix() {
        CylindricalMirror mirror = new CylindricalMirror();
        mirror.setCylinder(new CylinderZ(0, 0, 10));
        mirror.setPointEay(new Point(100, 0, 100));
        mirror.matrix();
    }
}
