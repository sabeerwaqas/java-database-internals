package com.sabeer.database.jdbc.module02;

import com.sabeer.database.jdbc.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Module 02: executing SQL with Statement and PreparedStatement.
 */
public class Main {

    private static final String ALL_BOOKINGS_SQL = """
            SELECT id, customer_name, amount
            FROM bookings
            ORDER BY id
            """;

    private static final String BOOKING_BY_ID_SQL = """
            SELECT id, customer_name, amount
            FROM bookings
            WHERE id = ?
            """;

    public static void main(String[] args) {
        long bookingId = parseBookingId(args);

        try (Connection connection = DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUsername(),
                DatabaseConfig.getPassword())) {

            printAllBookings(connection);
            System.out.println();
            printBookingById(connection, bookingId);

        } catch (SQLException exception) {
            System.err.println("Unable to execute the JDBC queries.");
            System.err.println("Reason: " + exception.getMessage());
            System.exit(1);
        }
    }

    /**
     * Demonstrates Statement with fixed SQL that contains no user input.
     */
    private static void printAllBookings(Connection connection) throws SQLException {
        System.out.println("All bookings (Statement):");

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(ALL_BOOKINGS_SQL)) {

            while (resultSet.next()) {
                System.out.printf(
                        "ID: %d | Customer: %s | Amount: %s%n",
                        resultSet.getLong("id"),
                        resultSet.getString("customer_name"),
                        resultSet.getBigDecimal("amount"));
            }
        }
    }

    /**
     * Demonstrates PreparedStatement with a bound parameter.
     */
    private static void printBookingById(Connection connection, long bookingId)
            throws SQLException {
        System.out.println("Booking lookup (PreparedStatement):");

        try (PreparedStatement statement = connection.prepareStatement(BOOKING_BY_ID_SQL)) {
            statement.setLong(1, bookingId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.printf(
                            "ID: %d | Customer: %s | Amount: %s%n",
                            resultSet.getLong("id"),
                            resultSet.getString("customer_name"),
                            resultSet.getBigDecimal("amount"));
                } else {
                    System.out.println("No booking found for ID: " + bookingId);
                }
            }
        }
    }

    private static long parseBookingId(String[] args) {
        if (args.length == 0) {
            return 1L;
        }

        try {
            long bookingId = Long.parseLong(args[0]);
            if (bookingId <= 0) {
                throw new IllegalArgumentException("Booking ID must be positive.");
            }
            return bookingId;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Provide a valid numeric booking ID.", exception);
        }
    }
}
