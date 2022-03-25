import processing.core.PApplet;
import processing.core.PImage;

public class Piece implements Clickable {

    // PApplet stuff
    protected static Driver processing;

    // coordnate of piece
    private int x;
    private int y;

    private int color; // 0 --> red 1 --> blue

    private PImage image; // piece image

    Piece(int x_input, int y_input, int color_input, String image_path) {
        x = x_input;
        y = y_input;
        color = color_input;
        set_image(image_path);
    }

    public static void setProcessing(Driver processing) {
        Piece.processing = processing;
    }

    // name of the piece
    private void set_image(String name){
        image = processing.loadImage("images" + File.separator + name + ".png");
    }

}