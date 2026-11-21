# Module 08 — DAO and Connection Pooling

**Goal:** separate persistence code from application logic and understand why applications use DataSource and connection pools.

## Concepts
- DAO separates persistence operations from callers.
- Keep SQL and row mapping in the DAO; orchestration outside it.
- `DataSource` is the preferred connection-factory abstraction.
- Connection pools reuse physical connections, reducing connection setup overhead. Pool lifecycle and sizing are operational decisions.
- This runnable sample demonstrates DAO separation using `BookingDao`. It uses `DriverManager` to keep the project dependency-free; **it is not a connection pool**. Pooling is explained rather than falsely implemented.

## Run
```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module08.Main"
```

## Exercises
See [exercise/README.md](./exercise/README.md).