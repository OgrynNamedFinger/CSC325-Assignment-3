import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Class for the rectangle shape, extends the DrawableShape abstract class
public class RectangleShape extends DrawableShape {

    public RectangleShape(double x, double y, double size, Color fill, Color stroke) {
        super(x, y, size, fill, stroke);
    }

    // Draws the rectangle on the provided GraphicsContext
    @Override
    public void draw(GraphicsContext gc) {
        double half = size / 2.0;
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(2);
        gc.fillRect(x - half, y - half, size, size);
        gc.strokeRect(x - half, y - half, size, size);
    }

    @Override
    protected double computeArea() {
        return size * size;
    }
}
