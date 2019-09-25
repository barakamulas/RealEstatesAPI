SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS agents(
id int PRIMARY KEY auto_increment,
agent_name VARCHAR,
contact VARCHAR,
agent_reviews VARCHAR,
);