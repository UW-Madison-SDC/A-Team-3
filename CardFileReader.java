import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads a given CSV file
 * 
 * @author Fahim Islam
 *
 */
public class CardFileReader {
  public static void main(String[] args) {
    //CardFileReader fr = new CardFileReader();
    //fr.readFile();
  }

  private List<Object> readFile() {
    List<Object> read = new ArrayList<>();
    File file = new File("cards.csv");
    Scanner reader = null;
    
    
    List<String> listStrings = new ArrayList<>();
    try {
      reader = new Scanner(file);
      while(reader.hasNextLine()) {
        listStrings.add(reader.nextLine());
      }
      
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File " + file.getName() + " was not found!");
    }
    finally {
      reader.close();
    }
    return null;
    
    
    
    
    
  }
  
  
  
  
}
