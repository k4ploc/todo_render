CREATE TABLE todos
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    quantity VARCHAR(50),
    priority VARCHAR(50),
    status   VARCHAR(50),
    date     TIMESTAMP
);
