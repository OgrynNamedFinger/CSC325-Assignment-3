import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

/**
 * Controller that wires UI controls to drawing logic and stores shapes.
 */
public class DrawingController {
    public enum ShapeType {RECTANGLE, CIRCLE}

    private ShapeType currentShape = ShapeType.RECTANGLE;
    private final ObservableList<DrawableShape> shapes = FXCollections.observableArrayList();
    private final Canvas canvas;
    private final GraphicsContext gc;

    public DrawingController(Canvas canvas, RadioButton rbRect, RadioButton rbCircle, Button clearButton) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        ToggleGroup tg = new ToggleGroup();
        rbRect.setToggleGroup(tg);
        rbCircle.setToggleGroup(tg);
        rbRect.setSelected(true);

        rbRect.setOnAction(e -> currentShape = ShapeType.RECTANGLE);
        rbCircle.setOnAction(e -> currentShape = ShapeType.CIRCLE);

        clearButton.setOnAction(e -> {
            shapes.clear();
            redraw();
        });

        canvas.setOnMouseClicked(ev -> {
            if (ev.getButton() != MouseButton.PRIMARY) return;
            double x = ev.getX();
            double y = ev.getY();
            double size = 70;
            Color fill = Color.web("#2E86AB", 0.8);
            Color stroke = Color.web("#04395E");
            DrawableShape s;
            if (currentShape == ShapeType.RECTANGLE) {
                s = new RectangleShape(x, y, size, fill, stroke);
            } else {
                s = new CircleShape(x, y, size, fill, stroke);
            }
            shapes.add(s);
            s.draw(gc);
        });
    }

    public ObservableList<DrawableShape> getShapes() {
        return shapes;
    }

    public void redraw() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (DrawableShape s : shapes) {
            s.draw(gc);
        }
    }
}
