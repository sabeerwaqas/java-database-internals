package com.sabeer.database.jdbc.module05;
import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;
public class Main {
 public static void main(String[] args) {
  try(Connection c=DriverManager.getConnection(DatabaseConfig.getUrl(),DatabaseConfig.getUsername(),DatabaseConfig.getPassword());Statement s=c.createStatement()){
   s.executeUpdate("CREATE TABLE IF NOT EXISTS jdbc_tx_accounts (id INT PRIMARY KEY, balance DECIMAL(12,2) NOT NULL)");
   s.executeUpdate("INSERT INTO jdbc_tx_accounts(id,balance) VALUES(1,1000.00),(2,500.00) ON DUPLICATE KEY UPDATE id=id");
   c.setAutoCommit(false);
   try {
    try(PreparedStatement debit=c.prepareStatement("UPDATE jdbc_tx_accounts SET balance=balance-? WHERE id=? AND balance>=?")){
     debit.setBigDecimal(1,new java.math.BigDecimal("100.00"));debit.setInt(2,1);debit.setBigDecimal(3,new java.math.BigDecimal("100.00"));
     if(debit.executeUpdate()!=1)throw new SQLException("Debit rejected (missing account or insufficient balance)");
    }
    try(PreparedStatement credit=c.prepareStatement("UPDATE jdbc_tx_accounts SET balance=balance+? WHERE id=?")){
     credit.setBigDecimal(1,new java.math.BigDecimal("100.00"));credit.setInt(2,2);if(credit.executeUpdate()!=1)throw new SQLException("Credit failed");
    }
    try(Statement q=c.createStatement();ResultSet r=q.executeQuery("SELECT id,balance FROM jdbc_tx_accounts ORDER BY id")){while(r.next())System.out.println("Account "+r.getInt(1)+" balance="+r.getBigDecimal(2));}
   }catch(SQLException e){c.rollback();throw e;}finally{c.rollback();c.setAutoCommit(true);System.out.println("Transaction rolled back; balances restored.");}
  }catch(SQLException e){System.err.println("Transaction demo failed: "+e.getMessage());}
 }
}