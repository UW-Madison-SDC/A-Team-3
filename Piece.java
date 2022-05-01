import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class Piece {

    // PApplet stuff
    static private PApplet processing;

    // coordnate of piece
    protected Coordinate coord;

    protected int color; // 0 --> green 1 --> red

    private PImage image; // piece image
    private PImage clicked_image; // clicked image

    private boolean selected; 

    protected final Coordinate yellow_win = new Coordinate(-4,0);
    protected final Coordinate red_win = new Coordinate(4,0);
    /**
     * constructor
     * 
     * @param x_input     initial x coord
     * @param y_input     initial y coord
     * @param color_input set color
     * @param image_path  image name
     */
    Piece(int x_input, int y_input, int color_input, String image_path, PApplet processing) {
        this.processing = processing;
        coord = new Coordinate(x_input, y_input);
        color = color_input;
        selected =false;
        set_image(image_path);
    }

    public void select(){
        selected = true;
    }

    public void deselect(){
        selected = false;
    }

    // name of the piece
    private void set_image(String name) {
        image = processing.loadImage("assets" + File.separator + "Pieces" + File.separator + name + ".png");
    }

    // call this in the setup method in Driver
    public static void setProcessing(PApplet processing) {
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

    public int getX(){
        return coord.getX();
    }
    public int getY(){
        return coord.getY();
    }

    // draw method
    public void draw() {
        this.processing.image(image, coord.getX(), coord.getY());
    }

    public PImage getImage(){
        return image;
    }

    /**
     * will check it is valid move or not
     * 
     * @param card chosen card
     * @param coord chosen coord
     * @return true if valid false if not valid
     */
    public boolean move(Card card, Coordinate coord){

        for(int i=0;i<card.canMoveTo.size();i++){
            if(coord.equals(card.canMoveTo.get(i))){
                return true;
            }
        }

        return false;
    }

}