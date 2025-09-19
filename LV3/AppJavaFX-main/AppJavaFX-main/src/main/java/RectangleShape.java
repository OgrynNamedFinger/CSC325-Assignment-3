import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Class for the rectangle shape, extends the AbstractDrawableShape base class
public class RectangleShape extends AbstractDrawableShape {

    // Constructor to initialize rectangle properties
    public RectangleShape(double x, double y, double size, Color fill, Color stroke) {
        super(x, y, size, fill, stroke);
    }

    // Draws the rectangle on the provided GraphicsContext
    @Override
    public void draw(GraphicsContext gc) {
        double half = getSize() / 2.0;
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(2);
        gc.fillRect(getX() - half, getY() - half, getSize(), getSize());
        gc.strokeRect(getX() - half, getY() - half, getSize(), getSize());
    }

    // Method to compute the area of the rectangle
    @Override
    protected double computeArea() {
        return getSize() * getSize();
    }
}
