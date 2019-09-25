SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS builts (
 id int PRIMARY KEY auto_increment,
 built_name VARCHAR,
 built_description VARCHAR,
 built_location VARCHAR,
 built_price INTEGER,
 type VARCHAR,
 purpose VARCHAR,
 contact VARCHAR
);