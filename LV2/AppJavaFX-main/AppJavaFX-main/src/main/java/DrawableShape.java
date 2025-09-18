import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


// Abstract representation of a drawable shape.
public abstract class DrawableShape {
    protected final double x;
    protected final double y;
    protected final double size;
    protected final Color fill;
    protected final Color stroke;

    // read-only property for area (computed by subclasses)
    private final ReadOnlyDoubleWrapper area = new ReadOnlyDoubleWrapper();

    // Constructor to initialize the shape's properties
    public DrawableShape(double x, double y, double size, Color fill, Color stroke) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fill = fill;
        this.stroke = stroke;
        // initialize area
        this.area.set(computeArea());
    }

    // Abstract method to draw the shape on the provided GraphicsContext
    public abstract void draw(GraphicsContext gc);

    // Subclasses compute their area
    protected abstract double computeArea();

    // Expose area as a read-only DoubleProperty for JavaFX bindings
    public ReadOnlyDoubleProperty areaProperty() {
        return area.getReadOnlyProperty();
    }

    public double getArea() {
        return area.get();
    }

    // String representation for display in ListView
    @Override
    public String toString() {
        return String.format("%s (%.0f, %.0f)", getClass().getSimpleName(), x, y);
    }
}
