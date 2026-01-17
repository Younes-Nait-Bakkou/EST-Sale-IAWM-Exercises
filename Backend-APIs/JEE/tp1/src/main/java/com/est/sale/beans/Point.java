package com.est.sale.beans;

public class Point {
    private double x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getNorme() {
        return Math.sqrt((x * x) + (y * y));
    }
}
