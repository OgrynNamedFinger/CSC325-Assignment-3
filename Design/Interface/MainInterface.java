package Design.Interface;

public class MainInterface {
    public static void main(String[] args) {
        Circle2 circle = new Circle2(" Green", 7.0);
        Rectangle2 rectangle = new Rectangle2(" Yellow", 3.0, 8.0);
        Triangle2 triangle = new Triangle2(" Red", 3.0, 4.0);

        circle.draw();
        System.out.println("Area: " + circle.getArea());
        circle.describe();

        System.out.println("------------------------");

        rectangle.draw();
        System.out.println("Area: " + rectangle.getArea());
        rectangle.describe();

        //System.out.println("------------------------");

        triangle.draw();
        System.out.println("Area: " + triangle.getArea());
        triangle.describe();
    }
}
