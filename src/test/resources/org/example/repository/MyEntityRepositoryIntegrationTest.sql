CREATE TABLE my_entity(
    id BIGSERIAL PRIMARY KEY,
    status TEXT
);

CREATE TABLE my_nested_entity(
    ID SERIAL PRIMARY KEY,
    NAME TEXT,
    my_entity_id INT REFERENCES my_entity
);