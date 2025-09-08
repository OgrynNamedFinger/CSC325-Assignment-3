package Design.Abstact;

public class Polymorphism extends Shape {

    public Polymorphism(String color) {
        super(color, "Polymorphism"); 
    }

    @Override
    public void draw() {
        System.out.println("Drawing Polymorphism shape with color: " + color);
    }

    @Override
    public double getArea() {
        return 0;
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle("Red", "Circle", 8),
            new Rectangle("Blue", "Rectangle", 3, 5),
            new Triangle("Green", "Triangle", 2, 3),
        };
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.getArea());
        }
    }
}