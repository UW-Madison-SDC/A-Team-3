import java.io.File;

public class GridSquare {
  private Coordinate coord;
  public boolean selected;
  static private PApplet processing;
  private PImage image; // piece image
  
  
  public GridSquare(int x, int y, processing) {
    this.processing = processing;
    coord = new Coordinate(x, y);
    this.selected = false;
    this.image = processing.loadImage("assets" + File.separator + "GridSpot.png");
  }
  
  //draw method
  public void draw() {
      this.processing.image(image, coord.getX(), coord.getY());
  }
  
  public int getX() {
    return this.coord.getX();
  }
  
  public int getY() {
    return this.coord.getY();
  }
}
