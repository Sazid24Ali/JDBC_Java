package JDBC_demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    Connection connection = null;
    String dataBaseName ;
    String jdbcUrl;
    String user ;
    String password ;

    DatabaseConn(String dataBaseName) {
        this.dataBaseName = dataBaseName;
        jdbcUrl = "jdbc:mysql://localhost:3306/".concat(dataBaseName);
        user = "root";
        password = "mysql";
    }
    DatabaseConn() {
        this.dataBaseName = "JavaConn";
        jdbcUrl = "jdbc:mysql://localhost:3306/".concat(dataBaseName);
        user = "root";
        password = "mysql";
    }

    Connection getConnection() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, user, password);
            
        } catch (SQLException sqlException) {
            System.out.println("Error Raised \nConection Failed");
        }
        return connection;
    }
}
