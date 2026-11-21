package com.sabeer.database.jdbc.module08;

import com.sabeer.database.jdbc.DatabaseConfig;
import java.sql.*;

class BookingDao {
    public void printBookings() throws SQLException {
        String sql = "SELECT id, customer_name, amount FROM bookings ORDER BY id";
        try (Connection connection = DriverManager.getConnection(
                    DatabaseConfig.getUrl(), DatabaseConfig.getUsername(), DatabaseConfig.getPassword());
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.printf("%d | %s | %s%n",
                        resultSet.getLong("id"),
                        resultSet.getString("customer_name"),
                        resultSet.getBigDecimal("amount"));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookingDao dao = new BookingDao();
        try {
            dao.printBookings();
        } catch (SQLException exception) {
            System.err.println("DAO read failed: " + exception.getMessage());
            System.err.println("SQLState: " + exception.getSQLState());
        }
    }
}