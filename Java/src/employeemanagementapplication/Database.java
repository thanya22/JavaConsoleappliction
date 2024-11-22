package employeemanagementapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
  public void databasedetails(String s) {
  try{
  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
  Statement statement=connection.createStatement();
  statement.executeUpdate(s);
  statement.executeQuery(s);
  connection.close();
  System.out.println("Successful");
  }
  catch(SQLException sqlException) {
    System.err.println(sqlException);
  }
  
  }
}