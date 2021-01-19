package assignment8_000811237;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;



/**
 * This is the User Interface which designs the GUI window
 *
 * @author Sanjay Kumar
 */
public class Main extends Application {

    // TODO: Instance Variables for View Components and Model
    /** instance variable gc of type Grapic Context */
    private GraphicsContext gc;
    /** instance variable fillCP of type Color Picker */
    private ColorPicker fillCP;
    /** instance variable of type Color Picker*/
    private  ColorPicker strokeCP;
    /** Array list of type Object to stores rectangle an Oval */
    private ArrayList<Object>objectArrayList;
    /** instance variable of type Textfield*/
    private TextField txtBorder;
    /** instance variable of type button */
    private Button btnRectangle;
    /**  instance variable of type Boolen to initiate the button*/
    private Boolean checker = true;
    /** instance variable of type Label */
    private Label rectWidht;
    /** instance variable of type Label */
    private Label rectHeight;
    /** instance variable of type Label*/
    private Label ovalRadius;
    /** instance variable of type TextField */
    private TextField txtWidth;
    /** instance variable of type TextField */
    private TextField txtHeight;
    /** instance variable of type Textfield*/
    private TextField txtRadius;

    // TODO: Private Event Handlers and Helper Methods

    /**
     * this is mouse pressed event Handler and will draw the shape on Canvas when pressed
     *
     * @param press
     */
    private void pressHandler(MouseEvent press){
         double x = press.getX();// local variable to store initial value of x
        double  y = press.getY();// local variable to store initial value of y
        try {
            double borderWidth = Double.parseDouble(txtBorder.getText()); // local variable to store border width
            if (checker) {
                double rectWidth = Double.parseDouble((txtWidth.getText()));// local variabe to width of rectangle
                double rectHeight = Double.parseDouble((txtHeight.getText()));// local variable to store height of rectangle
                Rectangle rectangle = new Rectangle(x, y, strokeCP.getValue(), fillCP.getValue(), borderWidth, rectWidth, rectHeight);
                objectArrayList.add(rectangle);
            } else  {
                double ovalRadius = Double.parseDouble((txtRadius.getText()));//local variable to radius of oval
                Oval oval = new Oval(x, y, strokeCP.getValue(), fillCP.getValue(), borderWidth, ovalRadius);
                objectArrayList.add(oval);
            }
        }catch (NumberFormatException e){
            new Alert(Alert.AlertType.WARNING, "You must enter an Integer" ).showAndWait();
        }catch(ArithmeticException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage() ).showAndWait();
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING, "Something is Wrong" ).showAndWait();
        }

        for (Object e : objectArrayList){
            if(e instanceof Rectangle){
                ((Rectangle) e).draw(gc);
            }else {
                ((Oval) e).draw(gc);
            }
        }
    }

    /**
     * this is the rectangle event Handler and will take of button and will add rectangle to array
     *
     * @param r
     */
    private void rectangleHandler(ActionEvent r){
        checker = true;
        rectHeight.relocate(320,400);
        rectWidht.relocate(250,400);
        txtWidth.relocate(250,430);
        txtWidth.setPrefWidth(50);
        txtHeight.relocate(320,430);
        txtHeight.setPrefWidth(50);
        ovalRadius.relocate(-250,-400);
        txtRadius.relocate(-250,-430);
        txtRadius.setPrefWidth(50);
    }

    /**
     * this event handler will control the oval button Activities
     *
     * @param oval
     */
    private void ovalHandler(ActionEvent oval){
        checker = false;
        ovalRadius.relocate(250,400);
        txtRadius.relocate(250,430);
        txtRadius.setPrefWidth(50);
        rectHeight.relocate(-320,-400);
        rectWidht.relocate(-250,-400);
        txtWidth.relocate(-250,-430);
        txtWidth.setPrefWidth(50);
        txtHeight.relocate(-320,-430);
        txtHeight.setPrefWidth(50);
    }

    /**
     * this button will control the activities of Undo Handler Button and will delete the the last element of array list
     *
     * @param undo
     */
    private void undoHandler(ActionEvent undo){
        int length = objectArrayList.size(); // local variable to check the size of array
        if(length > 0) {
            objectArrayList.remove((length) - 1);
            refresh();
            for (Object e : objectArrayList) {
                if (e instanceof Rectangle) {
                    ((Rectangle) e).draw(gc);
                } else {
                    ((Oval) e).draw(gc);
                }
            }
        }

    }

    /**
     * this button will control the activities of reset button
     *
     * @param reset
     */
    private void resetHandler(ActionEvent reset){
        rectHeight.relocate(320,400);
        rectWidht.relocate(250,400);
        txtWidth.relocate(250,430);
        txtWidth.setPrefWidth(50);
        txtWidth.setText("150");
        txtHeight.relocate(320,430);
        txtHeight.setPrefWidth(50);
        txtHeight.setText("100");
        ovalRadius.relocate(-250,-400);
        txtRadius.relocate(-250,-430);
        txtRadius.setPrefWidth(50);
        txtRadius.setText("50");
        txtBorder.setText("5");
        btnRectangle.requestFocus();
        refresh();
    }

    /**
     * this button wiil control the activities of clear button and will clear the screen
     *
     * @param clear
     */
    private void clearHandler(ActionEvent clear){
    refresh();
    }

    /**
     * this method will refresh the gui screen
     *
     */
    private void refresh(){
        gc.setFill(Color.ANTIQUEWHITE);
        gc.fillRect(0,0,800,300);
        btnRectangle.requestFocus();


    }
    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600); // set the size here
        
        stage.setTitle("Assignment 8 Paint"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model

        Canvas canvas = new Canvas(800,300 );
        objectArrayList=new ArrayList<>();
        fillCP = new ColorPicker(Color.web("#ffcce6"));
        strokeCP = new ColorPicker(Color.web("#ffb366"));
        gc = canvas.getGraphicsContext2D();
        // 2. Create the GUI components
        Label lblOutput = new Label("Direction for Use"+"\n1. Select the figure you want to draw."+"\n2. Select the dimensions."+
                "\n3. Click on the Canvas where you \n \twant to draw shape.");
        Label lblColorName = new Label("Color");
        Label lblStrokeName = new Label("Stroke");
        Label lblBorderWidth = new Label("Stroke");
        txtBorder = new TextField("5");
        rectWidht = new Label("Width");
        rectHeight = new Label("Height");
        ovalRadius = new Label("Radius");
        txtRadius = new TextField("50");
        txtHeight = new TextField("150");
        txtWidth = new TextField("150");
        btnRectangle = new Button("Rectangle");
        Button btnOval = new Button ("Oval");
        Button btnUndo = new Button("Undo");
        Button btnClear = new Button("Clear");
        Button btnReset = new Button("Reset");

        // 3. Add components to the root
         root.getChildren().addAll(canvas,txtBorder,btnOval,btnRectangle,lblBorderWidth,lblColorName,
                 lblStrokeName,lblOutput,btnClear,btnReset,btnUndo,fillCP,strokeCP,rectHeight,rectWidht,ovalRadius,
                 txtHeight,txtRadius,txtWidth);
        // 4. Configure the components (colors, fonts, size, location)
        btnRectangle.relocate(300,320);
        btnRectangle.setPrefWidth(80);
        btnOval.relocate(420,320);
        btnOval.setPrefWidth(60);
        lblColorName.relocate(10,400);
        lblColorName.setPrefWidth(50);
        fillCP.relocate(10,440);
        lblStrokeName.relocate(10, 500);
        lblStrokeName.prefWidth(50);
        strokeCP.relocate(10,540);
        lblBorderWidth.relocate(200,400);
        txtBorder.relocate(200,430);
        txtBorder.setPrefWidth(40);
        lblOutput.relocate(550,350);
        btnUndo.relocate(300,520);
        btnClear.relocate(380,520);
        btnReset.relocate(440,520);
        rectHeight.relocate(320,400);
        rectWidht.relocate(250,400);
        txtWidth.relocate(250,430);
        txtWidth.setPrefWidth(50);
        txtHeight.relocate(320,430);
        txtHeight.setPrefWidth(50);
        ovalRadius.relocate(-250,-400);
        txtRadius.relocate(-250,-430);
        txtRadius.setPrefWidth(50);



        // 5. Add Event Handlers and do final setup
        btnRectangle.setOnAction(this::rectangleHandler);
        btnOval.setOnAction(this:: ovalHandler);
        btnUndo.setOnAction(this::undoHandler);
        btnClear.setOnAction(this:: clearHandler);
        btnReset.setOnAction(this::resetHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        refresh();
        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}