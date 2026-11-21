package com.sabeer.database.jdbc.module06;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
public class Main {
 public static void main(String[] args){
  try(Connection c=DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword());Statement s=c.createStatement()){
   s.executeUpdate("CREATE TABLE IF NOT EXISTS jdbc_batch_demo(id BIGINT AUTO_INCREMENT PRIMARY KEY,label VARCHAR(100) NOT NULL)");
   c.setAutoCommit(false);
   try(PreparedStatement p=c.prepareStatement("INSERT INTO jdbc_batch_demo(label) VALUES(?)",Statement.RETURN_GENERATED_KEYS)){
    for(String label:new String[]{"batch-A","batch-B","batch-C"}){p.setString(1,label);p.addBatch();}
    int[] counts=p.executeBatch();System.out.println("Batch result entries: "+counts.length);
    try(ResultSet keys=p.getGeneratedKeys()){while(keys.next())System.out.println("Generated id: "+keys.getLong(1));}
   }finally{c.rollback();c.setAutoCommit(true);System.out.println("Batch inserts rolled back.");}
  }catch(SQLException e){System.err.println("Batch demo failed: "+e.getMessage());}
 }
}