
public class Utilities {
  public static int[] coordToPixel(int gameX, int gameY) {
    int[] output = new int[2];
    output[0] = (gameX * 57) + 400;
    output[1] = (gameY * 57) + 300;
    return output;
  }
}
