# Module 05 — Transactions

**Goal:** understand atomicity, commit, rollback, and JDBC auto-commit.

The demo creates a dedicated `jdbc_tx_accounts` table if absent, initializes two lab accounts, performs a transfer-like update inside a transaction, and rolls it back. This is isolated from bookings.

## Run
```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module05.Main"
```

## Concepts
- Auto-commit normally commits each statement independently.
- Disable auto-commit to group statements.
- Commit persists the unit; rollback discards it.
- Transactions should preserve invariants (for example, transfer balances).
- Roll back on failures.

## Exercises
See [exercise/README.md](./exercise/README.md).