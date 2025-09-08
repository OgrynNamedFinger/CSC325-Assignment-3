package Design.Interface;

public class PolymorphismInterface {
    public static void main(String[] args) {
        Drawable[] shapes = {
            new Circle2("Green", 7.0),
            new Rectangle2("Yellow", 4.0, 7.0),
            new Triangle2("Red", 4, 5),
        };

        for (Drawable shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.getArea());
            shape.describe();
            System.out.println("------------------------");
        }
    }
}