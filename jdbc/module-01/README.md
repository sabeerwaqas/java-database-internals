# Module 01 — JDBC connection and architecture

**Goal:** establish a JDBC connection and identify the components involved.

## Concepts

- JDBC is the standard Java API for database access.
- MariaDB Connector/J is the vendor-provided JDBC driver.
- `DriverManager` selects a registered driver that understands the JDBC URL.
- `Connection` is a JDBC interface; the driver supplies its implementation.
- `DatabaseMetaData` exposes information about the database and driver.
- Try-with-resources closes the connection when the block exits.

## Run

From the repository root, start the database and run this module:

```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module01.Main"
```

## Files in this module

- `Main.java` — runnable Module 01 example, kept beside this README.
- `exercise/README.md` — practical exercises for this module.

Shared JDBC configuration is kept at the project root:

- `jdbc/DatabaseConfig.java`

Dependencies and Maven source registration are in `jdbc/pom.xml`.

## Expected observations

The program prints the database product and version, JDBC driver and version, and whether the connection is valid. Exact server and driver versions depend on the local environment.

## Exercise

See [exercise/README.md](./exercise/README.md).

## Article

Article link will be added when published.
