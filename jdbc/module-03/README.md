# Module 03 — ResultSet and Java Type Mapping

**Goal:** read database rows safely and map SQL column types to Java values.

## Concepts
- A ResultSet cursor starts before the first row; call `next()` to advance.
- Read columns by label where practical; labels are more maintainable than numeric positions.
- Use `getLong`, `getString`, and `getBigDecimal` for matching SQL types.
- Primitive getters return defaults for SQL NULL; check `wasNull()` immediately when null matters.
- ResultSets depend on their Statement and Connection. Close nested resources with try-with-resources.

## Run
```bash
docker compose up -d
mvn -pl jdbc -am compile
mvn -pl jdbc exec:java -Dexec.mainClass="com.sabeer.database.jdbc.module03.Main"
```
Read-only query against the existing bookings table.

## Exercises
See [exercise/README.md](./exercise/README.md).