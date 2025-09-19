import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.scene.paint.Color;

// Abstract base class providing common fields and area property for shapes, implements DrawableShape.
public abstract class AbstractDrawableShape implements DrawableShape {

    // Protected variables for use in subclasses
    protected final double x;
    protected final double y;
    protected final double size;
    protected final Color fill;
    protected final Color stroke;

    // Area property set to read-only
    private final ReadOnlyDoubleWrapper area = new ReadOnlyDoubleWrapper();

    // Constructor to initialize common shape properties
    protected AbstractDrawableShape(double x, double y, double size, Color fill, Color stroke) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fill = fill;
        this.stroke = stroke;
        this.area.set(computeArea());
    }

    // Abstract method for subclasses to implement area calculation
    protected abstract double computeArea();

    // Implementations of DrawableShape interface methods
    @Override
    public ReadOnlyDoubleProperty areaProperty() {
        return area.getReadOnlyProperty();
    }

    // Implementations of DrawableShape interface methods
    @Override
    public double getArea() {
        return area.get();
    }

    // Getters for position (x, y) and size
    @Override
    public double getX() { return x; }

    @Override
    public double getY() { return y; }

    @Override
    public double getSize() { return size; }
}
