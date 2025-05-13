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
public class jdbc4 {

    public static void main(String[] args) {

        
        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/dbms";
          String query="insert into amazon value(?,?,?)";
        // String query="select * from amazon";

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

            //    stmt= con.createStatement();
            psstmt=con.prepareStatement("insert into amazon value(?,?,?)");
            psstmt.setInt(1, 6);
            psstmt.setString(2, "Vishuu");
            psstmt.setInt(3, 23);
                //  int upcount= psstmt.executeUpdate(query);
                int upres=psstmt.executeUpdate();
                if(upres>0)
                System.out.println(upres+ " : Data Inserted");
                else{
                    System.out.println("Fail to insert");
                }


            //  while (res.next()) {

            //     System.out.print(res.getInt("id")+" ,");
            //     System.out.print(res.getString("name")+", ");
            //      System.out.print(res.getInt("age"));
            //      System.out.println();
                
            //  }



  
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

