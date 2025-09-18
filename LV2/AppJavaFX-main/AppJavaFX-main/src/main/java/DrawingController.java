import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

// Controller that wires UI controls to drawing logic and stores shapes.
public class DrawingController {
    public enum ShapeType {RECTANGLE, CIRCLE}

    private ShapeType currentShape = ShapeType.RECTANGLE;
    private final ObservableList<DrawableShape> shapes = FXCollections.observableArrayList();
    private final ReadOnlyIntegerWrapper shapesSize = new ReadOnlyIntegerWrapper();
    private final ReadOnlyDoubleWrapper totalArea = new ReadOnlyDoubleWrapper();
    private final Canvas canvas;
    private final GraphicsContext gc;

    // Constructor to set up event handlers and initialize the controller
    public DrawingController(Canvas canvas, RadioButton rbRect, RadioButton rbCircle, Button clearButton) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        // Initialize properties and listeners
        shapesSize.set(shapes.size());
        totalArea.set(computeTotalArea());
        shapes.addListener((ListChangeListener<DrawableShape>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    shapesSize.set(shapes.size());
                    totalArea.set(computeTotalArea());
                }
            }
        });

        // Group the shape selection radio buttons
        ToggleGroup tg = new ToggleGroup();
        rbRect.setToggleGroup(tg);
        rbCircle.setToggleGroup(tg);
        rbRect.setSelected(true);

        // Set up event handlers
        rbRect.setOnAction(e -> currentShape = ShapeType.RECTANGLE);
        rbCircle.setOnAction(e -> currentShape = ShapeType.CIRCLE);

        // Clear button action
        clearButton.setOnAction(e -> {
            shapes.clear();
            redraw();
        });

        // Registers when you click on the canvas and creates the selected shape
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

    // Returns the observable list of shapes for binding to the ListView
    public ObservableList<DrawableShape> getShapes() {
        return shapes;
    }

    public ShapeType getSelectedShape() {
        return currentShape;
    }

    // Expose read-only properties for number of shapes and total area
    public ReadOnlyIntegerWrapper shapesSizeProperty() {
        return shapesSize;
    }

    public ReadOnlyDoubleWrapper totalAreaProperty() {
        return totalArea;
    }

    private double computeTotalArea() {
        double sum = 0.0;
        for (DrawableShape s : shapes) sum += s.getArea();
        return sum;
    }

    // Redraws all shapes on the canvas
    public void redraw() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (DrawableShape s : shapes) {
            s.draw(gc);
        }
    }
}
