// how to run program
/*
cd 'C:\Users\quant\Downloads\AppJavaFX-main\AppJavaFX-main'
mvn clean javafx:run

or

.\mvnw clean javafx:run
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main application entry — constructs UI and wires the DrawingController.
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing App LV2");

        //Creating the canvas
        Canvas canvas = new Canvas(800, 600);

        // Creating the buttons that will be used for drawing
        RadioButton rbRect = new RadioButton("Rectangle");
        RadioButton rbCircle = new RadioButton("Circle");
        Button clearBtn = new Button("Clear");

        // Controller handles mouse events and the ObservableList of shapes
        DrawingController controller = new DrawingController(canvas, rbRect, rbCircle, clearBtn);

    ListView<DrawableShape> listView = new ListView<>(controller.getShapes());
        listView.setPrefWidth(220);
    Tooltip.install(listView, new Tooltip("Shapes list — hover to see selection"));
        
        // Rectangle button, Circle button, Clear button
        HBox controls = new HBox(10);
        controls.setPadding(new Insets(8));
        controls.getChildren().addAll(new Label("Shape:"), rbRect, rbCircle, clearBtn);

        // BorderPane for controls
        BorderPane root = new BorderPane();
        root.setTop(controls);

        // Center area with canvas + add the ListView to the right
        VBox center = new VBox();
        center.getChildren().addAll(canvas);
        VBox.setVgrow(canvas, Priority.ALWAYS);
        root.setCenter(center);

        root.setRight(listView);

        // Status bar: show count and total area, and selected shape info
        Label status = new Label();
        Label selectedInfo = new Label("Selected: none");
        HBox statusBar = new HBox(12);
        statusBar.setPadding(new Insets(6));
        statusBar.getChildren().addAll(status, selectedInfo);
        root.setBottom(statusBar);

        // Bind the status label to the shapes size and total area properties
        status.textProperty().bind(
                javafx.beans.binding.Bindings.format("Shapes: %d  — Total area: %.1f",
                        controller.shapesSizeProperty().getReadOnlyProperty(),
                        controller.totalAreaProperty().getReadOnlyProperty())
        );

        // Update selectedInfo when selection changes (tooltip-like behavior)
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV == null) {
                selectedInfo.setText("Selected: none");
            } else {
                selectedInfo.setText(String.format("Selected: %s — area=%.1f", newV.getClass().getSimpleName(), newV.getArea()));
                Tooltip t = new Tooltip(String.format("%s at (%.0f, %.0f) size=%.0f", newV.getClass().getSimpleName(), newV.x, newV.y, newV.size));
                Tooltip.install(listView, t);
            }
        });

        // Create the scene and show the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1100);
        primaryStage.setHeight(720);
        primaryStage.show();
    }

    // Runs the application
    public static void main(String[] args) {
        launch(args);
    }
}

