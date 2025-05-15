package jdbc.resultSet;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

/**
 * prepareStatement code
 * A PreparedStatement represents a precompiled SQL statement 
 * that can be executed multiple times. It accepts parameterized SQL queries, 
 * with ? as placeholders for parameters, which can be set dynamically.
 */
public class day1 {

    public static void main(String[] args) {

        
        String user="root";
        String password="sri@123";
          String url = "jdbc:mysql://localhost:3306/test";
        //   String query="insert into amazon value(5,'KamalHasssan',24)";
        String query="select * from emp";

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
            psstmt=con.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 res= psstmt.executeQuery();
               

        //         res.absolute(2);
        //   res.updateString("ename", "priyaaaa!");

        //         res.updateRow();
        //         res.beforeFirst();

        // System.out.println(res);

                System.out.println("************************SChema Details*************************");
                
                ResultSetMetaData resm= res.getMetaData();
                System.out.println(resm.getTableName(1));
                System.out.println(resm.getCatalogName(1));
           
                // Print column count
            int columnCount = resm.getColumnCount();
            System.out.println("Total Columns: " + columnCount);

            // Loop through columns and print metadata
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name       : " + resm.getColumnName(i));
                System.out.println("  Type       : " + resm.getColumnTypeName(i));
                System.out.println("  Table Name : " + resm.getTableName(i));
                System.out.println("  Catalog    : " + resm.getCatalogName(i));
            }

                


 System.out.printf("%-6s %-15s %-12s %-6s %-12s %-10s %-10s %-7s\n",
                    "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno");

            System.out.println("----------------------------------------------------------------------");

            // 6. Loop through and print each row
            while (res.next()) {
                System.out.printf("%-6d %-15s %-12s %-6s %-12s %-10.2f %-10.2f %-7d\n",
                        res.getInt("empno"),
                        res.getString("ename"),
                        res.getString("job"),
                        res.getObject("mgr") == null ? "NULL" : res.getInt("mgr"),
                        res.getDate("hiredate"),
                        res.getDouble("sal"),
                        res.getDouble("comm"),
                        res.getInt("deptno"));
            }

            res.ins



  
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
