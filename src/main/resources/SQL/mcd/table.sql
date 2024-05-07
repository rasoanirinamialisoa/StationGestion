CREATE TABLE stock_mouvement (
                                 id SERIAL PRIMARY KEY,
                                 date TIMESTAMP,
                                 type VARCHAR(10),
                                 quantity NUMERIC,
                                 id_stock_view INT REFERENCES stock_view(id)
);

CREATE TABLE station (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(50),
                         address VARCHAR(50),
                         list_product VARCHAR(50),
                         id_stock_mouvement INT REFERENCES stock_mouvement(id)
);

CREATE TABLE stock_view (
                            id SERIAL PRIMARY KEY,
                            date TIMESTAMP,
                            quantity_added NUMERIC,
                            quantity_sold NUMERIC,
                            remaining_quantity NUMERIC
);

CREATE TABLE product_template (
                                  id SERIAL PRIMARY KEY,
                                  name VARCHAR(50),
                                  price DOUBLE PRECISION,
                                  evaporation_rate_per_day NUMERIC,
                                  id_stock_view INT REFERENCES stock_view(id),
                                  id_stock_mouvement INT REFERENCES stock_mouvement(id)
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         id_station INT REFERENCES station(id),
                         id_product_template INT REFERENCES product_template(id)
);
