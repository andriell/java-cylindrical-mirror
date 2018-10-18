package com.andriell.geometry.d3.shape;


// http://mathprofi.ru/uravnenija_pryamoi_v_prostranstve.html
public class Line {
    // некоторая точка пространства принадлежащая прямой
    public Point m = new Point();
    // направляющий вектор
    public Vector p = new Vector();

    public Line() {
    }

    public Line(Point m, Vector p) {
        this.m = m;
        this.p = p;
    }

    @Override
    public String toString() {
        return "Line{" +
                "m=" + m +
                ", p=" + p +
                '}';
    }
}
