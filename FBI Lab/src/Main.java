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
      // list of names of men and women who drive a Chevy, Ford, or Honda and have a salary above fiften thousand dollars a year and savings below two thousand dollars
    ArrayList<String> caseTwo = SqlConnection.caseTwo();
    System.out.println("\n\n\nPrinting all suspects who match the following parameters: Men and women who drive a Chevy, Ford, or Honda and have a Salary of above $15k, and savings below $2k.\n");
    System.out.println("Name\tAddress\tState\tAge\tSex\tSalary\tSavings\tCar\tYear");
    // enhanced for loop to print the data
    for (String toPrint : caseTwo) {
      System.out.println(toPrint);
    }
    // case three
    // list of suspects that are female - Make and year of the automobile they are driving
    ArrayList<String> caseThree = SqlConnection.caseThree();
    System.out.println("\n\n\nPrinting all the suspects who match the following parameters: Females and the make and year of the automobile they drive.");
    System.out.println("Sex\tMake\tYear");
    // enhanced for loop to print the data
    for (String toPrint : caseThree) {
      System.out.println(toPrint);
    }

    // case four
    // young man (under 35) driving a ford with NJ plates
    ArrayList<String> caseFour = SqlConnection.caseFour();
    System.out.println("\n\n\nPrinting all suspects who match the following parameters: Men and women who drive a Chevy, Ford, or Honda and have a Salary of above $15k, and savings below $2k.\n");
    System.out.println("Name\tAddress\tState\tAge\tSex\tSalary\tSavings\tCar\tYear");
    // enhanced for loop to print the data
    for (String toPrint : caseFour) {
      System.out.println(toPrint);
    }
  }
}