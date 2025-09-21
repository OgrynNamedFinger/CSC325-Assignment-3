// cd 'c:\Users\quant\Downloads\AppJavaFX-app\AppJavaFX-main'; mvn clean javafx:run

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

// the main body for the entire app, connects AbstractDrawingClass, DrawingController, DrawableShape, you get the idea
public class App extends Application {

   // Constructor idk
   public App() {
   }
   
   // method needed for the javaFX app; creates a canvas, buttons, and kickstarts the process
   @Override
   public void start(Stage primaryStage) {
      Canvas canvas = new Canvas(800, 600);
      RadioButton btnSqr = new RadioButton("Square (R)");
      RadioButton btnCircle = new RadioButton("Circle (T)");
      Button btnClear = new Button("Clear (Y)");

      // hbox for the controls to be attached to for an upcoming borderpane
      HBox controls = new HBox(10);
      controls.setPadding(new Insets(10));
      controls.getChildren().addAll(new Label("Shape: "), btnSqr, btnCircle, btnClear);

      // create the controller object (very important obviously)
      DrawingController controller = new DrawingController(canvas, btnClear, btnSqr, btnCircle);

      // create the listview so that the user can see every shape currently on the canvas + click on it to inspect it
      ListView<DrawableShape> shapesList = new ListView<>(controller.getShapes());
      shapesList.setPrefWidth(220);
      Tooltip.install(shapesList, new Tooltip("Shapes list: click an entry to inspect the stats of the selected shape!"));

      // borderpane for hbox of control buttons to be attached to the root
      BorderPane root = new BorderPane();
      root.setTop(controls);

      // vbox for the canvas to be attached to the root
      VBox app = new VBox();
      app.getChildren().addAll(canvas);
      VBox.setVgrow(canvas, Priority.ALWAYS);

      // create the labels for tooltip and real time updates of the canvas
      Label stats = new Label();
      Label shapeInfo = new Label("Selected: none");
      HBox tooltipBar = new HBox(10);
      tooltipBar.setPadding(new Insets(10));
      tooltipBar.getChildren().addAll(stats, shapeInfo);

      // assign stuff to the root/scene
      root.setCenter(app);
      root.setRight(shapesList);
      root.setBottom(tooltipBar);

      // bind the tooltip related to the listview so that you can see the stats of the canvas update in real time via bind
      stats.textProperty().bind(
         javafx.beans.binding.Bindings.format("Shapes: %d, Total area: %.1f",
            controller.shapesSizeBind().getReadOnlyProperty(),
            controller.totalAreaBind().getReadOnlyProperty())
      );

      // realtime updates for the tooltip on the bottom of the screen
      shapesList.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
      if (newV == null) {
         shapeInfo.setText("Selected: none, area: none");
      } else {
         shapeInfo.setText(String.format("Selected: %s, area: %.1f", newV.getClass().getSimpleName(), newV.getArea()));
         Tooltip t = new Tooltip(String.format("%s at (%.0f, %.0f) size=%.0f",
            newV.getClass().getSimpleName(), newV.getX(), newV.getY(), newV.getSize()));
            Tooltip.install(shapesList, t);
      }
   });

      // keybinds for shape selector and clearing canvas using methods
      Scene scene = new Scene(root);
      scene.setOnKeyPressed(e2 -> {
         switch (e2.getCode()) {
         case R:
            controller.setCurrentShape(DrawingController.ShapeType.SQUARE);
            btnSqr.setSelected(true);
            break;
         case T:
            controller.setCurrentShape(DrawingController.ShapeType.CIRCLE);
            btnCircle.setSelected(true);
            break;
         case Y:
            controller.refresh();
            break;
         default: break;
         }
      });

      // finalize the scene w/ title, dimensions, and show
      primaryStage.setTitle("Drawing App L3");
      primaryStage.setScene(scene);
      primaryStage.setWidth(1100);
      primaryStage.setHeight(720);
      primaryStage.show();
   }

   // main to launch app
   public static void main(String[] args) {
      launch(args);
   }
}
