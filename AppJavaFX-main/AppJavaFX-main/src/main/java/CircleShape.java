import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleShape extends DrawableShape {
    public CircleShape(double x, double y, double size, Color fill, Color stroke) {
        super(x, y, size, fill, stroke);
    }

    @Override
    public void draw(GraphicsContext gc) {
        double half = size / 2.0;
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(2);
        gc.fillOval(x - half, y - half, size, size);
        gc.strokeOval(x - half, y - half, size, size);
    }
}
