package JDBC_demos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertIntoEmp {
    public static void main(String[] args) {
        DatabaseConn empTableConn = new DatabaseConn();
        Connection connection = empTableConn.getConnection();
        PreparedStatement preparedStatement = null;
        Scanner InputObj = new Scanner(System.in);
        int choice;
        
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUE(?,?,?)");
            do{
                System.out.println("\t\n\nSelect An Option "+
                "\n\n1) Insert Data"+
                "\n0) Exit");
                System.out.print("\n\nEnter Here : ");
                choice = InputObj.nextInt();
                switch(choice){
                    case 0:{
                        break;
                    }case 1:{
                        int empid,empSalary;String empName;
                        System.out.print("\nEnter the Employee Id : ");
                        empid = InputObj.nextInt();
                        System.out.print("\nEnter the Employee Name : ");
                        empName = InputObj.next();
                        System.out.print("\nEnter the Employee Salary : ");
                        empSalary = InputObj.nextInt();
                        MathodsForJDBC.insertData(preparedStatement,empid, empName,empSalary);
                        break;
                    }
                    default:{
                        System.out.println("Wrong Input \nTryAgain...");
                    }
                }
            }while (choice!=0);
        }catch(SQLException sqlException){
        }finally{
            try{
                connection.close();
                preparedStatement.close();
                InputObj.close();

            }catch(SQLException sqlException2){
                System.out.println("Unableto Close");
            }

        }
    }
}
