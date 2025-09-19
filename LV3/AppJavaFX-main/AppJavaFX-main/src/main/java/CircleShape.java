import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Class for the circle shape, extends the AbstractDrawableShape base class
public class CircleShape extends AbstractDrawableShape {

    // Constructor to initialize circle properties
    public CircleShape(double x, double y, double size, Color fill, Color stroke) {
        super(x, y, size, fill, stroke);
    }

    // Draws the circle on the provided GraphicsContext
    @Override
    public void draw(GraphicsContext gc) {
        double half = getSize() / 2.0;
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(2);
        gc.fillOval(getX() - half, getY() - half, getSize(), getSize());
        gc.strokeOval(getX() - half, getY() - half, getSize(), getSize());
    }

    // Method to compute the area of the circle
    @Override
    protected double computeArea() {
        double radius = getSize() / 2.0;
        return Math.PI * radius * radius;
    }
}
