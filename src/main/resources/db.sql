CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    venue VARCHAR(100) NOT NULL,
    total_tickets INTEGER NOT NULL,
    available_tickets INTEGER NOT NULL
);

CREATE TABLE tickets (
     id SERIAL PRIMARY KEY,
     sector VARCHAR(50) NOT NULL,
     row_number VARCHAR(10) NOT NULL,
     seat_number VARCHAR(10) NOT NULL,
     price NUMERIC(12, 2) NOT NULL,
     date_time TIMESTAMP NOT NULL,
     event_id INTEGER NOT NULL,
     CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    booking_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE order_ticket (
    order_id INTEGER NOT NULL,
    ticket_id INTEGER NOT NULL,
    PRIMARY KEY (order_id, ticket_id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    CONSTRAINT fk_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id) ON DELETE CASCADE
);
