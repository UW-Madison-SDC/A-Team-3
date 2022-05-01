/**
 * Stores a Coordinate, as well as its relativity
 * 
 * @author Fahim Islam
 * Version 1.0.0 (3/25/2022)
 *  -Created Coordinate.java with 3 constructors, and 3 field variables
 *  -Included Getters and Setters 
 */
public class Coordinate {
  // x-coordinate
  private int x;
  // y-coordinate
  private int y;
  // whether this is a relative coordinate
  private boolean isRelative;
  
  /**
   * Default Constructor, sets the field variables to default values
   */
  public Coordinate() {
    this(0, 0, false);
  }
  
  /**
   * Constructor, sets the field variables
   * 
   * @param x the x-coordinate
   * @param y the y-coordinate
   */
  public Coordinate(int x, int y) {
    this(x, y, false);
  }
  
  /**
   * Constructor, sets the field variables
   * 
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param isRelative whether this is a relative coordinate, or a regular coordinate
   */
  public Coordinate(int x, int y, boolean isRelative) {
    this.x = x;
    this.y = y;
    this.isRelative = isRelative;
  }

  /**
   * setter for the x-coordinate
   * 
   * @param the new x-coordinate
   */
  public void setX(int x) {
    this.x = x;
  }
  
  /**
   * setter for the y-coordinate
   * 
   * @param the new y-coordinate
   */
  public void setY(int y) {
    this.y = y;
  }
  
  /**
   * getter for the x-coordinate
   * 
   * @return the x-coordinate
   */
  public int getX() {
    return this.x;
  }
  
  /**
   * getter for the y-coordinate
   * 
   * @return the y-coordinate
   */
  public int getY() {
    return this.y;
  }
  
  /**
   * getter for the isRelative variable
   * 
   * @return the boolean value for the isRelative variable
   */
  public boolean getRelativity() {
    return this.isRelative;
  }
  
  @Override
  /**
   * Checks whether two objects are equal, by overriding the Coordinate method.
   * 
   * @param the other object
   * @return whether the other object equals this object
   */
  public boolean equals(Object other) {
    if(other instanceof Coordinate && this.x == ((Coordinate)(other)).getX() && this.y == ((Coordinate)(other)).getY()) {
      return true;
    }
    else {
      return false;
    }
  }

  public String toString(){
    String show = "( "+Integer.toString(Utility.converter_game(x)-4) + ", " +Integer.toString(Utility.converter_game(y)-2)+" )";
    return show;
  }
}
