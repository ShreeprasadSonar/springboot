-- CREATE database nobs;

-- use nobs;
-- CREATE TABLE product (
-- 	id INT AUTO_INCREMENT PRIMARY KEY,
-- 	name VARCHAR (255) ,
-- 	description VARCHAR (255) ,
-- 	price DOUBLE,
-- 	quantity INT
-- );

-- use nobs;
-- INSERT INTO product (name, description, price, quantity)
-- VALUES
-- 	('Playstation 5', 'Gaming Console from Sony', 499.99, 1000),
-- 	('X Box Series X', 'Gaming Console from XBox', 499.99, 900);

-- use nobs;
-- SELECT * FROM Product p where p.price < 400; 
-- SELECT p.name, p.description, p.price FROM Product p;

-- CREATE TABLE address (
--     id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     street VARCHAR(255),
--     city VARCHAR(255),
--     state VARCHAR(255)
-- );

-- CREATE TABLE customer (
--     id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     address_id BIGINT,
--     FOREIGN KEY (address_id) REFERENCES address(id)
-- );

-- use nobs;
-- INSERT INTO address (street, city, state) VALUES ('123 Main St', 'Cityville', 'CA'); 
-- INSERT INTO customer (first_name, last_name, address_id) VALUES ('John', 'Doe', 1);

-- use nobs;
-- ALTER TABLE address
-- ADD COLUMN customer_id BIGINT,
-- ADD CONSTRAINT fk_customer
-- FOREIGN KEY (customer_id)
-- REFERENCES customer (id);

-- use nobs;
-- UPDATE address
-- SET customer_id = (SELECT id FROM customer WHERE id = address.id);

use nobs;
INSERT INTO customer (first_name, last_name) VALUES ('Jane', 'Smith');

INSERT INTO address (street, city, state, customer_id) VALUES
('789 Pine St', 'CityC', 'SC', 1),
('101 Elm St', 'CityD', 'SC', 2);

