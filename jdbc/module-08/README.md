# Module 08 — DAO and connection pooling

**Goal:** separate persistence code from application logic and understand connection reuse.

## Concepts

- A DAO groups database operations behind an application-focused API.
- Keep SQL and row mapping out of unrelated business logic.
- A connection pool reuses managed physical connections.
- Production applications generally use a configured `DataSource`.
- Close borrowed connections so the pool can return them to circulation.

## Code

Entry point: `jdbc/src/main/java/com/sabeer/database/jdbc/module08/Main.java` (to be added in this module).

## Exercise

See [exercise/README.md](./exercise/README.md).

## Article

Article link will be added when published.
