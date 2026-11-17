# JDBC

Learn how Java communicates with a relational database using the JDBC API.

This is an independent Maven project inside the repository. It owns its dependencies and runnable module examples, and uses the shared MariaDB container and root `.env` configuration.

## Modules

1. [Module 01 — Connection and architecture](./module-01/README.md)
2. [Module 02 — Statement and PreparedStatement](./module-02/README.md)
3. [Module 03 — ResultSet and Java type mapping](./module-03/README.md)
4. [Module 04 — CRUD operations](./module-04/README.md)
5. [Module 05 — Transactions](./module-05/README.md)
6. [Module 06 — Batch processing and generated keys](./module-06/README.md)
7. [Module 07 — Exception and resource management](./module-07/README.md)
8. [Module 08 — DAO and connection pooling](./module-08/README.md)

## Module layout

Each module keeps its explanation, runnable Java entry point, and exercises together:

```text
jdbc/
├── DatabaseConfig.java
├── module-01/
│   ├── Main.java
│   ├── README.md
│   └── exercise/
│       └── README.md
├── module-02/
│   └── ... (added as we study it)
└── pom.xml
```

The JDBC project directory is registered as a Maven source root. This keeps each module's runnable code beside its lesson without a separate nested Java source tree. Java classes still declare unique packages, so module entry points do not conflict.

`DatabaseConfig.java` contains settings shared by the JDBC modules. It lives directly in the project root to avoid another directory hierarchy.

We add a module's `Main.java` when we reach it; there are no empty placeholder classes.

## Setup

Follow the [root setup instructions](../README.md) and start MariaDB:

```bash
docker compose up -d
```

## Build the JDBC project

From the repository root:

```bash
mvn -pl jdbc -am clean compile
```

## Run Module 01

```bash
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module01.Main"
```

## Scope

This track focuses on core JDBC. SQL fundamentals, ORM concepts, and Hibernate are maintained as separate learning tracks.
