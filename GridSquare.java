
public class GridSquare {
  private Coordinate coord;
  public boolean selected;
  
  public GridSquare(int x, int y) {
    coord = new Coordinate(x, y);
    this.selected = false;
  }
  
  public int getX() {
    return this.coord.getX();
  }
  
  public int getY() {
    return this.coord.getY();
  }
}
