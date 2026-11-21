package com.sabeer.database.jdbc.module08;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
class BookingDao {
 private Connection open() throws SQLException {return DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword);}
 public void printBookings() throws SQLException {
  String sql="SELECT id,customer_name,amount FROM bookings ORDER BY id";
  try(Connection c=open();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){
   while(r.next())System.out.printf("%d | %s | %s%n",r.getLong("id"),r.getString("customer_name"),r.getBigDecimal("amount"));
  }
 }
}
public class Main {
 public static void main(String[] args){
  BookingDao dao=new BookingDao();
  try{dao.printBookings();}catch(SQLException e){System.err.println("DAO read failed: "+e.getMessage());}
 }
}