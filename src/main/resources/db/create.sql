SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS builts (
 id int PRIMARY KEY auto_increment,
 built_name VARCHAR,
 built_description VARCHAR,
 built_location VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);