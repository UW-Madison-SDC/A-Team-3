import java.util.ArrayList;

public class Card {
  
  // 0 - Red, 1- Green, 2 - QueueRed, 3- QueueGreen, 4 - not owned
  int possession; 
  String title;
  ArrayList<Coordinate> canMoveTo = new ArrayList<Coordinate>();
  Boolean isSelected;
  // PApplet Image - to be implemented later
  
  public Card(int x) {
    if(x == 0) {
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
      this.title = "Carrier";
      
      this.canMoveTo.add(new Coordinate(0,0));
      
      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 4) {
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
      this.title = "Fighter Jet";
      
      this.canMoveTo.add(new Coordinate(-4,4));
      this.canMoveTo.add(new Coordinate(-4,-4));
      this.canMoveTo.add(new Coordinate(4,4));
      this.canMoveTo.add(new Coordinate(4,-4));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 7) {
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
      this.title = "Jeep";
      
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(0,1));
      this.canMoveTo.add(new Coordinate(0,-1));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 9) {
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
      this.title = "Tank";
      
      this.canMoveTo.add(new Coordinate(1,0));
      this.canMoveTo.add(new Coordinate(-1,0));
      this.canMoveTo.add(new Coordinate(0,2));
      this.canMoveTo.add(new Coordinate(0,-2));

      this.possession = 4;
      this.isSelected = false;   
    }
    
    if(x == 14) {
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
  
  
  
}
