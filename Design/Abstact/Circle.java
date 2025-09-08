package Design.Abstact;
public class Circle extends Shape {
    private double radius;
    public Circle(String color, String name, double radius) {
        super(color, name);
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle: " + name + " with color " + color);
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}