import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OvalShape extends Shape {

    @Override
    void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillOval(left, top, width, height);
        g.setStroke(Color.BLACK);
        g.strokeOval(left, top, width, height);
    }

    @Override
    boolean containsPoint(int x, int y) {
        double rx = width / 2.0;   
        double ry = height / 2.0;  
        double cx = left + rx;     
        double cy = top + ry;      
        return (ry * (x - cx)) * (ry * (x - cx)) + (rx * (y - cy)) * (rx * (y - cy)) <= rx * rx * ry * ry;
    }
}

