# Java Database Internals

A practical, code-first learning repository for understanding relational databases and how Java applications interact with them.

Each learning track is kept separate. Java-based tracks have their own Maven project and dependencies. SQL stays focused on SQL scripts and exercises; it does not need an artificial Java `Main` class.

## Learning tracks

| Track | Focus | Project |
|---|---|---|
| [JDBC](./jdbc/README.md) | Direct database access using the JDBC API | [jdbc/](./jdbc/) |
| [SQL & Databases](./sql/README.md) | SQL, joins, constraints, relationships, and schema design | [sql/](./sql/) |
| [ORM Fundamentals](./orm/README.md) | ORM concepts and persistence behavior | Planned |
| [Hibernate](./hibernate/README.md) | Hibernate mappings, fetching, and generated SQL | Planned |

## Repository layout

```text
java-database-internals/
├── pom.xml
├── compose.yaml
├── .env.example
├── jdbc/
│   ├── pom.xml
│   ├── DatabaseConfig.java
│   ├── module-01/
│   │   ├── Main.java
│   │   ├── README.md
│   │   └── exercise/
│   │       └── README.md
│   ├── module-02/
│   │   └── ... (added as we study each module)
│   └── ...
├── sql/
├── orm/
└── hibernate/
```

## Requirements

- Java 17+
- Maven 3.9+
- Docker Engine and Docker Compose

## Start the shared database

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

MariaDB is exposed on `localhost:4000` (host port 4000 mapped to container port 3306). This avoids conflicts with a local MySQL/MariaDB instance using the default host port.

The initialization scripts run when MariaDB first initializes its data directory. Changing an initialization script later does not automatically rerun it. Avoid `docker compose down -v` unless you intentionally want to delete the persisted lab database.

## Build the repository

From the root:

```bash
mvn clean compile
```

The root Maven project is an aggregator. It builds the learning-track projects listed in its `<modules>` section.

## Run a module

Each Java learning track owns its own Maven project and entry points. For JDBC Module 01:

```bash
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module01.Main"
```

The JDBC project reads the root `.env` file. Environment variables override values from `.env`. The default database host and port are `localhost:4000`; override them with `DB_HOST` and `DB_PORT` if needed.

See the [JDBC track README](./jdbc/README.md) for module-specific commands.

## Stop the database

```bash
docker compose down
```

This stops the container but preserves the named database volume.

To also delete the persisted lab data (destructive):

```bash
docker compose down -v
```

## Principles

- Keep each learning track independently buildable.
- Keep each module's explanation, runnable example, and exercises together.
- Keep runnable examples small and focused.
- Inspect actual SQL and database effects rather than relying only on output.
- Avoid premature abstractions; introduce patterns when they solve a demonstrated problem.
- Keep the booking domain consistent where it helps compare JDBC and ORM behavior.
- Put long-form conceptual explanations in companion articles; keep this repository practical.
