import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RoundRectShape extends Shape {

    @Override
    void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillRoundRect(left, top, width, height, width / 3, height / 3);
        g.setStroke(Color.BLACK);
        g.strokeRoundRect(left, top, width, height, width / 3, height / 3);
    }
}

