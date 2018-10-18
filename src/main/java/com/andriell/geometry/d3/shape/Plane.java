package com.andriell.geometry.d3.shape;

// http://mathprofi.ru/uravnenie_ploskosti.html
public class Plane {
    // некоторая точка пространства принадлежащая плоскости
    public Point m = new Point();
    // перпендикулярный вектор
    public Vector n = new Vector();

    @Override
    public String toString() {
        return "Plane{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }
}
