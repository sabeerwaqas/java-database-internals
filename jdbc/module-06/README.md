# Module 06 — Batch Processing and Generated Keys

**Goal:** execute repeated inserts efficiently and retrieve generated keys.

The sample uses an isolated `jdbc_batch_demo` table, batches inserts, prints generated keys, then rolls back the rows.

## Run
```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module06.Main"
```

## Concepts
- Batch execution can reduce repeated client/server overhead; driver behavior varies.
- `addBatch()` queues parameter sets; `executeBatch()` returns update counts.
- Generated-key support for batches varies. Inspect actual driver behavior.
- Rollback keeps the demonstration repeatable.

## Exercises
See [exercise/README.md](./exercise/README.md).