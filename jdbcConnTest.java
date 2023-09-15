package JDBC_demos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "mysql";

        Connection connection = null;

        try {
            // Attempt to establish a database connection
            connection = DriverManager.getConnection(jdbcUrl,user, password);
            
            // If no exception is thrown, the connection is confirmed
            System.out.println("Connection confirmed.");
            
            // You can now use this connection for database operations.
        } catch (SQLException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection CLosed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
