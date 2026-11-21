package com.sabeer.database.jdbc.module07;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
public class Main {
 public static void main(String[] args){
  try(Connection c=DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword());
      Statement s=c.createStatement()){
   s.executeQuery("SELECT * FROM jdbc_table_that_does_not_exist");
  }catch(SQLException e){
   System.err.println("Expected SQL failure demonstration");
   System.err.println("Message: "+e.getMessage());
   System.err.println("SQLState: "+e.getSQLState());
   System.err.println("Vendor code: "+e.getErrorCode());
  }
  System.out.println("Try-with-resources has closed JDBC resources.");
 }
}