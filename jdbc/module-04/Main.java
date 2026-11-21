package com.sabeer.database.jdbc.module04;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
public class Main {
 public static void main(String[] args) {
  try(Connection c=DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword())) {
   c.setAutoCommit(false);
   try {
    long id;
    try(PreparedStatement p=c.prepareStatement("INSERT INTO bookings(customer_name,amount) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS)){
     p.setString(1,"JDBC CRUD practice"); p.setBigDecimal(2,new java.math.BigDecimal("25.00"));
     if(p.executeUpdate()!=1) throw new SQLException("Insert count was not 1");
     try(ResultSet keys=p.getGeneratedKeys()){if(!keys.next())throw new SQLException("No generated key");id=keys.getLong(1);}
    }
    try(PreparedStatement p=c.prepareStatement("SELECT id,customer_name,amount FROM bookings WHERE id=?")){p.setLong(1,id);try(ResultSet r=p.executeQuery()){if(r.next())System.out.printf("Created: %d %s %s%n",r.getLong(1),r.getString(2),r.getBigDecimal(3));}}
    try(PreparedStatement p=c.prepareStatement("UPDATE bookings SET customer_name=? WHERE id=?")){p.setString(1,"CRUD updated");p.setLong(2,id);System.out.println("Updated rows: "+p.executeUpdate());}
    try(PreparedStatement p=c.prepareStatement("DELETE FROM bookings WHERE id=?")){p.setLong(1,id);System.out.println("Deleted rows: "+p.executeUpdate());}
   } finally {c.rollback();System.out.println("Rolled back demo changes.");}
  } catch(SQLException e){System.err.println("CRUD demo failed: "+e.getMessage());}
 }
}