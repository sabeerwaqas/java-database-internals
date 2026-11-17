# Module 01 — Exercises

Complete these after running the module's [connection demo](../README.md).

## Exercise 1 — Break down the JDBC URL

Given:

```text
jdbc:mariadb://localhost:4000/java_database_lab
```

Identify:

1. JDBC subprotocol
2. Database type
3. Host
4. Host port
5. Database name

## Exercise 2 — API or driver?

Classify each item as part of the JDBC API or MariaDB Connector/J:

- `DriverManager`
- `Connection`
- `DatabaseMetaData`
- `org.mariadb.jdbc.Connection`

## Exercise 3 — Interface abstraction

Why does application code declare the variable as `Connection` instead of `org.mariadb.jdbc.Connection`?

Explain what would become harder if application code depended directly on the vendor implementation.

## Exercise 4 — Inspect the dependency

Open `jdbc/pom.xml` and identify:

- Maven group ID
- Artifact ID
- Version

Explain why the JDBC API types can be imported from `java.sql` without adding a separate JDBC API dependency.

## Practical change

Temporarily print:

```java
System.out.println(connection.getClass().getName());
```

Run the program, record the concrete class name, then remove the temporary line.

Do not print database passwords or other secrets.
