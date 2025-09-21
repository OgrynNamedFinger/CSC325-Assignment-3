import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// the square shape to create squares on the canvas in a square format
public class Square extends AbstractDrawingClass {

    // Constructor using DrawableShape to initialize variables for Square
    public Square(double x, double y, double size, Color fill, Color stroke)
    {
        super(x, y, size, fill, stroke);
    }

    // overrides draw from DrawableShape through AbstractDrawingClass so that it can draw a square
    @Override
    public void draw(GraphicsContext gc)
    {
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(1);
        gc.fillRect(x - size / 2, y - size / 2, size, size);
        gc.strokeRect(x - size / 2, y - size / 2, size, size);
    }

    // overrides the AbstractDrawingClass' findArea method so it works with squares
    @Override
    protected double findArea() {
        return getSize() * getSize();
    }
}