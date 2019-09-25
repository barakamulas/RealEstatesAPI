USE MODE PostgreSQL;

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