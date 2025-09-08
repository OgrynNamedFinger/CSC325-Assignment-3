package Design.Interface;
public class Rectangle2 implements Drawable {
    private String color;
    private double width;
    private double height;
    public Rectangle2(String color, double width, double height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle2 with color " + color);
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public void describe() {
        System.out.println("Rectangle2: color=" + color + ", width=" + width + ", height=" + height);
    }
}