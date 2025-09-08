package Design.Abstact;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, String name, double base, double height) {
        super(color, name);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle: " + name + " with color " + color);
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    
}
