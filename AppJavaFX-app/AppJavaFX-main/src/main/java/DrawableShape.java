
import javafx.scene.canvas.GraphicsContext;

// interface method for Square and Circle classes
public interface DrawableShape {

    // interface methods, all of which are left empty for overrides
    void draw(GraphicsContext gc);

    double getArea();

    double getX();

    double getY();

    double getSize();
}
