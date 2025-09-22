package app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class MainApp extends Application{
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("JavaFX Drawing App");
        DrawingController controller = new DrawingController();
        Scene scene = new Scene(controller.getRootPane(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
