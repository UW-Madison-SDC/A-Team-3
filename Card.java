import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;

public class Card {
  
  // 0 - Red, 1- Green, 2 - QueueRed, 3- QueueGreen, 4 - not owned
  int possession; 
  String title;
  ArrayList<Coordinate> canMoveTo = new ArrayList<Coordinate>();
  Boolean isSelected;
  
  Coordinate thisCardsCoordinate = new Coordinate(0, 0);
  int position; // 0 - redQueue[0]; 1 - redCards[0]; 2 - redCards[1]; 3 - greenQueue[0]; 4 - greenCards[0]; 5 - greenCards[1]
  
  static private PApplet processing;
  PApplet Image;
  
  public Card(int x) {
    if(x == 0) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Artillery Truck.png");
      this.title = "Artillery Truck";
      
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(-1,1));
      this.canMoveTo.add(new Coordinate(1,1));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,-1));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(-1,1));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 1) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Attack Helicopter.png");
      this.title = "Attack Helicopter";
      
      this.canMoveTo.add(new Coordinate(1,-3));
      this.canMoveTo.add(new Coordinate(1,3));
      this.canMoveTo.add(new Coordinate(0,-2));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(-1,-3));
      this.canMoveTo.add(new Coordinate(-1,3));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 2) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Attack Helicopter.png");
      this.title = "Cargo Plane";
      
      this.canMoveTo.add(new Coordinate(1,1));
      this.canMoveTo.add(new Coordinate(2,2));
      this.canMoveTo.add(new Coordinate(2,3));
      this.canMoveTo.add(new Coordinate(-1,-1));
      this.canMoveTo.add(new Coordinate(-2,-2));
      this.canMoveTo.add(new Coordinate(-2,-3));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    
    if(x == 3) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Carrier.png");
      this.title = "Carrier";
      
      this.canMoveTo.add(new Coordinate(0,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 4) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Cruiser.png");
      this.title = "Cruiser";
      
      this.canMoveTo.add(new Coordinate(0,-2));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(1,-1));
      this.canMoveTo.add(new Coordinate(1,1));
      this.canMoveTo.add(new Coordinate(2,-2));
      this.canMoveTo.add(new Coordinate(2,2));
      this.canMoveTo.add(new Coordinate(-1,-1));
      this.canMoveTo.add(new Coordinate(-1,1));
      this.canMoveTo.add(new Coordinate(-2,-2));
      this.canMoveTo.add(new Coordinate(-2,2));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 5) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Destroyer.png");
      this.title = "Destroyer";
      
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(0,3));
      this.canMoveTo.add(new Coordinate(0,-1));
      this.canMoveTo.add(new Coordinate(0,-2));
      this.canMoveTo.add(new Coordinate(0,-3));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 6) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Fighter Jet.png");
      this.title = "Fighter Jet";
      
      this.canMoveTo.add(new Coordinate(-4,4));
      this.canMoveTo.add(new Coordinate(-4,-4));
      this.canMoveTo.add(new Coordinate(4,4));
      this.canMoveTo.add(new Coordinate(4,-4));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 7) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Humvee.png");
      this.title = "Humvee";
      
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(1,1));
      this.canMoveTo.add(new Coordinate(-1,1));
      this.canMoveTo.add(new Coordinate(0,-1));
      this.canMoveTo.add(new Coordinate(1,-1));
      this.canMoveTo.add(new Coordinate(-1,-1));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 8) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Jeep.png");
      this.title = "Jeep";
      
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(0,-1));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 9) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Medical Helicopter.png");
      this.title = "Medical Helicopter";
      
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(0,-1));
      this.canMoveTo.add(new Coordinate(2,0));
      this.canMoveTo.add(new Coordinate(3,0));
      this.canMoveTo.add(new Coordinate(-2,0));
      this.canMoveTo.add(new Coordinate(-3,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 10) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Military Motorcycle.png");
      this.title = "Military Motorcycle";
      
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(0,-1));
      this.canMoveTo.add(new Coordinate(0,-2));
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 11) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Patrol Boat.png");
      this.title = "Patrol Boat";
      
      this.canMoveTo.add(new Coordinate(2,2));
      this.canMoveTo.add(new Coordinate(-2,2));
      this.canMoveTo.add(new Coordinate(2,-2));
      this.canMoveTo.add(new Coordinate(-2,-2));
      this.canMoveTo.add(new Coordinate(2,0));
      this.canMoveTo.add(new Coordinate(-2,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 12) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Stealth Bomber.png");
      this.title = "Stealth Bomber";
      
      this.canMoveTo.add(new Coordinate(0,-4));
      this.canMoveTo.add(new Coordinate(0,-3));
      this.canMoveTo.add(new Coordinate(0,3));
      this.canMoveTo.add(new Coordinate(0,4));
      this.canMoveTo.add(new Coordinate(1,-4));
      this.canMoveTo.add(new Coordinate(1,-3));
      this.canMoveTo.add(new Coordinate(1,3));
      this.canMoveTo.add(new Coordinate(1,4));
      this.canMoveTo.add(new Coordinate(-1,-4));
      this.canMoveTo.add(new Coordinate(-1,-3));
      this.canMoveTo.add(new Coordinate(-1,3));
      this.canMoveTo.add(new Coordinate(-1,4));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 13) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Tank.png");
      this.title = "Tank";
      
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(0,-2));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 14) {
      processing.loadImage("assets" + File.separator + "Cards" + File.separator + "Patrol Boat.png");
      this.title = "Patrol Boat";
      
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(1,-1));
      this.canMoveTo.add(new Coordinate(1,-2));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(-1,1));
      this.canMoveTo.add(new Coordinate(-1,2));
      
      this.possession = 4;
      this.isSelected = false;   
    }
  }
  
  public void setPosition(int x) {
    this.position = x;
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
    Fish.processing.image(this.image, this.thisCardsCoordinate.getX(), this.thisCardsCoordinate.getY());
  }
  
  
  
}
