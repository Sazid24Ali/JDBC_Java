package JDBC_demos;


//1.Importing the modules 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;

public class jdbc_d1 {

    public static void main(String[] args) throws Exception {
        //2.Register and loading the drivers ( Not needed )
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection Info Here
        String dataBaseName = "Student";
        String jdbcUrl = "jdbc:mysql://localhost:3306/".concat(dataBaseName);
        String user = "root";
        String password = "mysql";
        //Varibale for Connection
        Connection connection = null;
        try{
            //3.Establishing Connection ( Here "DriverManager" is static class to establish connection ) 
            connection = DriverManager.getConnection(jdbcUrl,user,password);
        }catch (SQLException sql){
            System.out.println("Sql Connection Failed");
        }
        //4. Create Statement
        Statement statement = connection.createStatement();
        //5.Exceute The Statement
        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT_INFO");

        // Get ResultSetMetaData
        ResultSetMetaData metaData = resultSet.getMetaData();
            
        // Get column count
        
        //int columns = resultSet.getMetaData().getColumnCount();
        //System.out.println("Total columns in ResultSet: " + columns);
        int columnCount = metaData.getColumnCount();
        //System.out.println("Total columns in ResultSet: " + columnCount);

        //6.Printing the output
        System.out.println("\n");
        for (int i=1;i<=columnCount;i++){
            System.out.print(metaData.getColumnLabel(i)+"\t");
        }
        System.out.println("\n");
        //System.out.println("Student ID\tStudent Name\tCourse ");
        while (resultSet.next()){
            System.out.println("\t"+resultSet.getString(1)+"\t"+
                resultSet.getString(2)+"\t"+
                resultSet.getString(3));

            //System.out.println(resultSet.getString("));
        }

        connection.close();
        
       
        }
}