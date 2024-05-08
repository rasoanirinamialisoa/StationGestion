INSERT INTO stock_view (date, quantity_added, quantity_sold, remaining_quantity)
VALUES
    ('2024-05-10 10:00:00', 100.00, 50.00, 50.00),
    ('2024-05-11 11:00:00', 50.00, 20.00, 30.00),
    ('2024-05-12 12:00:00', 200.00, 100.00, 100.00);

INSERT INTO stock_movement (date, type, quantity, id_stock_view)
VALUES
    ('2024-05-10 10:00:00', 'entry', 100.00, 1),
    ('2024-05-11 11:00:00', 'exit', 50.00, 2),
    ('2024-05-12 12:00:00', 'entry', 200.00, 3);

INSERT INTO station (name, address, list_product, id_stock_movement)
VALUES
    ('Station A', 'Galana Analamahitsy Coliseum', 'Gasoline, Diesel', 4),
    ('Station B', 'Galana Analamahitsy Tanàna', 'Gasoline, Propane', 5);



INSERT INTO product_template (name, price, evaporation_rate_per_day, id_stock_view, id_stock_movement)
VALUES
    ('Gasoline', 2.50, 0.1, 1, 4),
    ('Diesel', 2.00, 0.05, 2, 6),
    ('Propane', 3.00, 0.2, 3, 5);

INSERT INTO product (id_station, id_product_template)
VALUES
    (5, 7),
    (6, 8),
    (5, 9);

