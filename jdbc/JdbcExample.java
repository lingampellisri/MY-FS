package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC Example Program - Professional Version
 * 1. Load and register MySQL JDBC Driver
 * 2. Establish Connection to DB
 * 3. Execute SELECT query
 * 4. Display entire table data
 * 5. Handle exceptions & resources properly
 */

public class JdbcExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbms";  // Database URL
        String username = "root";                         // MySQL username
        String password = "sri@123";                      // MySQL password

        String query = "SELECT id, name, age FROM amazon"; // Query to fetch entire table

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("[INFO] Loading MySQL JDBC Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[SUCCESS] Driver Loaded Successfully.");

            System.out.println("[INFO] Establishing Database Connection...");
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("[SUCCESS] Connected to Database.");
            } else {
                System.out.println("[ERROR] Failed to Connect to Database.");
                return;
            }

            // Create Statement & Execute Query
            statement = connection.createStatement();
            System.out.println("[INFO] Executing Query: " + query);
            resultSet = statement.executeQuery(query);

            // Print Table Header
            System.out.println("\n[RESULT] Amazon Table Data:");
            System.out.println("------------------------------------------");
            System.out.printf("%-5s %-25s %-5s\n", "ID", "Name", "Age");
            System.out.println("------------------------------------------");

            boolean hasData = false;

            // Fetching Data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.printf("%-5d %-25s %-5d\n", id, name, age);
                hasData = true;
            }

            if (!hasData) {
                System.out.println("[INFO] No data found in the table.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[ERROR] MySQL JDBC Driver Not Found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("[ERROR] SQL Exception Occurred.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("\n[INFO] Resources closed successfully.");
            } catch (SQLException e) {
                System.out.println("[ERROR] Error while closing resources.");
                e.printStackTrace();
            }
        }
    }
}
