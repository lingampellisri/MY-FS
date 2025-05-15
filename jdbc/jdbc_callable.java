package jdbc;

import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;

/**
A CallableStatement is an interface in Java that is used to execute SQL stored procedures.
 It extends the PreparedStatement interface and provides methods to handle input and output parameters. 
 Stored procedures are precompiled SQL statements that can be executed by the database server, 
 which can improve performance and encapsulate business logic.
 */
public class jdbc_callable {

    public static void main(String[] args) {

        
        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/test";



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

          
            cs=con.prepareCall("{call empCount(?)}");
            cs.setInt(1, 20);
            
              cs.registerOutParameter(1, Types.INTEGER);

              cs.execute();

              int count=cs.getInt(1);
              System.out.println(count);
      

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


