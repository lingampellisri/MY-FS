package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.rowset.spi.SyncResolver;

import java.sql.ResultSet;

public class jdbc2 {

    public static void main(String[] args) {

        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/dbms";
          String query="insert into amazon value(5,'KamalHasssan',24)";
        // String query="select * from amazon";

          Connection con=null;
          Statement stmt=null;
          ResultSet res=null;

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

               stmt= con.createStatement();
                //  res= stmt.executeQuery(query);
                int upres=stmt.executeUpdate(query);
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
