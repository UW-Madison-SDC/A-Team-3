import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;


public class Card {
  
  // 0 - Red, 1- Green, 2 - QueueRed, 3- QueueGreen, 4 - not owned
  int possession; 
  String title;
  ArrayList<Coordinate> canMoveTo = new ArrayList<Coordinate>();
  Boolean isSelected;
  
  Coordinate thisCardsCoordinate = new Coordinate(0, 0);
  int position; // 0 - redQueue[0]; 1 - redCards[0]; 2 - redCards[1]; 3 - greenQueue[0]; 4 - greenCards[0]; 5 - greenCards[1]
  
  static private PApplet processing;
  private PImage image;
  private PImage clicked_image; // clicked image
  
  public Card(int x, PApplet processing) {
    this.processing = processing;
    if(x == 0) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Artillery Truck.png");
      this.title = "Artillery Truck";
      
      this.canMoveTo.add(new Coordinate(0,-57));
      this.canMoveTo.add(new Coordinate(-57,-57));
      this.canMoveTo.add(new Coordinate(57,-57));
      this.canMoveTo.add(new Coordinate(-57,0));
      this.canMoveTo.add(new Coordinate(57,0));
      this.canMoveTo.add(new Coordinate(0,57));
      this.canMoveTo.add(new Coordinate(57,57));
      this.canMoveTo.add(new Coordinate(-57,57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 1) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Attack Helicopter.png");
      this.title = "Attack Helicopter";
      
      this.canMoveTo.add(new Coordinate(171, 57));
      this.canMoveTo.add(new Coordinate(-171, 57));
      this.canMoveTo.add(new Coordinate(114, 0));
      this.canMoveTo.add(new Coordinate(-114, 0));
      this.canMoveTo.add(new Coordinate(171, -57));
      this.canMoveTo.add(new Coordinate(-171, -57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 2) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Attack Helicopter.png");
      this.title = "Cargo Plane";
      
      this.canMoveTo.add(new Coordinate(57,-57));
      this.canMoveTo.add(new Coordinate(114,-114));
      this.canMoveTo.add(new Coordinate(171,-114));
      this.canMoveTo.add(new Coordinate(-57,57));
      this.canMoveTo.add(new Coordinate(-114,114));
      this.canMoveTo.add(new Coordinate(-171,114));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    
    if(x == 3) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Carrier.png");
      this.title = "Carrier";
      
      this.canMoveTo.add(new Coordinate(0,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 4) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Cruiser.png");
      this.title = "Cruiser";
      
      this.canMoveTo.add(new Coordinate(114, 0));
      this.canMoveTo.add(new Coordinate(-114, 0));
      this.canMoveTo.add(new Coordinate(57,57));
      this.canMoveTo.add(new Coordinate(-57,57));
      this.canMoveTo.add(new Coordinate(114,114));
      this.canMoveTo.add(new Coordinate(-114,114));
      this.canMoveTo.add(new Coordinate(57,-57));
      this.canMoveTo.add(new Coordinate(-57,-57));
      this.canMoveTo.add(new Coordinate(114,-114));
      this.canMoveTo.add(new Coordinate(-114,-114));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 5) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Destroyer.png");
      this.title = "Destroyer";
      
      this.canMoveTo.add(new Coordinate(-57, 0));
      this.canMoveTo.add(new Coordinate(-114, 0));
      this.canMoveTo.add(new Coordinate(-171, 0));
      this.canMoveTo.add(new Coordinate(57, 0));
      this.canMoveTo.add(new Coordinate(114, 0));
      this.canMoveTo.add(new Coordinate(171, 0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 6) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Fighter Jet.png");
      this.title = "Fighter Jet";
      
      this.canMoveTo.add(new Coordinate(-228,-228));
      this.canMoveTo.add(new Coordinate(228,-228));
      this.canMoveTo.add(new Coordinate(-228,228));
      this.canMoveTo.add(new Coordinate(228,228));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 7) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Humvee.png");
      this.title = "Humvee";
      
      this.canMoveTo.add(new Coordinate(-57, 0));
      this.canMoveTo.add(new Coordinate(-57,57));
      this.canMoveTo.add(new Coordinate(-57,-57));
      this.canMoveTo.add(new Coordinate(57, 0));
      this.canMoveTo.add(new Coordinate(57,57));
      this.canMoveTo.add(new Coordinate(57,-57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 8) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Jeep.png");
      this.title = "Jeep";
      
      this.canMoveTo.add(new Coordinate(57,0));
      this.canMoveTo.add(new Coordinate(-57,0));
      this.canMoveTo.add(new Coordinate(0,-57));
      this.canMoveTo.add(new Coordinate(0,57));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 9) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Medical Helicopter.png");
      this.title = "Medical Helicopter";
      
      this.canMoveTo.add(new Coordinate(-57,0));
      this.canMoveTo.add(new Coordinate(57,0));
      this.canMoveTo.add(new Coordinate(0,114));
      this.canMoveTo.add(new Coordinate(0,171));
      this.canMoveTo.add(new Coordinate(0,-114));
      this.canMoveTo.add(new Coordinate(0,-171));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 10) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Military Motorcycle.png");
      this.title = "Military Motorcycle";
      
      this.canMoveTo.add(new Coordinate(-57,0));
      this.canMoveTo.add(new Coordinate(-114,0));
      this.canMoveTo.add(new Coordinate(57,0));
      this.canMoveTo.add(new Coordinate(114,0));
      this.canMoveTo.add(new Coordinate(0,57));
      this.canMoveTo.add(new Coordinate(0.-57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 11) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Patrol Boat.png");
      this.title = "Patrol Boat";
      
      this.canMoveTo.add(new Coordinate(-114,114));
      this.canMoveTo.add(new Coordinate(-114,-114));
      this.canMoveTo.add(new Coordinate(114,114));
      this.canMoveTo.add(new Coordinate(114,-114));
      this.canMoveTo.add(new Coordinate(0, 114));
      this.canMoveTo.add(new Coordinate(0, -114));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 12) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Stealth Bomber.png");
      this.title = "Stealth Bomber";
      
      this.canMoveTo.add(new Coordinate(228,0));
      this.canMoveTo.add(new Coordinate(171,0));
      this.canMoveTo.add(new Coordinate(-171,0));
      this.canMoveTo.add(new Coordinate(-228,0));
      this.canMoveTo.add(new Coordinate(228,57));
      this.canMoveTo.add(new Coordinate(171,57));
      this.canMoveTo.add(new Coordinate(-171,57));
      this.canMoveTo.add(new Coordinate(-228,57));
      this.canMoveTo.add(new Coordinate(228,-57));
      this.canMoveTo.add(new Coordinate(171,-57));
      this.canMoveTo.add(new Coordinate(-171,-57));
      this.canMoveTo.add(new Coordinate(-228,-57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 13) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Tank.png");
      this.title = "Tank";
      
      this.canMoveTo.add(new Coordinate(0,57));
      this.canMoveTo.add(new Coordinate(0,-57));
      this.canMoveTo.add(new Coordinate(-114,0));
      this.canMoveTo.add(new Coordinate(114,0));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 14) {
      this.image = processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Train.png");
      this.title = "Train";
      
      this.canMoveTo.add(new Coordinate(0,57));
      this.canMoveTo.add(new Coordinate(57,57));
      this.canMoveTo.add(new Coordinate(114,57));
      this.canMoveTo.add(new Coordinate(0,-57));
      this.canMoveTo.add(new Coordinate(-57,-57));
      this.canMoveTo.add(new Coordinate(-114,-57));
      
      this.possession = 4;
      this.isSelected = false;   
    }
  }
  
  public void setPossession(int x) {
    this.possession = x;
  }
  
  public int getPossession() {
    return this.possession;
  }
  
  public void setPosition(int x) {
    this.position = x;
  }
  
  public int getPosition() {
    return this.getPosition();
  }
  
  public void select() {
    this.isSelected = true;
  }
  
  public void deSelect() {
    this.isSelected = false;
  }
  
  public void draw() {
    if (this.position == 0) {
      this.thisCardsCoordinate.setX(100);
      this.thisCardsCoordinate.setY(450);
    } else if (this.position == 1) {
      this.thisCardsCoordinate.setX(100);
      this.thisCardsCoordinate.setY(300);
    } else if (this.position == 2) {
      this.thisCardsCoordinate.setX(100);
      this.thisCardsCoordinate.setY(150);
    } else if (this.position == 3) {
      this.thisCardsCoordinate.setX(700);
      this.thisCardsCoordinate.setY(450);
    } else if (this.position == 4) {
      this.thisCardsCoordinate.setX(700);
      this.thisCardsCoordinate.setY(300);
    } else if (this.position == 5) {
      this.thisCardsCoordinate.setX(700);
      this.thisCardsCoordinate.setY(150);
    }
    
    // 2. draw this card to the display window by calling processing.image() method
    Card.processing.image(this.image, this.thisCardsCoordinate.getX(), this.thisCardsCoordinate.getY());
  }

  public int getX(){
      return thisCardsCoordinate.getX();
  }

  public int getY(){
      return thisCardsCoordinate.getY();
  }
  
  public PImage getImage(){
      return image;
  }
  
  public String toString(){
      return "Card at : "+  thisCardsCoordinate.toString()+" / ";
  }
  
}
