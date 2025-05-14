package jdbc;

import java.sql.CallableStatement;
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
public class jdbc_callable {

    public static void main(String[] args) {

        
        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/dbms";



          Connection con=null;
          Statement stmt=null;
          ResultSet res=null;
          PreparedStatement psstmt=null;
          CallableStatement cs=null;


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

          
            cs=con.prepareCall("{call filterbyage(?)}");
            cs.setInt(1, 20);
           
            res=cs.executeQuery();

        
             while (res.next()) {

                System.out.print(res.getInt("id")+" ,");
                System.out.print(res.getString("name")+", ");
                 System.out.print(res.getInt("age"));
                 System.out.println();
                
             }

                
              

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
