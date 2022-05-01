import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class GridSquare {
  private Coordinate coord;
  public boolean selected;
  static private PApplet processing;
  private PImage image; // piece image
  private PImage clicked_image; // clicked image
  
  public GridSquare(int x, int y, PApplet processing) {
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

  public void select(){
    selected = true;
  }

  public void deselect(){
    selected = false;
  }

  public PImage getImage(){
      return image;
  }

  @Override
  public String toString(){
    return "Grid at : "+coord.toString()+" / ";
  }
}
