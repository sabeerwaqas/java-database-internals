# Module 08 Exercises

1. Add a DAO method `findById(long id)` that returns an `Optional<Booking>` and uses a `PreparedStatement`.
2. Keep SQL and row mapping inside the DAO; do not print from the DAO.
3. Create a `Booking` record/model and map a row into it.
4. Explain what `DataSource` abstracts and why it is preferred over scattered `DriverManager` calls.
5. Explain pool settings (maximum size, connection timeout, idle timeout) and why oversized pools can overload a database.
6. Optional extension: integrate HikariCP only after reviewing dependency scope and configuration. Do not label `DriverManager` as pooled.