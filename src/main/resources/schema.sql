CREATE TABLE tasks (
                       ID SERIAL PRIMARY KEY,
                       Title VARCHAR(255) NOT NULL,
                       Description VARCHAR(500),
                       Status INT NOT NULL
);