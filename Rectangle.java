package assignment8_000811237;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class will draw the rectangle
 *
 * @author Sanjay Kumar
 */
public class Rectangle extends Object{
    /** width of rectangle */
    private double width;
    /**  height of rectangle */
    private double height;

    /**
     * This Constructor sets value of instance variables
     *
     * @param x
     * @param y
     * @param strokeColor
     * @param fillColor
     * @param lineWidth
     * @param width
     * @param height
     */
    public Rectangle(double x, double y, Color strokeColor, Color fillColor, double lineWidth, double width, double height) throws ArithmeticException {
        super(x, y, strokeColor, fillColor, lineWidth);
        if(width < 1 || width > 800){
            throw new ArithmeticException("Width must be in Canvas range maximum is 800");
        }else if(width < getLineWidth()){
            throw new ArithmeticException("Width must be grater than Border Width");
        }
        this.width = width;
        if(height <1 || height >300){
            throw  new ArithmeticException("Height must be in Canvas  range maximum is 300");
        }
        this.height = height;
    }

    /**
     * this method returns width of rectangle
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * this method returns the height of rectangle
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * this method draws the rectangle with given dimensions
     *
     * @param gc
     */
    public void draw(GraphicsContext gc){
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.setLineWidth(getLineWidth());
        gc.fillRect(getX(),getY(),getWidth(),getHeight());
        gc.strokeRect(getX(),getY(),getWidth(),getHeight());

    }
}
