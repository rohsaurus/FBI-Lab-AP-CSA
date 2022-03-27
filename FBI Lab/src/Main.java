import java.util.ArrayList;

/**
 * Rohan Parikh
 * FBI Lab
 * 27 March 2022 - 
 * Extra Thing: Storing data in a SQLite database
 */
public class Main {
  public static void main  (String[] args) {
    System.out.println("Hello World");
    // establishing connection to the database to test if it works
    SqlConnection.Connect();
    // printing sorted database
    SqlConnection.selectAll();

    // Database is prepopulated already so now will be doing the requested operations
    
    // case 1: list of names and address of men over 30 years old, own a Ford, and an income of over $20k
    ArrayList<String> caseOne = SqlConnection.caseOne();
    // printing the arraylist
    System.out.println("\n\n\nPrinting all suspects who match the following parameters: Men over 30 years of age, own a Ford, and have an income of over $20k.\n");
    System.out.println("Name\tAddress\tState\tAge\tSex\tSalary\tSavings\tCar\tYear");
    for (String toPrint : caseOne) {
      System.out.println(toPrint);
    }


    // case two: 
    
  }
}