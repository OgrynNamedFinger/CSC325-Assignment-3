import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectShape extends Shape {

    @Override
    void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillRect(left, top, width, height);
        g.setStroke(Color.BLACK);
        g.strokeRect(left, top, width, height);
    }
}

