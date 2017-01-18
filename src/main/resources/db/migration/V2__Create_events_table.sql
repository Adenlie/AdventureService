CREATE TABLE events (
    event_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    duration INTEGER,
    cost NUMERIC
);
