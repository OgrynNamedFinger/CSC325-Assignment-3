package Design.Abstact;
public class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(String color, String name, double width, double height) {
        super(color, name);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle: " + name + " with color " + color);
    }
    @Override
    public double getArea() {
        return width * height;
    }
}