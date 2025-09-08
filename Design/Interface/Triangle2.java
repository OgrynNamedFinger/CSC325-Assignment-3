package Design.Interface;
public class Triangle2 implements Drawable {
    private String color;
    private double base;
    private double height;
    public Triangle2(String color, double base, double height) {
        this.color = color;
        this.base = base;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Triangle2 with color " + color);
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    @Override
    public void describe() {
        System.out.println("Triangle2: color=" + color + ", base=" + base + ", height=" + height);
    }
    
}
