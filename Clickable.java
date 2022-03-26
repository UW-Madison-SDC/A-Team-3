public interface Clickable {
    // draws this Clickable object to the screen
    public void draw();
  
    // defines the behavior of this Clickable object
    // each time the mouse is pressed
    public void mousePressed();
  
    // defines the behavior of this Clickable object
    // each time the mouse is released
    public void mouseReleased();
  
    // returns true if the mouse is over this clickable object
    public boolean isMouseOver();
  }