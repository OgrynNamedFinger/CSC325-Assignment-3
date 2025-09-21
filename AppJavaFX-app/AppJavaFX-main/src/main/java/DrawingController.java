
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

// the inner workings of the app, helps pass along logic to the canvas and stuff such as refreshing the canvas and clearing shapes
public class DrawingController {
    public enum ShapeType {SQUARE, CIRCLE}
    private final Canvas canvas;
    private final GraphicsContext gc;
    private ShapeType currentShape = ShapeType.SQUARE;
    private final ObservableList<DrawableShape> shapes = FXCollections.observableArrayList();
    private final ReadOnlyIntegerWrapper shapesSizes = new ReadOnlyIntegerWrapper();
    private final ReadOnlyDoubleWrapper totalArea = new ReadOnlyDoubleWrapper();

    // constructor for the object + creates canvas and colors it white, controls drawing
    public DrawingController(Canvas canvas, Button btnClear, RadioButton btnSqr, RadioButton btnCircle) {
    this.canvas = canvas;
    this.gc = canvas.getGraphicsContext2D();
    this.gc.setFill(Color.WHITE);
    this.gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    
    // adding listener to shapesSizes and totalArea
    shapesSizes.set(shapes.size());
    totalArea.set(findTotalArea());
    shapes.addListener((ListChangeListener<DrawableShape>) change -> {
        while (change.next()) {
            if (change.wasAdded() || change.wasRemoved()) {
                shapesSizes.set(shapes.size());
                totalArea.set(findTotalArea());
            }
        }
    });

    // Add buttons to the toggle group so that there can only be one shape active at a time
    ToggleGroup groupShapes = new ToggleGroup();
    btnSqr.setToggleGroup(groupShapes);
    btnCircle.setToggleGroup(groupShapes);
    btnSqr.setSelected(true);

    // Add the event handlers so that the buttons swap to the right shape or clear the canvas
    btnSqr.setOnAction(e1 -> currentShape = ShapeType.SQUARE);
    btnCircle.setOnAction(e1 -> currentShape = ShapeType.CIRCLE);
    
    btnClear.setOnAction(e1 -> {
        shapes.clear();
        refresh();
    });

    // adds an event for clicking with the mouse to create a shape using switch case statement for finding out which one
    canvas.setOnMouseClicked(e2 -> {
        if (e2.getButton() != MouseButton.PRIMARY) return;
            double x = e2.getX();
            double y = e2.getY();
            double size = 50; // Fixed size for simplicity atm
            Color fill = (Color.BLUE);
            Color stroke = (Color.WHITE);
            gc.setLineWidth(1);
            DrawableShape s = null;
            switch (currentShape) {
                case SQUARE:
                s = new Square(x, y, size, fill, stroke);
                    break;
                case CIRCLE:
                s = new Circle(x, y, size, fill, stroke);
                    break;
                default: break;
            }
            if (s != null) {
            shapes.add(s);
            s.draw(gc);
            }
        });
    }

    // gets current shape
    public ShapeType getCurrentShape() {
        return currentShape;
    }

    // sets current shape
    public void setCurrentShape(ShapeType type) {
        this.currentShape = type;
    }

    // clears current shapes from listview and on canvas by calling refresh for canvas
    public void clearAllShapes() {
        shapes.clear();
        refresh();
    }

    // get shapes for list
    public ObservableList<DrawableShape> getShapes() {
        return shapes;
    }

    // get the shapesSizes
    public ReadOnlyIntegerWrapper shapesSizeBind() {
        return shapesSizes;
    }

    // get the totalArea
    public ReadOnlyDoubleWrapper totalAreaBind() {
        return totalArea;
    }

    // finds the total area for tooltip
    public Double findTotalArea() {
        double area = 0;
        for (DrawableShape s : shapes) area = area += s.getArea();
        return area;
    }

    // refresh the canvas and clear every shape (also color canvas)
    public void refresh() {
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    for (DrawableShape s : shapes) s.draw(gc);
    }
}