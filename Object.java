package assignment8_000811237;

import javafx.scene.paint.Color;


/**
 * This class will create take the common dimensions for both shapes
 *
 * @author Sanjay Kumar
 */
public class Object {
    /** instance variable of type double initial value*/
    private double x;
    /** instance variable of type double intial value */
    private double y;
    /** instance value of type Color to fill border color  */
    private Color strokeColor;
    /** instance value of type Color to fill shape color */
    private Color fillColor;
    /** instance line of type Double to set border width*/
    private double lineWidth;

    /**
     * this constructor sets the value of instance variables
     *
     * @param x
     * @param y
     * @param strokeColor
     * @param fillColor
     * @param lineWidth
     */
    public Object(double x, double y, Color strokeColor, Color fillColor, double lineWidth)throws ArithmeticException{
        this.x = x;
        this.y = y;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        if(lineWidth < 0 ){
            throw  new ArithmeticException("Line width must be positive");
        }
        this.lineWidth = lineWidth;
    }

    /**
     *  this method return double value of type x
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * this method return double value of type y
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * tis method returns stroke color
     *
     * @return strokeColor
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * this method returns the fill color
     *
     * @return fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * this method returns the lineWidth
     *
     * @return lineWidth
     */
    public double getLineWidth() {
        return lineWidth;
    }

}
