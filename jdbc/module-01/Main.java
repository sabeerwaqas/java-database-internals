package com.sabeer.database.jdbc.module01;

import com.sabeer.database.jdbc.DatabaseConfig;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Module 01: JDBC connection and architecture.
 */
public class Main {

    public static void main(String[] args) {
        String url = DatabaseConfig.getUrl();
        String username = DatabaseConfig.getUsername();
        String password = DatabaseConfig.getPassword();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metadata = connection.getMetaData();

            System.out.println("Connected successfully.");
            System.out.println("Database: " + metadata.getDatabaseProductName());
            System.out.println("Database version: " + metadata.getDatabaseProductVersion());
            System.out.println("JDBC Driver: " + metadata.getDriverName());
            System.out.println("Driver version: " + metadata.getDriverVersion());
            System.out.println("Connection valid: " + connection.isValid(2));

        } catch (SQLException exception) {
            System.err.println("Unable to establish the JDBC connection.");
            System.err.println("Reason: " + exception.getMessage());
            System.exit(1);
        }
    }
}
