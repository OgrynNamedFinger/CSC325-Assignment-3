package Design.Abstact;
public abstract class Shape {
    protected String color;
    protected String name;
    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }
    public abstract void draw();
    public abstract double getArea();
}