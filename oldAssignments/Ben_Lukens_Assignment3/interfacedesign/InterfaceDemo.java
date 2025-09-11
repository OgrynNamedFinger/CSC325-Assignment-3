package interfacedesign;

import interfacedesign.shapes.*;

public class InterfaceDemo {
    public static void main(String[] args) {
        Drawable[] drawables = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4, 5)
        };

        for (Drawable d : drawables) {
            d.draw();
            if (d instanceof Calculable c) {
                System.out.println("Area: " + c.area() + ", Perimeter: " + c.perimeter());
            }
            if (d instanceof Describable desc) {
                System.out.println(desc.describe());
            }
            System.out.println();
        }
    }
}

