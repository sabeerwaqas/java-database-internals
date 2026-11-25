# Hibernate Module 03 — Transactions, Dirty Checking & Flush

This module explains how changes to managed Java objects become SQL, and why flushing and committing are different events.

## Learning objectives
- Define dirty checking and identify when it applies.
- Explain write-behind behavior.
- Distinguish flush from commit and rollback.
- Understand why service methods often make appropriate transaction boundaries.
- Inspect SQL timing instead of assuming setters immediately execute SQL.

## Booking domain
Examples use the repository's `Booking(id, customerName, amount)` entity and existing `bookings` table.

## 1. Dirty checking
When an entity is managed, Hibernate tracks its state. If a field changes relative to the state Hibernate knows, Hibernate can generate an UPDATE during flush.

```java
@Transactional
public void updateBookingAmount(long id) {
    Booking booking = entityManager.find(Booking.class, id);
    booking.setAmount(new BigDecimal("220.00"));
    // No explicit update call: dirty checking detects the managed change.
}
```

This does not work the same way for detached objects. Changing a detached object's fields is not automatically tracked by the original persistence context.

## 2. Write-behind
Hibernate commonly queues persistence changes in the persistence context and synchronizes them to the database during flush. This is often called transactional write-behind.

A setter changes Java state. It is not a promise that an UPDATE runs on that line.

## 3. Flush versus commit

| Flush | Commit |
|---|---|
| Synchronizes pending changes by executing SQL | Completes the database transaction |
| SQL may run while the transaction remains open | Makes the transaction's changes durable when successful |
| Can still be followed by rollback | Ends a successful transaction |

A successful flush is not proof that the transaction has committed. If the transaction rolls back afterward, flushed SQL changes are rolled back too.

## 4. When Hibernate flushes
With the usual automatic flush mode, Hibernate generally flushes before transaction commit and may flush before queries that need to observe pending changes. Exact timing can depend on flush mode, query type, identifier strategy and provider behavior.

Use explicit flush only when you have a reason—for example, to surface constraint errors before later work or to synchronize before subsequent database operations.

```java
entityManager.flush(); // SQL is synchronized, transaction is not committed here
```

## 5. Transaction boundaries
A business operation may involve several persistence actions. A service-level transaction can group those actions so that they succeed or fail together.

```java
@Transactional
public void reviseBooking(long id, BigDecimal amount) {
    Booking booking = entityManager.find(Booking.class, id);
    booking.setAmount(amount);
    // Other related persistence work can occur here.
}
```

Keep transactions short and avoid doing slow unrelated work while holding one open. The transaction boundary should match the business operation, not be scattered unintentionally across independent repository calls.

## Practical experiment
1. Find a booking in a transaction.
2. Change its amount without calling an update method.
3. Enable SQL logging and identify when UPDATE is emitted.
4. Explicitly flush and inspect SQL timing.
5. Roll back the transaction and verify the change was not retained.
6. Repeat with a detached entity to contrast managed and detached behavior.

## Completion checkpoint
You can explain dirty checking, write-behind, why flush is not commit, and how transaction boundaries control the outcome of a business operation.

## Related
- [Module 01 — ORM, setup & entity mapping](../module-01/README.md)
- [Module 02 — Persistence context & entity lifecycle](../module-02/README.md)
