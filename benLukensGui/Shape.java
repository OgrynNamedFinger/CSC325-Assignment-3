import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    int left, top;      
    int width, height;  
    Color color = Color.WHITE;  

    void reshape(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    void moveBy(int dx, int dy) {
        left += dx;
        top += dy;
    }

    void setColor(Color color) {
        this.color = color;
    }

    boolean containsPoint(int x, int y) {
        if (x >= left && x < left + width && y >= top && y < top + height)
            return true;
        else
            return false;
    }

    abstract void draw(GraphicsContext g);
}

