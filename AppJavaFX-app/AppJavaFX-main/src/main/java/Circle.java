import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// the circle class to create circles on the canvas using the circle method
public class Circle extends AbstractDrawingClass {

    // Constructor using DrawableShape to initialize variables for Circle
    public Circle(double x, double y, double size, Color fill, Color stroke)
    {
        super(x, y, size, fill, stroke);
    }

    // overrides draw from DrawableShape through AbstractDrawingClass so that it can draw a circle
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(fill);
        gc.setStroke(stroke);
        gc.setLineWidth(1);
        gc.fillOval(x - size / 2, y - size / 2, size, size);
        gc.strokeOval(x - size / 2, y - size / 2, size, size);
    }
    
    // overrides the AbstractDrawingClass' findArea method so it works with circles
    @Override
    protected double findArea() {
        double r = getSize() / 2.0;
        return Math.PI * (r * r);
    }
}