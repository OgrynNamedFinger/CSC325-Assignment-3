package Design.Interface;
public class Circle2 implements Drawable {
    private String color;
    private double radius;
    public Circle2(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle2 with color " + color);
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public void describe() {
        System.out.println("Circle2: color=" + color + ", radius=" + radius);
    }
}