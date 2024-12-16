-- Create a table named 'tasks' to store task-related information
CREATE TABLE tasks (
    -- 'ID' is the primary key of the table, generated automatically as a unique, incremental value
                       ID SERIAL PRIMARY KEY,

    -- 'Title' stores the title of the task; it is a variable-length string up to 255 characters
    -- The 'NOT NULL' constraint ensures this field cannot be left empty
                       Title VARCHAR(255) NOT NULL,

    -- 'Description' stores a more detailed description of the task
    -- It is a variable-length string with a maximum of 500 characters
                       Description VARCHAR(500),

    -- 'Status' represents the current state of the task (e.g., 0 for pending, 1 for completed)
    -- It is an integer field and cannot be null due to the 'NOT NULL' constraint
                       Status INT NOT NULL
);