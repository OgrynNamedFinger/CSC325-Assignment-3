package app;
import javafx.scene.canvas.GraphicsContext;
public class RectangleShape extends DrawableShape {
    private double width, height;
    public RectangleShape(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(x, y, width, height);
    }
}