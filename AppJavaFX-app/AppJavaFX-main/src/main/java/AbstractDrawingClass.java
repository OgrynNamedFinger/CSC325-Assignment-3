import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.scene.paint.Color;

// abstract class for the circle and square subclasses, uses drawable shape interface
abstract public class AbstractDrawingClass implements DrawableShape {
    protected double size;
    protected double x;
    protected double y;
    protected Color fill;
    protected Color stroke;
    private final ReadOnlyDoubleWrapper area = new ReadOnlyDoubleWrapper();

    // constructor for variables
    protected AbstractDrawingClass(double x, double y, double size, Color fill, Color stroke)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fill = fill;
        this.stroke = stroke;
        this.area.set(findArea());
    }

    // find area method to be overridden by square and circle
    protected abstract double findArea();

    // getX method
    @Override
    public double getX() {
        return x;
    }

    // getY method
    @Override
    public double getY() {
        return y;
    }

    // getSize method
    @Override
    public double getSize() {
        return size;
    }

    // getArea method
    @Override
    public double getArea() {
        return area.get();
    }
}