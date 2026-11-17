# JDBC

Learn how Java communicates with a relational database using the JDBC API.

This is an independent Maven project inside the repository. It owns its dependencies, Java source tree, and runnable module entry points. It uses the shared MariaDB container and root `.env` configuration.

## Modules

1. [Module 01 — Connection and architecture](./module-01/README.md)
2. [Module 02 — Statement and PreparedStatement](./module-02/README.md)
3. [Module 03 — ResultSet and Java type mapping](./module-03/README.md)
4. [Module 04 — CRUD operations](./module-04/README.md)
5. [Module 05 — Transactions](./module-05/README.md)
6. [Module 06 — Batch processing and generated keys](./module-06/README.md)
7. [Module 07 — Exception and resource management](./module-07/README.md)
8. [Module 08 — DAO and connection pooling](./module-08/README.md)

Every module keeps its lesson notes and exercises together:

```text
module-01/
├── README.md
└── exercise/
    └── README.md
```

Runnable Java code lives in the JDBC project's source tree, grouped by module:

```text
src/main/java/com/sabeer/database/jdbc/
├── module01/
│   └── Main.java
├── module02/
│   └── Main.java
└── ...
```

Only modules currently being studied need a runnable entry point. We will add each module's `Main.java` when we reach it, rather than creating empty placeholder classes.

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
