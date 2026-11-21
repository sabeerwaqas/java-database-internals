package com.sabeer.database.jdbc.module03;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
public class Main {
 public static void main(String[] args) {
  String sql="SELECT id, customer_name, amount FROM bookings ORDER BY id";
  try(Connection c=DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword());
      Statement s=c.createStatement(); ResultSet rs=s.executeQuery(sql)) {
   ResultSetMetaData md=rs.getMetaData();
   System.out.println("Columns: "+md.getColumnCount());
   while(rs.next()) {
    long id=rs.getLong("id");
    String customer=rs.getString("customer_name");
    java.math.BigDecimal amount=rs.getBigDecimal("amount");
    System.out.printf("id=%d customer=%s amount=%s%n",id,customer,amount);
   }
  } catch(SQLException e){System.err.println("Read failed: "+e.getMessage());}
 }
}