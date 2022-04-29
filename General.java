public class General extends Piece{
    General(int x_input,int y_input,int color_input,String path){
        super(x_input, y_input, color_input, path);
    }

    // method that checks General piece is in the opposite middle position
    public boolean check(){
        if(color == 0){ // 0 is for General
            if(coord.equals(yellow_win)){
                return true;
            }
        }
        if(color == 1){ // 1 is for red
            if(coord.equals(red_win)){
                return true;
            }
        }
        return false;
    }
}
