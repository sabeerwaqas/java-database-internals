# Hibernate Module 01 — ORM, Setup & Entity Mapping

This module introduces Hibernate as a Java ORM, sets up a Spring Boot persistence project, and maps Java classes to relational tables. Examples use the shared **bookings** table from this repository's database lab—not copied proprietary code.

## Learning objectives
- Explain the object-relational impedance mismatch and when ORM helps (and when SQL is still preferable).
- Distinguish Jakarta Persistence (JPA) specification, Hibernate provider, and Spring Boot configuration.
- Configure a datasource and inspect Hibernate-generated SQL.
- Map an entity using `@Entity`, `@Id`, `@GeneratedValue`, and `@Column`.
- Understand schema-generation settings and why migrations are generally safer for managed environments.

## Domain used in examples
The lab schema contains `bookings(id, customer_name, amount)`. It is intentionally small so generated SQL can be inspected without distracting domain complexity.

## Topics
1. Object-relational mapping and the impedance mismatch
2. ORM trade-offs: less repetitive mapping code, but SQL and database knowledge remain essential
3. JPA vs Hibernate vs Spring Boot
4. Datasource configuration and Hibernate SQL logging
5. Entity mapping and column metadata
6. CRUD basics: persist, find, update a managed object, remove
7. Schema generation: `none`, `create`, `create-drop`, `update`; risks of automatic schema changes
8. Using migration tools (Flyway/Liquibase) for controlled schema evolution

## Example mapping

```java
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    protected Booking() {}

    public Booking(String customerName, BigDecimal amount) {
        this.customerName = customerName;
        this.amount = amount;
    }
}
```

> Mapping examples are learning alternatives written for this repository. They are not copied from employer or client code.

## Practice
- Map the existing bookings table without asking Hibernate to create or alter it.
- Insert one booking, read it by identifier, update its amount, and delete it.
- Enable SQL and bind-parameter logging locally; observe the statements and parameter values. Avoid exposing sensitive values in production logs.
- Compare a hand-written JDBC insert with Hibernate's generated SQL.

## Related source
- [Shared database schema](../../database/init/V1__create_bookings.sql)
- [JDBC track](../../jdbc/README.md)
- [Hibernate track overview](../README.md)

## Completion checkpoint
You can explain what ORM automates, what it does not automate, why schema migrations matter, and can trace a simple entity operation from Java to SQL.
