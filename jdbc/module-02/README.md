# Module 02 — Statement and PreparedStatement

**Goal:** execute SQL through JDBC and understand how parameter values are bound safely.

## Concepts

- `Statement` executes a SQL string. Use it for fixed SQL that does not incorporate untrusted input.
- `PreparedStatement` is created from SQL containing `?` parameter markers.
- Bind values with typed setter methods such as `setLong`, `setString`, and `setBigDecimal`. Parameter indexes start at 1.
- Bound values are treated as data, not SQL syntax. Do not concatenate user-provided values into SQL.
- `executeQuery()` is for statements that return a `ResultSet`, typically `SELECT`.
- `executeUpdate()` is for DML such as `INSERT`, `UPDATE`, and `DELETE`; it returns the affected-row count.
- `execute()` is the general-purpose method when the SQL may produce a result set or an update count.

## Run

From the repository root, start MariaDB and run Module 02:

```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module02.Main"
```

The optional first program argument is the booking ID to look up. For example:

```bash
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module02.Main" -Dexec.args="2"
```

The demo uses the existing `bookings` table. It first lists bookings with a fixed `Statement` query, then looks up one booking using a parameterized `PreparedStatement`. It does not insert, update, or delete data.

## Files

- `Main.java` — runnable examples of `Statement` and `PreparedStatement`.
- `exercise/README.md` — practical exercises.

## Important boundary

Prepared statements protect **values** supplied through placeholders. They do not parameterize SQL identifiers such as table or column names. If a query must vary an identifier, select it from a strict allowlist and never append arbitrary user input.

A prepared statement also does not imply that every JDBC driver must use server-side precompilation in every configuration. The key security benefit is separating SQL structure from bound parameter values.

## Article

Article link will be added when published.
