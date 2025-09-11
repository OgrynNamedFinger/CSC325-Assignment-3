package interfacedesign.shapes;

import interfacedesign.*;

public class Triangle implements Drawable, Calculable, Describable {
    private double a, b, c;
    public Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }

    @Override
    public void draw() { System.out.println("Drawing Triangle with sides " + a + ", " + b + ", " + c); }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() { return a + b + c; }

    @Override
    public String describe() { return "Triangle with sides " + a + ", " + b + ", " + c; }
}

