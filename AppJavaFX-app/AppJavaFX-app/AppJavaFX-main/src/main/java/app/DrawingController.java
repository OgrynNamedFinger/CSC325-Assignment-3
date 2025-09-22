package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DrawingController {

    private BorderPane rootPane;
    private Canvas canvas;
    private GraphicsContext gc;

    private ToggleGroup shapeToggleGroup;
    private ObservableList<DrawableShape> shapes;

    public DrawingController() {
        shapes = FXCollections.observableArrayList();
        setupUI();
        setupEvents();
    }

    private void setupUI() {
        rootPane = new BorderPane();

        // Canvas
        canvas = new Canvas(600, 500);
        gc = canvas.getGraphicsContext2D();
        rootPane.setCenter(canvas);

        // Controls
        RadioButton rectButton = new RadioButton("Rectangle");
        RadioButton circleButton = new RadioButton("Circle");

        shapeToggleGroup = new ToggleGroup();
        rectButton.setToggleGroup(shapeToggleGroup);
        circleButton.setToggleGroup(shapeToggleGroup);
        rectButton.setSelected(true); // default

        Button clearButton = new Button("Clear");

        HBox controls = new HBox(15, rectButton, circleButton, clearButton);
        controls.setPadding(new Insets(10));
        rootPane.setTop(controls);

        // Clear button logic
        clearButton.setOnAction(e -> {
            shapes.clear();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });
    }

    private void setupEvents() {
        canvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            DrawableShape shape;
            if (((RadioButton) shapeToggleGroup.getSelectedToggle()).getText().equals("Rectangle")) {
                shape = new RectangleShape(x, y, 60, 40);
            } else {
                shape = new CircleShape(x, y, 30);
            }

            shapes.add(shape);
            redraw();
        });
    }

    private void redraw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (DrawableShape shape : shapes) {
            shape.draw(gc);
        }
    }

    public BorderPane getRootPane() {
        return rootPane;
    }
}