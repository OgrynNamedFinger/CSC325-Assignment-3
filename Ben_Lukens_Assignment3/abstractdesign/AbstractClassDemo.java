package abstractdesign;

import abstractdesign.shapes.Shape;
import abstractdesign.shapes.Circle;
import abstractdesign.shapes.Rectangle;
import abstractdesign.shapes.Triangle;

public class AbstractClassDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4, 5)
        };

        for (Shape s : shapes) {
            s.draw();
            System.out.println(s.describe());
            System.out.println("Area: " + s.area() + ", Perimeter: " + s.perimeter());
            System.out.println();
        }
    }
}

