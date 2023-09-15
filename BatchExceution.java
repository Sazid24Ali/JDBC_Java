package JDBC_demos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BatchExceution {
    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn();
        Connection connection = empTableConn.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(" "+resultSet.getString(1)+" "+
                resultSet.getString(2)+" "+
                resultSet.getString(3));
            }
            //batch codes/codes
            preparedStatement.addBatch("INSERT INTO EMPLOYEE VALUES(101,\"Emp101\",152000)");
            preparedStatement.addBatch("INSERT INTO EMPLOYEE VALUES(102,\"Emp102\",152000)");
            preparedStatement.addBatch("INSERT INTO EMPLOYEE VALUES(103,\"Emp103\",153000)");
            preparedStatement.addBatch("UPDATE EMPLOYEE SET EMPSALARY=193000 WHERE EMPID=103");

            int[] rows = preparedStatement.executeBatch();
            System.out.println("The rows inserted and updated  : "+rows.length);
        } catch (Exception e) {
            System.out.println(e);
            
            System.out.println(e);
        }
        finally{
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
                
            } catch (Exception e) {
                System.out.println(e);
                
                System.out.println(e);
            }
            

        }
    }
}
