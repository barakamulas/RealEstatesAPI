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

CREATE TABLE IF NOT EXISTS agents(
id int PRIMARY KEY auto_increment,
agent_name VARCHAR,
contact VARCHAR,
agent_reviews VARCHAR,
);

CREATE TABLE IF NOT EXISTS selling(
    id int PRIMARY KEY auto_increment,
    land_name VARCHAR,
    land_description VARCHAR,
    selling_type VARCHAR,
    land_price INTEGER,
    purpose VARCHAR,
    contact VARCHAR,
    land_location VARCHAR,
    size INTEGER
);