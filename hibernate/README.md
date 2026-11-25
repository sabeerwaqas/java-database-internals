# Hibernate — Practical ORM Learning Track

A practical track for learning Hibernate ORM with Jakarta Persistence (JPA), Spring Boot configuration, and SQL inspection. Examples are original learning alternatives and use the repository's shared booking table where appropriate. No employer/client source code is included.

## Modules
1. [ORM, setup & entity mapping](./module-01/README.md) — ORM trade-offs, JPA/Hibernate/Spring roles, configuration, entity mapping and CRUD.
2. [Persistence context & entity lifecycle](./module-02/README.md) — EntityManager, managed state, identity map, transient/managed/detached/removed and merge.
3. [Transactions, dirty checking & flush](./module-03/README.md) — transaction boundaries, dirty checking, write-behind, flush vs commit.

## Shared lab domain
The lab schema is `bookings(id, customer_name, amount)`. It keeps examples intentionally small and makes generated SQL easier to inspect. The shared MariaDB container and root environment configuration are described in the [root README](../README.md).

## Learning principles
- Pair ORM behavior with the SQL it affects.
- Inspect generated SQL; Hibernate does not replace SQL knowledge.
- Use original examples and local test data.
- Avoid destructive schema-generation settings against valuable databases; use migrations for schema evolution.
- Treat this as a learning track, not a claim of production implementation or employer-owned work.

## Prerequisites
- Java and basic OOP
- SQL and relational modeling
- JDBC fundamentals
- Spring Boot basics and dependency injection

## Status
The first three conceptual modules are documented. Runnable Hibernate code is added incrementally and must be verified against the build before being described as implemented.
