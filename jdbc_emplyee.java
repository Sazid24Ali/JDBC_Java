package JDBC_demos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;


public class jdbc_emplyee {
    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn();
        Connection connection = empTableConn.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metaData = null;
        try{
            //connection = DriverManager.getConnection(jdbcUrl,user,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
            metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("\n");
            for (int i=1;i<=columnCount;i++){
                System.out.print(metaData.getColumnLabel(i)+"\t\t");
            }
            System.out.println("\n");
            while (resultSet.next()){
                System.out.println("   "+resultSet.getString(1)+"\t\t"+
                    resultSet.getString(2)+"\t\t"+
                    resultSet.getString(3));
    
                //System.out.println(resultSet.getString("));
            }
        }catch(SQLException sqlException){
            System.out.println("Error Raised");
            System.out.println(sqlException);
        }
        finally{
            try {
                connection.close();
                statement.close();
                resultSet.close();
                
            } catch (SQLException sqlException) {
                System.out.println("Inside the finally block");
            }
        }
    }
}
