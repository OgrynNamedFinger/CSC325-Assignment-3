package Design.Abstact;

public class Main{
    public static void main(String[] args){
        Shape circle = new Circle("Red", "My Circle", 5);
        Shape rectangle = new Rectangle("Blue", "My Rectangle", 4, 6);
        Shape triangle = new Triangle("Yellow", "My Triangle", 3, 4);
        circle.draw();
        System.out.println("Area: " + circle.getArea());
        rectangle.draw();
        System.out.println("Area: " + rectangle.getArea());
        triangle.draw();
        System.out.println("Area: " + triangle.getArea());
    }
}