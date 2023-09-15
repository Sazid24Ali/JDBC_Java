package JDBC_demos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MetaData {
    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn();
        Connection connection = empTableConn.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData  = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE;");
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData = resultSet.getMetaData();

            //Table Name
            System.out.println("Table Name : "+resultSetMetaData.getTableName(1));
            //Column COunt
            System.out.println("Total NUmber of columns : "+resultSetMetaData.getColumnCount());
            //Column Name
            System.out.println("Column Name 1 "+resultSetMetaData.getColumnName(1));
            
            

        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
}
