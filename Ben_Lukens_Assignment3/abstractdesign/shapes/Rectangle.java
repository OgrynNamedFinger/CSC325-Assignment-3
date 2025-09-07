package abstractdesign.shapes;

import abstractdesign.shapes.Shape;

public class Rectangle extends Shape {
    private double width, height;
    public Rectangle(double width, double height) { this.width = width; this.height = height; }

    @Override
    public void draw() { System.out.println("Drawing Rectangle " + width + " x " + height); }

    @Override
    public double area() { return width * height; }

    @Override
    public double perimeter() { return 2 * (width + height); }

    @Override
    public String describe() { return "Rectangle with width " + width + " and height " + height; }
}

