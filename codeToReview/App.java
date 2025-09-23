// Benjamin Lukens CSC325 9/21/25
// imports
import java.util.logging.Logger;

// imports for javafx 
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

// imports for keybindings
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

// imports for the text label
import javafx.scene.control.Label;

public class App extends Application {
  // private variables
  private static final Logger LOGGER = Logger.getLogger(App.class.getName());
  private Canvas canvas; // The drawing area where the user draws.
  private Color currentColor = Color.BLACK;  // Color to be used for new shapes.
  public void start(Stage stage) {
    stage.setTitle("Settings Pane");

    // canvas 
    canvas = makeCanvas();
    StackPane canvasHolder = new StackPane(canvas);
    canvasHolder.setStyle("-fx-border-width: 2px; -fx-border-color: #444");
    BorderPane root = new BorderPane(canvasHolder);
    root.setStyle("-fx-border-width: 1px; -fx-border-color: black");
    root.setBottom(makeToolPanel(canvas));
    Scene scene = new Scene(root);

    // stage
    stage.setScene(scene);
    stage.setTitle("Click buttons at bottom to change settings"); 
    stage.setResizable(false);
    stage.show();
  }

  // initializes the canvas
  // and creates mouse action events 
  private Canvas makeCanvas() {
    Canvas canvas = new Canvas(800,600);
    canvas.setOnMousePressed( this::mousePressed );
    canvas.setOnMouseReleased( this::mouseReleased );
    canvas.setOnMouseDragged( this::mouseDragged );
    return canvas;
  }

  private HBox makeToolPanel(Canvas canvas) {
    // Make a pane containing the buttons that are used to add shapes
    // and the pop-up menu for selecting the current color.
    Button backColorBtn = new Button("set background color");
    ovalButton.setOnAction( (e) ->  ) );
    Button textColorBtn = new Button("set text color");
    rectButton.setOnAction( (e) ->  ) );
    ComboBox<String> combobox = new ComboBox<>();
    combobox.setEditable(false);
    Color[] colors = { Color.BLACK, Color.GREEN, Color.BLUE, Color.CYAN, 
      Color.MAGENTA, Color.YELLOW, Color.RED, Color.WHITE };
    String[] colorNames = { "Black", "Green", "Blue", "Cyan", 
      "Magenta", "Yellow", "Red", "White" };
    combobox.getItems().addAll(colorNames);
    combobox.setValue("Black");
    combobox.setOnAction( 
        e -> currentColor = colors[combobox.getSelectionModel().getSelectedIndex()] );        
    HBox tools = new HBox(10);
    tools.getChildren().add(backColorBtn);
    tools.getChildren().add(textColorBtn);
    tools.getChildren().add(combobox);
    tools.setStyle("-fx-border-width: 5px; -fx-border-color: transparent; -fx-background-color: lightgray");
    return tools;
  }

  private int prevDragX;  // During dragging, these record the x and y coordinates of the
  private int prevDragY;  //    previous position of the mouse.

  private void mousePressed(MouseEvent evt) {
    // User has pressed the mouse.  Find the shape that the user has clicked on, if
    // any.  If there is a shape at the position when the mouse was clicked, then
    // start dragging it.  If the user was holding down the shift key, then bring
    // the dragged shape to the front, in front of all the other shapes.
    int x = (int)evt.getX();  // x-coordinate of point where mouse was clicked
    int y = (int)evt.getY();  // y-coordinate of point 
    for ( int i = shapeCount - 1; i >= 0; i-- ) {  // check shapes from front to back
      Shape s = shapes[i];
      if (s.containsPoint(x,y)) {
        shapeBeingDragged = s;
        prevDragX = x;
        prevDragY = y;
        if (evt.isShiftDown()) { // s should be moved on top of all the other shapes
          for (int j = i; j < shapeCount-1; j++) {
            // move the shapes following s down in the list
            shapes[j] = shapes[j+1];
          }
          shapes[shapeCount-1] = s;  // put s at the end of the list
          paintCanvas();  // repaint canvas to show s in front of other shapes
        }
        return;
      }
    }
  }

  private void mouseDragged(MouseEvent evt) {
    // User has moved the mouse.  Move the dragged shape by the same amount.
    int x = (int)evt.getX();
    int y = (int)evt.getY();
    if (shapeBeingDragged != null) {
      shapeBeingDragged.moveBy(x - prevDragX, y - prevDragY);
      prevDragX = x;
      prevDragY = y;
    }
  }

  private void mouseReleased(MouseEvent evt) {
    // User has released the mouse.  Move the dragged shape, then set
    // shapeBeingDragged to null to indicate that dragging is over.
    shapeBeingDragged = null;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
