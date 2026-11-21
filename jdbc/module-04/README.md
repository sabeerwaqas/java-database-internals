# Module 04 — CRUD Operations

**Goal:** perform create, read, update, and delete operations with parameterized SQL.

The demo uses a transaction and rolls it back so the practice row is not retained. It expects the shared `bookings(id, customer_name, amount)` table.

## Run
```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module04.Main"
```

## Concepts
- Use `PreparedStatement` for values.
- `executeUpdate()` returns affected-row count.
- Verify row counts to detect unexpected changes.
- Group related changes in a transaction.

## Exercises
See [exercise/README.md](./exercise/README.md).