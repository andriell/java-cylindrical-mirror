package com.andriell.geometry.d3.shape;


// http://mathprofi.ru/uravnenija_pryamoi_v_prostranstve.html
public class Line {
    // некоторая точка пространства принадлежащая прямой
    public Point m = new Point();
    // направляющий вектор
    public Vector p = new Vector();

    @Override
    public String toString() {
        return "Line{" +
                "m=" + m +
                ", n=" + p +
                '}';
    }
}
