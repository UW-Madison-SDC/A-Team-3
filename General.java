import processing.core.PApplet;
import processing.core.PImage;

public class General extends Piece {
    General(int x_input, int y_input, int color_input, String path, PApplet processing) {
        super(x_input, y_input, color_input, path, processing);
    }

    // method that checks General piece is in the opposite middle position
    @Override
    public boolean check() {
        if (color == 0) { // 0 is for General
            if (Utility.converter_game(coord.getX())-4 == green_win.getX()
                    && Utility.converter_game(coord.getY())-2 == green_win.getY()) {
                return true;
            }
        }
        if (color == 1) { // 1 is for red
            
            if (Utility.converter_game(coord.getX())-4 == red_win.getX()
                    && Utility.converter_game(coord.getY())-2 == red_win.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean is_general(){
        return true;
    }

    @Override
    public String toString() {
        return "General piece at : " + coord.toString();
    }
}
// check
