# Java Database Internals

A practical, code-first path through SQL, JDBC, ORM, Hibernate, and Spring Data JPA.

The goal is to understand what happens between Java code and the database—not just memorize annotations or repository methods.

## Learning path

1. **JDBC** — connections, statements, result sets, transactions, batching, and resource management.
2. **ORM fundamentals** — object-relational mapping, persistence context, and entity lifecycle.
3. **Hibernate** — dirty checking, flushing, relationships, ownership, fetching, caching, and query behavior.
4. **Spring Data JPA** — repository abstractions, transaction boundaries, generated SQL, and performance.

Each topic will include a small runnable example and notes explaining the behavior.

## Requirements

- Java 17+
- Maven 3.9+
- Docker Engine and Docker Compose

## Start MariaDB

Copy the example environment file:

```bash
cp .env.example .env
```

On Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

Review the credentials in `.env`, then start the database:

```bash
docker compose up -d
docker compose ps
```

MariaDB is exposed on `localhost:3306`. The initialization script creates the `bookings` table and inserts sample rows when the database volume is first initialized.

> The initialization script runs only when MariaDB creates a fresh data directory. If you change that script after the first startup, use `docker compose down -v` to remove the lab database volume and initialize it again. This deletes the container's database data.

## Run the JDBC example

Set the connection variables in the terminal where you run Maven.

**macOS / Linux**

```bash
export DB_URL="jdbc:mariadb://localhost:3306/java_database_lab"
export DB_USERNAME="lab_user"
export DB_PASSWORD="lab_password"
mvn compile exec:java
```

**Windows PowerShell**

```powershell
$env:DB_URL = "jdbc:mariadb://localhost:3306/java_database_lab"
$env:DB_USERNAME = "lab_user"
$env:DB_PASSWORD = "lab_password"
mvn compile exec:java
```

The credentials above are for this local learning environment only. Do not reuse them in a deployed application.

## Stop the database

```bash
docker compose down
```

To also delete the persisted lab data:

```bash
docker compose down -v
```

## Project structure

```text
.
├── database/
│   └── init/
│       └──  V1__create_bookings.sql
├── src/
│   └── main/
│       └── java/com/sabeer/database/jdbc/
│           └── Main.java
├── .env.example
├── .gitignore
├── compose.yaml
└── pom.xml
```

The repository will grow as we work through each topic. We will add abstractions only when an example needs them.
