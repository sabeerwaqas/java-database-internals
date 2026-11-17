package com.sabeer.database.config;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Loads the shared database connection settings for the learning modules.
 */
public final class DatabaseConfig {

    private static final Dotenv DOTENV = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private static final String DATABASE = requiredValue("MARIADB_DATABASE");
    private static final String USERNAME = requiredValue("MARIADB_USER");
    private static final String PASSWORD = requiredValue("MARIADB_PASSWORD");

    private static final String HOST = valueOrDefault("DB_HOST", "localhost");
    private static final String PORT = valueOrDefault("DB_PORT", "4000");

    private DatabaseConfig() {
    }

    public static String getUrl() {
        return "jdbc:mariadb://" + HOST + ":" + PORT + "/" + DATABASE;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    private static String requiredValue(String key) {
        String value = valueOrDefault(key, null);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing configuration: " + key
                    + ". Add it to your .env file or environment.");
        }

        return value;
    }

    private static String valueOrDefault(String key, String defaultValue) {
        String environmentValue = System.getenv(key);

        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue;
        }

        String dotenvValue = DOTENV.get(key);
        return dotenvValue == null || dotenvValue.isBlank()
                ? defaultValue
                : dotenvValue;
    }
}
