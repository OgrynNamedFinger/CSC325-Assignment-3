import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Abstract representation of a drawable shape.
 */
public abstract class DrawableShape {
    protected final double x;
    protected final double y;
    protected final double size;
    protected final Color fill;
    protected final Color stroke;

    public DrawableShape(double x, double y, double size, Color fill, Color stroke) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.fill = fill;
        this.stroke = stroke;
    }

    public abstract void draw(GraphicsContext gc);

    @Override
    public String toString() {
        return String.format("%s (%.0f, %.0f)", getClass().getSimpleName(), x, y);
    }
}
