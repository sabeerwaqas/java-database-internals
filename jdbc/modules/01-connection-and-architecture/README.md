# 01 — JDBC connection and architecture

**Goal:** understand how a Java program obtains a database connection and which JDBC components are involved.

## Key ideas

- JDBC is the standard Java API for database access.
- The database vendor supplies the JDBC driver implementation.
- `DriverManager.getConnection(...)` asks a suitable registered driver to establish a connection.
- `Connection` and `DatabaseMetaData` are JDBC interfaces.
- Try-with-resources closes the connection when the block exits.

## Run

Start MariaDB using the [project setup](../../../README.md), then run this module from the repository root:

```bash
mvn compile exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module01.ConnectionDemo"
```

Runnable example:

`src/main/java/com/sabeer/database/jdbc/module01/ConnectionDemo.java`

Shared connection settings:

`src/main/java/com/sabeer/database/config/DatabaseConfig.java`

## Inspect

The example prints:

- `connection.getMetaData().getDatabaseProductName()`
- `connection.getMetaData().getDatabaseProductVersion()`
- `connection.getMetaData().getDriverName()`
- `connection.getMetaData().getDriverVersion()`
- `connection.isValid(2)`

The concrete connection implementation is supplied by MariaDB Connector/J. Application code should depend on the JDBC `Connection` interface rather than instantiate the vendor implementation directly.

## Exercise

1. Identify the JDBC URL's protocol, host, port, and database name.
2. Find the JDBC driver dependency in `pom.xml`.
3. Explain why the variable is declared as `Connection` rather than the driver's concrete class.
4. Explain which part is JDBC API and which part is MariaDB-specific.

## Article

Article link will be added when published.
