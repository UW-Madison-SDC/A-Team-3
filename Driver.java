import processing.core.PApplet;
import processing.core.PImage;

public class Driver extends PApplet {
//import java.io.File;



//public class MemoryGame {

    // Congratulations message

    private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";

    // Cards not matched message

    private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";

    // Cards matched message

    private final static String MATCHED = "CARDS MATCHED! Good Job!";

    // 2D-array which stores cards coordinates on the window display

    private final static float[][] CARDS_COORDINATES =

            new float[][]{{170, 170}, {324, 170}, {478, 170}, {632, 170},

                    {170, 324}, {324, 324}, {478, 324}, {632, 324},

                    {170, 478}, {324, 478}, {478, 478}, {632, 478}};

    // Array that stores the card images filenames

    private final static String[] CARD_IMAGES_NAMES = new String[]{"Artillery Truck.png", "Attack Helicopter.png", "Basic Card.png",  
"Cargo Plane.png", "Carrier.png", "Cruiser.png", "Destroyer.png", "Fighter Jet.png", "Humvee.png", "Jeep.png", "Medical Helicopter.png", 
"Military Motorcycle.png", "Patrol Boat.png", "Stealth Bomber.png", "Tank.png", "Train.png"};



    private static PApplet processing; // PApplet object that represents

    // the graphic display window

    private static Card[] cards; // one dimensional array of cards

    private static PImage[] images; // array of images of the different cards

    private static Card selectedCard1; // First selected card

    private static Card selectedCard2; // Second selected card

    private static boolean winner; // boolean evaluated true if the game is won,

    // and false otherwise

    private static int matchedCardsCount; // number of cards matched so far

    // in one session of the game

    private static String message; // Displayed message to the display window



    /**

     * Defines the initial environment properties of this game as the program starts

     */

    public static void setup(PApplet processing) {

        MemoryGame.processing = processing;

        images = new PImage[CARD_IMAGES_NAMES.length];

        for (int i = 0; i < images.length; ++i) {

            images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);

            processing.image(images[i], processing.width / 2, processing.height / 2);

        }

        startNewGame();

    }



    /**

     * Initializes the Game

     */

    public static void startNewGame() {

        selectedCard1 = null;

        selectedCard2 = null;

        matchedCardsCount = 0;

        winner = false;

        message = "";

        cards = new Card[CARDS_COORDINATES.length];

        int[] mixedUp = Utility.shuffleCards(cards.length);

        for (int i = 0; i < cards.length; ++i) {

            cards[i] = new Card(images[mixedUp[i]], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);

        }

    }



    /**

     * Callback method called each time the user presses a key

     */

    public static void keyPressed() {

        if (processing.key == 'n' || processing.key == 'N') {

            startNewGame();

        }

    }



    /**

     * Callback method draws continuously this application window display

     */

    public static void draw() {

        processing.background(245, 255, 250); // Mint cream color

        for (int i = 0; i < cards.length; ++i) {

            cards[i].draw();

        }

        displayMessage(message);

    }



    /**

     * Displays a given message to the display window

     *

     * @param message to be displayed to the display window

     */

    public static void displayMessage(String message) {

        processing.fill(0);

        processing.textSize(20);

        processing.text(message, processing.width / 2, 50);

        processing.textSize(12);

    }



    /**

     * Checks whether the mouse is over a given Card

     *

     * @return true if the mouse is over the storage list, false otherwise

     */

    public static boolean isMouseOver(Card card) {

        boolean mouseOverCard = false;

        if (Math.abs(card.getX() - processing.mouseX) <= (card.getImage().width / 2) &&

                Math.abs(card.getY() - processing.mouseY) <= (card.getImage().height / 2)) {

            mouseOverCard = true;

        } else {

            mouseOverCard = false;

        }

        return mouseOverCard;

    }



    /**

     * Callback method called each time the user presses the mouse

     */

    public static void mousePressed() {

        boolean imageMatched;

        if (!winner) {

            if (selectedCard1 != null && selectedCard2 != null) {

                if (!selectedCard1.isMatched() && !selectedCard2.isMatched()) {

                    selectedCard1.setVisible(false);

                    selectedCard2.setVisible(false);

                }

                selectedCard1.deselect();

                selectedCard2.deselect();

                selectedCard1 = null;

                selectedCard2 = null;

            }



            for (int i = 0; i < cards.length; ++i) {

                if (isMouseOver(cards[i])) {

                    if (!cards[i].isMatched() && cards[i] != selectedCard1) {

                        if (selectedCard1 == null) {

                            selectedCard1 = cards[i];

                            selectedCard1.setVisible(true);

                            selectedCard1.select();

                        } else {

                            selectedCard2 = cards[i];

                            selectedCard2.setVisible(true);

                            selectedCard2.select();

                            imageMatched = matchingCards(selectedCard1, selectedCard2);



                            if (imageMatched) {

                                ++matchedCardsCount;

                                if (matchedCardsCount == 6) {

                                    winner = true;

                                    message = CONGRA_MSG;

                                } else {

                                    message = MATCHED;

                                }

                                selectedCard1.setMatched(true);

                                selectedCard2.setMatched(true);

                            } else {

                                message = NOT_MATCHED;

                            }

                        }

                    }

                }

            }

        }

    }



    /**

     * Checks whether two cards match or not

     *

     * @param card1 reference to the first card

     * @param card2 reference to the second card

     * @return true if card1 and card2 image references are the same, false otherwise

     */

    public static boolean matchingCards(Card card1, Card card2) {

        if (card1.getImage().equals(card2.getImage())) {

            return true;

        } else

            return false;

    }



    public static void main(String[] args) {

        Utility.startApplication();

    }

//}


}
    
