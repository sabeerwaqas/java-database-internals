# Module 07 — Exception and Resource Management

**Goal:** handle SQL failures and release JDBC resources reliably.

## Concepts
- Database errors are reported through `SQLException`.
- Inspect SQLState and vendor error code for diagnostics; don't parse messages as logic.
- try-with-resources closes resources even when an exception occurs.
- Nested resources close in reverse order.
- Preserve causes when wrapping exceptions; don't silently swallow errors.
- Roll back explicitly when a transaction fails.

## Run
```bash
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module07.Main"
```
The sample intentionally queries a nonexistent table to show diagnostics; it does not modify data.

## Exercises
See [exercise/README.md](./exercise/README.md).