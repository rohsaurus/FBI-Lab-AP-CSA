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
       /* finally {
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Connection failed");
            }

        */

        return conn;
    }

    public static void insert(String name, String address, String state, int age, String sex, int Salary, int savings, String car, int year) {
      String sql = "INSERT INTO Main(Name, Address, State, Age, Sex, Salary, Savings, Car, Year) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
            Connection conn = Connect();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2,address);
            pstmt.setString(3,state);
            pstmt.setInt(4,age);
            pstmt.setString(5,sex);
            pstmt.setInt(6,Salary);
            pstmt.setInt(7,savings);
            pstmt.setString(8,car);
            pstmt.setInt(9,year);
          // executing SQL insertion statement
            pstmt.executeUpdate();
           // conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void selectAll(){
        String sql = "SELECT * FROM Main";

        try {
            Connection conn = Connect();
            Statement stmt1  = conn.createStatement();
            ResultSet rs    = stmt1.executeQuery(sql);
            System.out.println(rs);
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + rs.getTimestamp("created_at") + "\t" + rs.getString("email") +
                        rs.getString("name") + "\t" +
                        rs.getString("SendReceive") + rs.getByte("Keyvalue"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
