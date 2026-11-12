USE java_database_lab;

CREATE TABLE bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL
);

INSERT INTO bookings (customer_name, amount)
VALUES
    ('Ali', 1500.00),
    ('Sara', 2500.00),
    ('Ahmed', 1800.00);
