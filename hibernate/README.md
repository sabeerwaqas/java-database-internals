# Hibernate — Practical ORM Learning Track

A practical track for learning Hibernate ORM with Spring Boot, Jakarta Persistence (JPA), and SQL inspection. Examples are original learning alternatives and use the repository's shared booking database where appropriate. No employer/client source code is included.

## Modules

1. [Module 01 — ORM, setup & entity mapping](./module-01/README.md) — ORM trade-offs, JPA/Hibernate/Spring roles, configuration, entity mapping, CRUD, schema management.
2. [Module 02 — Persistence context & entity lifecycle](./module-02/README.md) — EntityManager, managed state, identity map, transient/managed/detached/removed, merge.
3. [Module 03 — Transactions, dirty checking & flush](./module-03/README.md) — transaction boundaries, @Transactional, write-behind, flush vs commit.

## Shared lab domain

The existing lab schema includes `bookings(id, customer_name, amount)`. This small domain is used to illustrate mappings and persistence behavior. The shared MariaDB container and root environment configuration are described in the repository's [root README](../README.md).

## Learning approach

- Pair every ORM concept with the SQL/database behavior it affects.
- Inspect generated SQL; Hibernate does not eliminate the need to understand SQL.
- Use original examples and safe local data.
- Avoid destructive schema-generation settings against valuable databases. Prefer migration scripts for schema evolution.
- Modules are learning notes and exercises, not claims of production implementation or employer-owned work.

## Prerequisites

- Java and basic OOP
- SQL and relational modeling
- JDBC fundamentals
- Spring Boot basics and dependency injection

## Status

The initial learning modules are documented. Runnable Hibernate examples will be added incrementally and should be verified against the project build before being described as implemented.
