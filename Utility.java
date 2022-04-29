public class Utility {
    // x 500
    // y 500

    // 7
    // 7

    static int real_pixel=400;
    static int game_coord= 7;
    
    static int scale = real_pixel/game_coord;

    public static int converter_game(int input){

        if(input/scale + 1 == 8){
            return 7;
        }
        return input/scale + 1;
    }

    public static int converter_real(int input){
        return input;
    }
  
    
}
