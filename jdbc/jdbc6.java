package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * prepareStatement code
 * A PreparedStatement represents a precompiled SQL statement 
 * that can be executed multiple times. It accepts parameterized SQL queries, 
 * with ? as placeholders for parameters, which can be set dynamically.
 */
public class jdbc6 {

    public static void main(String[] args) {

        
        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/dbms";



          Connection con=null;
          Statement stmt=null;
          ResultSet res=null;
          PreparedStatement psstmt=null;


        try{

              Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection(url, user, password);
              if(con!=null)
              {
                System.out.println("Connection Established");

              }
              else{
                System.out.println("Fail to Establish Connection");
                return; 
              }

          
            psstmt=con.prepareStatement("update  amazon set name=? where id=?");
            psstmt.setString(1, "navanitha");
            psstmt.setInt(2, 6);
                 int count=psstmt.executeUpdate();

                 if(count>0)
                 System.out.println(count+" : Record updated Successfully");
                 else
                 System.out.println("No Record are Deleted");
              

        }
  
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Exception Occurred: " + e.getMessage());
            e.printStackTrace();
        }
        finally{
               
              try {
                if (res != null) res.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("\n[INFO] Resources closed successfully.");
            } catch (SQLException e) {
                System.out.println("[ERROR] Error while closing resources.");
                e.printStackTrace();
            }

            
        }
        
    }
    
}
