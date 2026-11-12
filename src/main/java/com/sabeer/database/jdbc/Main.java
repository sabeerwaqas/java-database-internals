package com.sabeer.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        String url = requiredEnv("DB_URL");
        String username = requiredEnv("DB_USERNAME");
        String password = requiredEnv("DB_PASSWORD");

        try (Connection connection =
                     DriverManager.getConnection(url, username, password)) {

            System.out.println("Connected to MariaDB successfully.");
            System.out.println("Connection valid: " + connection.isValid(2));

        } catch (SQLException exception) {
            System.err.println("Could not connect to the database.");
            exception.printStackTrace();
        }
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing environment variable: " + name
            );
        }

        return value;
    }
}
