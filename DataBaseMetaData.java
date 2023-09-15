package JDBC_demos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DataBaseMetaData {
    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn("");
        Connection connection = empTableConn.getConnection();
        try {
            DatabaseMetaData dataBaseMetaData = connection.getMetaData();
            //Driver Name
            System.out.println("Driver Name : "+dataBaseMetaData.getDriverName());
            //Driver Version
            System.out.println("Driver Version : "+dataBaseMetaData.getDriverVersion());
            //Database Product name
            System.out.println("Database Product Name: "+dataBaseMetaData.getDatabaseProductName());
            //Databse Product Version
            System.out.println("Database Product Vaersion : "+dataBaseMetaData.getDatabaseProductVersion());
            
            System.out.println("Url : "+dataBaseMetaData.getURL());
            System.out.println("UserName : "+dataBaseMetaData.getUserName());

        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
}
