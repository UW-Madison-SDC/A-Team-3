import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class Piece implements Clickable {

    // PApplet stuff
    protected static Driver processing;

    // coordnate of piece
    private Coordinate coord;

    private int color; // 0 --> red 1 --> yellow

    private PImage image; // piece image

    /**
     * constructor
     * 
     * @param x_input     initial x coord
     * @param y_input     initial y coord
     * @param color_input set color
     * @param image_path  image name
     */
    Piece(int x_input, int y_input, int color_input, String image_path) {
        coord = new Coordinate(x_input, y_input);
        color = color_input;
        set_image(image_path);
    }

    // name of the piece
    private void set_image(String name) {
        image = processing.loadImage("assets" + File.separator + "Piece" + name + ".png");
    }

    // call this in the setup method in Driver
    public static void setProcessing(Driver processing) {
        Piece.processing = processing;
    }

    // set coord
    public void set_coord(int x_input, int y_input) {
        coord.setX(x_input);
        coord.setY(y_input);
    }

    // get coord
    public Coordinate get_coord() {
        return coord;
    }

    // draw method
    public void draw() {
        processing.image(image, coord.getX(), coord.getY());
    }

    public boolean move(Card card, Coordinate coord){

        return true;
    }

}