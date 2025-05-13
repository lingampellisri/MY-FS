package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;


/**
 * 1. import the packages
 * 2. load the drivers
 * 3. register the drivers
 * 4. establlish the connection
 * 5. prepare the query and execute the query
 * 6. store the result into resultSet
 * 7. close the resources
 * 
 */

public class Jdbc1 {

    public static void main(String[] args)  throws Exception{
        String url = "jdbc:mysql://localhost:3306/dbms"; // Added :3306 (default MySQL port)
        String uname = "root";
        String pass = "sri@123";

        String query = "select name from amazon where id=1";

         Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);

        System.out.println(con);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        if(rs.next()) {
            String name = rs.getString("name"); // Fixed field name
            System.out.println(name);
        } else {
            System.out.println("No data found.");
        }

        rs.close();
        st.close();
        con.close();
    }
    
}
