import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.canvas.GraphicsContext;

// Public interface for drawable shapes used by the drawing controller and UI.
public interface DrawableShape {
    
    // Draw this shape on the provided GraphicsContext
    void draw(GraphicsContext gc);

    // Read-only property exposing the area of this shape for bindings
    ReadOnlyDoubleProperty areaProperty();

    // Convenience getter for the area
    double getArea();

    // X coordinate (center) of the shape
    double getX();

    // Y coordinate (center) of the shape
    double getY();

    // Size (diameter for circle, side for square) of the shape
    double getSize();
}
