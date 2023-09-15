package JDBC_demos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MathodsForJDBC {

    static void insertData(PreparedStatement preparedStatement, int empId, String empName, int empSalary)
            throws SQLException {
        preparedStatement.setInt(1, empId);
        preparedStatement.setString(2, empName);
        preparedStatement.setInt(3, empSalary);
        int rowCount = preparedStatement.executeUpdate();
        System.out.println("\n" + rowCount + " row was Inserted");
    }

    static void updateName(PreparedStatement preparedStatement, String empName_new, int empId) throws SQLException {
        preparedStatement.setString(1, empName_new);
        preparedStatement.setInt(2, empId);
        int updateCount = preparedStatement.executeUpdate();
        System.out.println("\n" + updateCount + " row was Updated");
    }
  
    static void deleteFeild(PreparedStatement preparedStatement,int empId) throws SQLException{
        preparedStatement.setInt(1, empId);
        int deleteCount = preparedStatement.executeUpdate();
        System.out.println("\n" + deleteCount + " row was deleted");
    }

    static void showTable(Statement statement) throws SQLException{
        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");
        ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
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
    }

    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn();
        Connection connection = empTableConn.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //Display
            System.out.println("\n\nThe Table Before Changing");
            showTable(connection.createStatement());
            //Inserting Data
            preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUE(?,?,?)");
            insertData(preparedStatement, 3, "EMp3", 125000);
            //Display
            System.out.println("\nAfter Inserting Data");
            showTable(connection.createStatement());

            //Updating Data
            preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET EMPNAME=? WHERE EMPID=? ");
            updateName(preparedStatement, "ABC", 1);
            //Display
            System.out.println("\nAfter Upadating Data");
            showTable(connection.createStatement());

            //Deleting Data
            preparedStatement = connection.prepareStatement(" DELETE FROM EMPLOYEE WHERE EMPID=?");
            deleteFeild(preparedStatement, 2);
            //Display
            System.out.println("\nAfter Deleting Data");
            showTable(connection.createStatement());

            //CLosing the Connection
            connection.close();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            System.out.println("Connection was Not made\n"+sqlException);
            

        }
    }

}
