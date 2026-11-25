# Hibernate Module 02 — Persistence Context & Entity Lifecycle

This module explores the persistence context: the unit of memory in which Hibernate tracks entity instances and their changes.

## Learning objectives
- Explain the EntityManager and persistence-context roles.
- Distinguish transient, managed, detached, and removed entities.
- Predict how `persist`, `find`, `detach`, `clear`, `remove`, and `merge` affect entity state.
- Understand entity identity within a persistence context.
- Explain why `merge` returns a managed instance instead of reattaching the same object.

## Booking domain
Use the repository's `Booking(id, customerName, amount)` entity mapped to the existing `bookings` table.

## 1. Persistence context
The persistence context is Hibernate's managed set of entity instances for a unit of work. It tracks entity identity and changes. It is not simply a query-result cache: when an entity is already managed, another lookup by the same type and identifier can return the same object instance.

## 2. Entity lifecycle

| State | Meaning |
|---|---|
| Transient | A new Java object not tracked by a persistence context |
| Managed | Associated with a persistence context; Hibernate tracks changes |
| Detached | Was managed, but is no longer tracked by that context |
| Removed | Managed and scheduled for deletion when changes are synchronized |

```java
Booking booking = new Booking("Mina", new BigDecimal("75.00")); // transient
entityManager.persist(booking); // managed
entityManager.detach(booking); // detached
```

## 3. Find and identity

```java
Booking first = entityManager.find(Booking.class, 1L);
Booking second = entityManager.find(Booking.class, 1L);

System.out.println(first == second); // same managed instance in this context
```

The identity guarantee is scoped to a persistence context. It does not imply that Java objects from different transactions or contexts are the same instance.

## 4. Detach, clear, and remove
- `detach(entity)`: stop tracking one entity.
- `clear()`: detach all managed entities from this context.
- `remove(managedEntity)`: mark a managed entity for deletion. SQL may run at flush, not at the method call.

Detached changes are not automatically synchronized by the original persistence context.

## 5. Merge: copy state, don't assume reattachment

```java
Booking managedCopy = entityManager.merge(detachedBooking);
// Continue with managedCopy; detachedBooking remains detached.
```

Merge copies state into a managed instance and returns that instance. It is a common bug to ignore the return value and assume the original object became managed.

## Practical experiment
1. Find booking ID 1 twice in the same transaction and compare references with `==`.
2. Modify the managed object's amount, then inspect SQL at transaction completion.
3. Detach it, change the amount again, and observe that the detached change is not tracked.
4. Merge the detached object and use the returned value.
5. Call `remove` and inspect when DELETE executes.

## Completion checkpoint
You can explain what managed means, why the same identity resolves to one managed object in a persistence context, and the difference between detach and remove.

## Related
- [Module 01 — ORM, setup & entity mapping](../module-01/README.md)
- [Module 03 — Transactions, dirty checking & flush](../module-03/README.md)
