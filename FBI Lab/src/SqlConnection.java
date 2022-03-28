
/**
 * Rohan Parikh
 * FBI Lab
 * 27 March 2022 - 
 * Extra Thing: Storing data in a SQLite database
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlConnection {
    public static Connection Connect() {
        Connection conn = null;
        try {
            // database params
            String url = "jdbc:sqlite:FBILab.sqlite";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        /*
         * finally {
         * try {
         * if (conn != null) {
         * conn.close();
         * }
         * 
         * } catch (SQLException ex) {
         * ex.printStackTrace();
         * System.out.println("Connection failed");
         * }
         * 
         */

        return conn;
    }

    public static void insert(String name, String address, String state, int age, String sex, int Salary, int savings,
            String car, int year) {
        String sql = "INSERT INTO Main(Name, Address, State, Age, Sex, Salary, Savings, Car, Year) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = Connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, state);
            pstmt.setInt(4, age);
            pstmt.setString(5, sex);
            pstmt.setInt(6, Salary);
            pstmt.setInt(7, savings);
            pstmt.setString(8, car);
            pstmt.setInt(9, year);
            // executing SQL insertion statement
            pstmt.executeUpdate();
            // conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectAll() {
        String sql = "SELECT * FROM Main ORDER BY Name";

        try {
            Connection conn = Connect();
            Statement stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(sql);
            System.out.println(rs);
            // loop through the result set

            System.out.println("Name\tAddress\tState\tAge\tSex\tSalary\tSavings\tCar\tYear");
            while (rs.next()) {
                // grabing values into variables for easier and better lookng print statements
                String _name = rs.getString("Name");
                String _address = rs.getString("Address");
                String _state = rs.getString("State");
                int _age = rs.getInt("Age");
                String _sex = rs.getString("Sex");
                int _Salary = rs.getInt("Salary");
                int _savings = rs.getInt("Savings");
                String _car = rs.getString("Car");
                int _year = rs.getInt("Year");
                // printing output
                System.out.println(_name + "\t" + _address + "\t" + _state + "\t" + _age + "\t" + _sex + "\t" + _Salary
                        + "\t" + _savings + "\t" + _car + "\t" + _year);
            }
            // closing connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> caseOne() {
        String sql = "SELECT * FROM Main WHERE Sex='M' AND Car='Ford' AND Salary > 20000 AND Age>30;";
        // arraylist to store and return
        ArrayList<String> results = new ArrayList<String>();
        // try and catch loop to attempt to connect to the DB and grab the values needed
        try {
            Connection conn = Connect();
            // creating statement and executing SQL statement
            Statement stm1 = conn.createStatement();
            ResultSet rs = stm1.executeQuery(sql);
            // looping through the result set, adding the values to the arraylist
            while (rs.next()) {
                results.add(rs.getString("Name") + "\t" + rs.getString("Address") + "\t" + rs.getString("State") + "\t"
                        + rs.getInt("Age") + "\t" + rs.getString("Sex") + "\t" + rs.getInt("Salary") + "\t"
                        + rs.getInt("Savings") + "\t" + rs.getString("Car") + "\t" + rs.getInt("Year"));
            }
            // closing connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("There was a SQL error.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Some other generic error... Printing stack trace");
            e.printStackTrace();
        }
        // returning the arraylist with the speicifed values to be sorted in main
        return results;
    }

    public static ArrayList<String> caseTwo () {
        String sql = "SELECT * FROM Main WHERE (Car='Chevy' OR Car='Ford' OR Car='Honda') AND Salary>15000 AND Savings<2000;";
        // arraylist to store and return
        ArrayList<String> results = new ArrayList<String>();
        // try and catch loop to attempt to connect to the DB and grab the values needed
        try {
            Connection conn = Connect();
            // creating statement and executing SQL statement
            Statement stm1 = conn.createStatement();
            ResultSet rs = stm1.executeQuery(sql);
            // looping through the result set, adding the values to the arraylist
            while (rs.next()) {
                results.add(rs.getString("Name") + "\t" + rs.getString("Address") +"\t" + rs.getString("State") + "\t" + rs.getInt("Age") + "\t" + rs.getString("Sex") + "\t" + rs.getInt("Salary") + "\t" + rs.getInt("Savings") + "\t" + rs.getString("Car") + "\t" + rs.getInt("Year"));}
            // closing the connection
            conn.close();
    }
    catch (SQLException e) {
        System.out.println("There was a SQL error.");
        e.printStackTrace();
    }
    catch (Exception e) {
        System.out.println("Some other generic error... Printing stack trace");
        e.printStackTrace();
    }
    return results;
    }

    public static ArrayList<String> caseThree() {
        String sql = "SELECT Sex,Car,Year FROM Main WHERE Sex='F';";
        // arraylist to store and return the values
        ArrayList<String> results = new ArrayList<String>();
        try {
            Connection conn = Connect();
            // creating statement and executing SQL statement
            Statement stm1 = conn.createStatement();
            ResultSet rs = stm1.executeQuery(sql);
            // looping through the result set, adding the values to the arraylist
            while (rs.next()) {
                results.add(rs.getString("Sex") +"\t" + rs.getString("Car") + "\t" + rs.getInt("Year"));
        }
        // closing the db connection
        conn.close();
    }
    // catch statements to catch exception
    catch (SQLException e) {
        System.out.println("There was a SQL error.");
        e.printStackTrace();
    }
    catch (Exception e) {
        System.out.println("Some other generic error... Printing stack trace");
        e.printStackTrace();
    }
    // returning the arraylist
    return results;
    }

    public static ArrayList<String> caseFour() {
        String sql = "SELECT * FROM Main WHERE Car='Ford' AND Age<35 AND State='NJ' AND Sex='M';";
        // arraylist to store and return the data
        ArrayList<String> results = new ArrayList<String>();
        try {
            // establishing connection to the database and executing SQL query
            Connection conn = Connect();
            Statement stm1 = conn.createStatement();
            ResultSet rs = stm1.executeQuery(sql);
            // looping through the result set, adding the values to the arraylist
            while (rs.next()) {
                results.add(rs.getString("Name") + "\t" + rs.getString("Address") + "\t" + rs.getString("State") + "\t"
                        + rs.getInt("Age") + "\t" + rs.getString("Sex") + "\t" + rs.getInt("Salary") + "\t" + rs.getInt("Savings") + "\t" + rs.getString("Car") + "\t" + rs.getInt("Year"));
        }
        // closing the conneciton
        conn.close();
    }
    // catch statements
    catch (SQLException e) {
        System.out.println("There was a SQL error.");
        e.printStackTrace();
    }
    catch (Exception e) {
        System.out.println("Some other generic error... Printing stack trace");
        e.printStackTrace();
    }
    return results;
}
}
