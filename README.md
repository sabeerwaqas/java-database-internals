# Java Database Internals

A practical, code-first learning lab for understanding how Java applications interact with relational databases.

This repository focuses on **small runnable examples**, concise notes, and exercises—not long, duplicated tutorials. The accompanying articles explain the concepts; this repository contains the code you can run and inspect.

## Learning tracks

| Track | What you'll explore | Status |
|---|---|---|
| [JDBC](./jdbc/README.md) | Connections, SQL execution, result mapping, CRUD, transactions, batching, and application structure | In progress |
| [SQL & Databases](./sql/README.md) | SQL queries, joins, constraints, relationships, and schema design | In progress |
| [ORM Fundamentals](./orm/README.md) | Object-relational mapping, persistence context, and entity lifecycle | Planned |
| [Hibernate](./hibernate/README.md) | Entity mapping, relationships, fetching, dirty checking, and generated SQL | Planned |

## How to use this repository

1. Choose a learning track.
2. Read its short module notes.
3. Run the example locally.
4. Inspect the SQL and output.
5. Complete the small exercise before moving on.

Examples build around a shared booking domain so we can compare direct JDBC code with ORM-based persistence later.

## Requirements

- Java 17+
- Maven 3.9+
- Docker Engine and Docker Compose

## Start the database

Copy the example environment file:

```bash
cp .env.example .env
```

On Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

Review the local credentials in `.env`, then start MariaDB:

```bash
docker compose up -d
docker compose ps
```

MariaDB is exposed on `localhost:4000` (host port 4000 mapped to container port 3306). This avoids conflicting with a local MySQL/MariaDB instance using the default host port.

The initialization script creates the sample `bookings` table and inserts sample rows when the database volume is first initialized.

> The initialization script runs only when MariaDB creates a fresh data directory. Changing it after first startup does not rerun it. Avoid `docker compose down -v` unless you intentionally want to delete the persisted lab database.

## Run a JDBC module

Start MariaDB and run an individual module by specifying its main class.

**Module 1 — Connection and architecture**

```bash
mvn compile exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module01.ConnectionDemo"
```

The database configuration is loaded from the root `.env` file. Environment variables override values from `.env`. The default host and port are `localhost:4000`; you can override them with `DB_HOST` and `DB_PORT`.

## Stop the database

```bash
docker compose down
```

This stops the container but preserves the named database volume.

To also delete the persisted lab data (destructive):

```bash
docker compose down -v
```

## Repository principles

- **Runnable over theoretical:** important concepts should have executable examples.
- **Show the database behavior:** inspect SQL, returned rows, and transaction effects.
- **One concept at a time:** keep examples small and focused.
- **Avoid premature abstraction:** introduce patterns such as DAO when they solve a problem we have encountered.
- **Keep the domain consistent:** reuse the booking schema where it makes comparisons easier.
- **No duplicated tutorials:** detailed explanations belong in the articles; the repository stays a practical companion.

## Articles

Articles will be linked from their corresponding track or module pages as they are published.
