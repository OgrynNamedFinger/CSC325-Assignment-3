// how to run program
/*
cd 'C:\Users\quant\Downloads\AppJavaFX-main\AppJavaFX-main'
mvn clean javafx:run
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main application entry — constructs UI and wires the DrawingController.
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing App LV1");

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
        
        // Rectangle button, Circle button, Clear button
        HBox controls = new HBox(10);
        controls.setPadding(new Insets(8));
        controls.getChildren().addAll(new Label("Shape:"), rbRect, rbCircle, clearBtn);

        // BorderPane for controls
        BorderPane root = new BorderPane();
        root.setTop(controls);

        VBox center = new VBox();
        center.getChildren().addAll(canvas);
        VBox.setVgrow(canvas, Priority.ALWAYS);
        root.setCenter(center);

        root.setRight(listView);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1100);
        primaryStage.setHeight(720);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

