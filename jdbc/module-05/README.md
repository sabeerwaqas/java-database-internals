# Module 05 — Transactions

**Goal:** group multiple database operations into one atomic unit of work.

## Concepts

- JDBC connections use auto-commit by default.
- Use `setAutoCommit(false)` to begin an explicit transaction.
- Use `commit()` to persist the unit of work or `rollback()` to undo it.
- Keep transactions focused and short.

## Code

Entry point: `jdbc/src/main/java/com/sabeer/database/jdbc/module05/Main.java` (to be added in this module).

## Exercise

See [exercise/README.md](./exercise/README.md).

## Article

Article link will be added when published.
