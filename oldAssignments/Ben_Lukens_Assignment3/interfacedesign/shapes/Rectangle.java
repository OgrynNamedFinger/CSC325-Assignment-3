package interfacedesign.shapes;

import interfacedesign.*;

public class Rectangle implements Drawable, Calculable, Describable {
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

