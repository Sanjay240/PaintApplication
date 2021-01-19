package assignment8_000811237;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * this class draws the Oval of equal width and height and extends Object
 *
 * @author Sanjay Kumar
 */

public class Oval extends Object {
    /**  radius of the oval */
    private double radius;

    /**
     * this constructor sets the value of instance variables
     *
     * @param x
     * @param y
     * @param strokeColor
     * @param fillColor
     * @param lineWidth
     * @param radius
     */
    public Oval(double x, double y, Color strokeColor, Color fillColor, double lineWidth, double radius) throws ArithmeticException {
        super(x, y, strokeColor, fillColor, lineWidth);
        if(radius < 1|| radius > 300){
            throw new ArithmeticException("Please Enter the radius within Canvas Range maximium is 300");
        }
        this.radius = radius;
    }

    /**
     * this method returns the radius of oval
     *
     * @return radius
     */
    public double getRadius() {
        return radius;
    }


    /**
     *  this methods draws the oval with giver dimensions
     *
     * @param gc
     */
    public void draw(GraphicsContext gc){
    gc.setFill(getFillColor());
    gc.setStroke(getStrokeColor());
    gc.setLineWidth(getLineWidth());
    gc.fillOval(getX(),getY(),getRadius(),getRadius());
    gc.strokeOval(getX(),getY(),getRadius(),getRadius());
    }
}
