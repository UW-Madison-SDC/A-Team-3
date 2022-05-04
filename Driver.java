import processing.core.PApplet;

import processing.core.PImage;


import java.io.File;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Driver extends PApplet {

  // Congratulations message

  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";

  // Cards not matched message

  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";

  // Cards matched message

  private final static String MATCHED = "CARDS MATCHED! Good Job!";

  // 2D-array which stores cards coordinates on the window display

//  private final static float[][] CARDS_COORDINATES =
//          new float[][]{{170, 170}, {324, 170}, {478, 170}, {632, 170},
//
//                  {170, 324}, {324, 324}, {478, 324}, {632, 324},
//
//                  {170, 478}, {324, 478}, {478, 478}, {632, 478}};

  private final static float[][] GRID_COORDINATES = initializeCoords();
  private final static int[][] PIECE_COORDINATES =
          new int[][]{{200, 157},
                  {200, 214},
                  {200, 328},
                  {200, 385},
                  {542, 157},
                  {542, 214},
                  {542, 328},
                  {542, 385},
                  {200, 271},
                  {542, 271}};
  // Array that stores the card images filenames

  private final static String[] CARD_IMAGES_NAMES = new String[]{"Artillery Truck.png", "Attack Helicopter.png",
          "Cargo Plane.png", "Carrier.png", "Cruiser.png", "Destroyer.png", "Fighter Jet.png", "Humvee.png", "Jeep.png",
          "Medical Helicopter.png", "Military Motorcycle.png", "Patrol Boat.png", "Stealth Bomber.png", "Tank.png",
          "Train.png"};


  // private static PApplet processing; // PApplet object that represents

  // the graphic display window

  private static Card[] cards = new Card[15]; // one dimensional array of cards
  private static Card[] chosenDeck = new Card[5]; // one dimensional array of chosen cards

  private static Piece[] pieces = new Piece[10];
  private static Piece[] redRecruits = new Piece[4];
  private static Piece[] greenRecruits = new Piece[4];
  private static Piece redGeneral;
  private static Piece greenGeneral;
  private static ArrayList<Piece> redPieces = new ArrayList<Piece>();
  private static ArrayList<Piece> greenPieces = new ArrayList<Piece>();


  private static GridSquare[] grids = new GridSquare[49];
  private static PImage[] images; // array of images of the different cards

  // private static Card selectedCard1; // First selected card

  // private static Card selectedCard2; // Second selected card

  // private static boolean winner; // boolean evaluated true if the game is won,

  // and false otherwise

  // private static int matchedCardsCount; // number of cards matched so far

  // in one session of the game

  // private static String message; // Displayed message to the display window

  private static Random randGen;

  private static char playerTurn; // r - red, g - green
  private static int step = 0;
  private static ArrayList<Card> redCards = new ArrayList();
  private static ArrayList<Card> greenCards = new ArrayList();
  private static ArrayList<Card> redQueue = new ArrayList();
  private static ArrayList<Card> greenQueue = new ArrayList();

  public static float[][] initializeCoords() {
    float[][] GRID_COORDINATES = new float[49][2];

    for (int i = 0; i < 49; i++) {
      GRID_COORDINATES[i][0] = 200 + (57 * (i % 7));
      if (i < 7) {
        GRID_COORDINATES[i][1] = 100 + (57 * 0);
      } else if (i < 14) {
        GRID_COORDINATES[i][1] = 100 + (57 * 1);
      } else if (i < 21) {
        GRID_COORDINATES[i][1] = 100 + (57 * 2);
      } else if (i < 28) {
        GRID_COORDINATES[i][1] = 100 + (57 * 3);
      } else if (i < 35) {
        GRID_COORDINATES[i][1] = 100 + (57 * 4);
      } else if (i < 42) {
        GRID_COORDINATES[i][1] = 100 + (57 * 5);
      } else if (i < 49) {
        GRID_COORDINATES[i][1] = 100 + (57 * 6);
      }
    }
    return GRID_COORDINATES;
  }

  /**
   * Sets the size of the application display window
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  /**
   * Defines the initial environment properties of this game as the program starts
   */
  @Override
  public void setup() {

    playerTurn = 'r';
    // Driver.processing = processing;

    images = new PImage[CARD_IMAGES_NAMES.length];
    randGen = new Random();

    greenGeneral = new General(PIECE_COORDINATES[9][0], PIECE_COORDINATES[9][1], 0, "GreenGeneral", this);
    greenPieces.add(greenGeneral);
    redGeneral = new General(PIECE_COORDINATES[8][0], PIECE_COORDINATES[8][1], 1, "RedGeneral", this);
    redPieces.add(redGeneral);

    for (int i = 0; i < 4; ++i) {
      redRecruits[i] = new Piece(PIECE_COORDINATES[i][0], PIECE_COORDINATES[i][1], 1, "RedRecruit", this);
      redPieces.add(redRecruits[i]);
    }

    for (int i = 0; i < 4; ++i) {
      greenRecruits[i] = new Piece(PIECE_COORDINATES[i + 4][0], PIECE_COORDINATES[i + 4][1], 0, "GreenRecruit", this);
      greenPieces.add(greenRecruits[i]);
    }


    for (int i = 0; i < 15; ++i) {

//      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
//
//      processing.image(images[i], processing.width / 2, processing.height / 2);
      cards[i] = new Card(i, this);

    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    for (int i = 0; i < 5; i++) {
      chosenDeck[i] = new Card(list.get(i), this);
      chosenDeck[i].setPosition(i);
    }

    for (int i = 0; i < 2; i++) {
      redCards.add(chosenDeck[i]);
    }
    for (int i = 0; i < 2; i++) {
      greenCards.add(chosenDeck[i + 2]);
    }

    redQueue.add(chosenDeck[4]);

    for (int i = 0; i < 49; i++) {
      int x = (int) GRID_COORDINATES[i][0];
      int y = (int) GRID_COORDINATES[i][1];
      grids[i] = new GridSquare(x, y, this);
    }


    //startNewGame();
  }


  /**
   * Initializes the Game
   */

  // public static void startNewGame() {

  //   selectedCard1 = null;

  //   selectedCard2 = null;

  //   matchedCardsCount = 0;

  //   winner = false;

  //   message = "";

  //   cards = new Card[15];

  //   int[] mixedUp = Utility.shuffleCards(cards.length);

  //   // for (int i = 0; i < cards.length; ++i) {
  //   //   cards[i] = new Card(images[mixedUp[i]], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);
  //   // }

  //   //redPieces[0] = new Piece()

  // }


  /**
   * Callback method called each time the user presses a key
   */

  // public static void keyPressed() {

  //   if (processing.key == 'n' || processing.key == 'N') {

  //     startNewGame();

  //   }

  // }


  /**
   * Callback method draws continuously this application window display
   */

  public void draw() {

    // processing.background(245, 255, 250); // Mint cream color

    for (int i = 0; i < 5; ++i) {
      chosenDeck[i].draw();
    }
    for (int i = 0; i < GRID_COORDINATES.length; ++i) {
      grids[i].draw();
    }
    for (int i = 0; i < 5; ++i) {
      redPieces.get(i).draw();
      //greenPieces.get(i).draw();
    }
    for (int i = 0; i < 5; ++i) {
      //redPieces.get(i).draw();
      greenPieces.get(i).draw();
    }

    //displayMessage(message);

  }


  // /**
  //  * Displays a given message to the display window
  //  *
  //  * @param message to be displayed to the display window
  //  */

  // public static void displayMessage(String message) {

  //   processing.fill(0);

  //   processing.textSize(20);

  //   processing.text(message, processing.width / 2, 50);

  //   processing.textSize(12);

  // }


  /**
   * Checks whether the mouse is over a given Card
   *
   * @return true if the mouse is over the storage list, false otherwise
   */

  public boolean isMouseOverCard(Card card) {

    boolean mouseOverCard = false;
    System.out.println(this.mouseX);
    if (Math.abs(card.getX() + card.getImage().width / 2 - this.mouseX) <= (card.getImage().width / 2) &&

            Math.abs(card.getY() + card.getImage().height / 2 - this.mouseY) <= (card.getImage().height / 2)) {

      mouseOverCard = true;

    } else {

      mouseOverCard = false;

    }

    return mouseOverCard;

  }

  /**
   * Checks whether the mouse is over a given Piece
   *
   * @return true if the mouse is over the storage list, false otherwise
   */

  public boolean isMouseOverPiece(Piece piece) {

    boolean mouseOverPiece = false;

    if (Math.abs(piece.getX() + (piece.getImage().width / 2) - this.mouseX) <= (piece.getImage().width / 2) &&

            Math.abs(piece.getY() + (piece.getImage().height / 2) - this.mouseY) <= (piece.getImage().height / 2)) {

      mouseOverPiece = true;

    } else {

      mouseOverPiece = false;

    }

    return mouseOverPiece;

  }

  /**
   * Checks whether the mouse is over a given Grid
   *
   * @return true if the mouse is over the storage list, false otherwise
   */

  public boolean isMouseOverGrid(GridSquare grid) {

    boolean mouseOverGrid = false;

    if (Math.abs(grid.getX() + (grid.getImage().width / 2) - this.mouseX) <= (grid.getImage().width / 2) &&

            Math.abs(grid.getY() + (grid.getImage().height / 2) - this.mouseY) <= (grid.getImage().height / 2)) {

      mouseOverGrid = true;

    } else {

      mouseOverGrid = false;

    }

    return mouseOverGrid;

  }

  /**
   * Figure out isMouseOver(done), mousePressed
   */

  Card selectedCard = null;
  Piece selectedPiece = null;
  GridSquare selectedGrid = null;
  boolean checkValidity = false;
  Coordinate move;
  int getPos = 0;
  int coordXGrid, coordYGrid, coordXPiece, coordYPiece, coordX, coordY;

  /**
   * Callback method called each time the user presses the mouse
   */

  public void mousePressed() {
    //System.out.println("Selected card " + selectedCard);
    //System.out.println("Selected piece " + selectedPiece);

    if (playerTurn == 'r') {
      System.out.println("RED TURN: " + step);
      if (step == 0) {
        for (int i = 0; i < redCards.size(); i++) {
          //System.out.println("check");
          if (isMouseOverCard(redCards.get(i))) {
            System.out.println("RED CARD SELECTED");
            selectedCard = redCards.get(i);
            // check validity
            if (redCards.contains(selectedCard)) {
              System.out.println(selectedCard.toString());
              redCards.get(i).select();
              step++;
              break;
            }
          }
        }
      } else if (step == 1) {
        for (int i = 0; i < redPieces.size(); i++) {

          if (isMouseOverPiece(redPieces.get(i))) {
            System.out.println("RED PIECE IS SELECTED");
            System.out.println(redPieces.get(i).toString());
            selectedPiece = redPieces.get(i);
            // check validity
            selectedPiece.select();
            step++;
            break;
          }
        }
      } else if (step == 2) {
        for (int i = 0; i < grids.length; i++) {
          if (isMouseOverGrid(grids[i])) {
            System.out.println("RED GRID SELECTED");
            selectedGrid = grids[i];
            selectedGrid.select();
            System.out.println(selectedGrid.toString());
            coordXGrid = selectedGrid.getX();
            coordYGrid = selectedGrid.getY();
            coordXPiece = selectedPiece.getX();
            coordYPiece = selectedPiece.getY();

            coordX = coordXGrid - coordXPiece;
            coordY = coordYGrid - coordYPiece;
            move = new Coordinate(coordX, coordY, true);

            for (int j = 0; j < selectedCard.canMoveTo.size(); ++j) {

              if (selectedCard.canMoveTo.get(j).getX() == coordX && selectedCard.canMoveTo.get(j).getY() == coordY) {
                System.out.println("Is this RED set coord ever executed?");
                selectedPiece.set_coord(coordXGrid, coordYGrid);
                // remove from red set, shift to green queue, add red queue card to set
                getPos = selectedCard.getPosition();
                redCards.remove(selectedCard);
                greenQueue.add(selectedCard);
                selectedCard.setPosition(3);
                redCards.add(redQueue.get(0));
                redQueue.remove(0);
                redCards.get(1).setPosition(getPos);
                step = 0;
                selectedGrid.deselect();
                selectedCard.deSelect();
                selectedPiece.deselect();
                System.out.println("PLAYER TURN CHANGE: g");
                playerTurn = 'g';
                break;
              }
            }
            step = 0;
            selectedGrid.deselect();
            selectedCard.deSelect();
            selectedPiece.deselect();
          }
          System.out.println("IS PLAYER TURN STILL SAME: " + playerTurn);
          if (playerTurn == 'g')
            break;
        }
        System.out.println("IS PLAYER TURN STILL SAME AT THE END: " + playerTurn);
      }
    }

    else { // GREEN TURN
      System.out.println("GREEN TURN: " + step);
      if (step == 0) {
        System.out.println("is if green step executed");
        for (int i = 0; i < greenCards.size(); i++) {
          System.out.println("is step 0 for loop executed");
          if (isMouseOverCard(greenCards.get(i))) {
            System.out.println("GREEN CARD SELECTED");
            selectedCard = greenCards.get(i);
            // check validity
            if (greenCards.contains(selectedCard)) {
              greenCards.get(i).select();
              step++;
              break;
            }
          }
        }
      } else if (step == 1) {
        for (int i = 0; i < greenPieces.size(); i++) {
          if (isMouseOverPiece(greenPieces.get(i))) {
            System.out.println("GREEN PIECE IS SELECTED");
            selectedPiece = greenPieces.get(i);
            // check validity
            selectedPiece.select();
            step++;
            break;
          }
        }
      } else if (step == 2) {
        for (int i = 0; i < grids.length; i++) {
          if (isMouseOverGrid(grids[i])) {
            System.out.println("GREEN GRID IS SELECTED");
            selectedGrid = grids[i];
            selectedGrid.select();

            coordXGrid = selectedGrid.getX();
            coordYGrid = selectedGrid.getY();
            coordXPiece = selectedPiece.getX();
            coordYPiece = selectedPiece.getY();

            coordX = coordXGrid - coordXPiece;
            coordY = coordYGrid - coordYPiece;
//            System.out.println("coordXGrid: " + coordXGrid);
//            System.out.println("coordYGrid: " + coordYGrid);
//            System.out.println("coordXPiece: " + coordXPiece);
//            System.out.println("coordYPiece: " + coordYPiece);
//            System.out.println("coordX: " + coordX);
//            System.out.println("coordY: " + coordY);
            move = new Coordinate(coordX, coordY, true);
            for (int j = 0; j < selectedCard.canMoveTo.size(); ++i) {
              if (selectedCard.canMoveTo.get(j).getX() == coordX && selectedCard.canMoveTo.get(j).getY() == coordY) {
                System.out.println("Is this GREEN set coord ever executed?");
                selectedPiece.set_coord(coordXGrid, coordYGrid);
                // remove from red set, shift to green queue, add red queue card to set
                getPos = selectedCard.getPosition();

                greenCards.remove(selectedCard);
                redQueue.add(selectedCard);
                selectedCard.setPosition(0);
                greenCards.add(greenQueue.get(0));
                greenQueue.remove(0);
                greenCards.get(1).setPosition(getPos);
                step = 0;
                selectedGrid.deselect();
                selectedCard.deSelect();
                selectedPiece.deselect();
                System.out.println("PLAYER TURN CHANGE: r");
                playerTurn = 'r';
                break;
              }
            }
            step = 0;
            selectedGrid.deselect();
            selectedCard.deSelect();
            selectedPiece.deselect();
          }
          System.out.println("IS PLAYER TURN STILL SAME: " + playerTurn);
          if (playerTurn == 'r')
            break;
        }
      }
      System.out.println("IS PLAYER TURN STILL SAME AT THE END: " + playerTurn);
    }
  }


//  /**
//   * Checks whether two cards match or not
//   *
//   * @param card1 reference to the first card
//   * @param card2 reference to the second card
//   * @return true if card1 and card2 image references are the same, false otherwise
//   */
//
//  public boolean matchingCards(Card card1, Card card2) {
//
//    if (card1.getImage().equals(card2.getImage())) {
//
//      return true;
//
//    } else
//
//      return false;
//
//  }


  public static void main(String[] args) {

    // Utility.startApplication();
    PApplet.main("Driver");
  }

}


