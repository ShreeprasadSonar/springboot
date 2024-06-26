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

-- use nobs;
-- INSERT INTO customer (first_name, last_name) VALUES ('Jane', 'Smith');

-- INSERT INTO address (street, city, state, customer_id) VALUES
-- ('789 Pine St', 'CityC', 'SC', 1),
-- ('101 Elm St', 'CityD', 'SC', 2);

-- use nobs;
-- ALTER TABLE customer
-- DROP FOREIGN KEY customer_ibfk_1;
-- ALTER TABLE customer
-- DROP COLUMN address_id;


-- use nobs;
-- CREATE TABLE customer_address (
-- customer_id BIGINT,
-- address_id BIGINT,
-- PRIMARY KEY (customer_id, address_id),
-- FOREIGN KEY (customer_id) REFERENCES customer (id),
-- FOREIGN KEY (address_id) REFERENCES address(id)
-- );

-- use nobs;
-- INSERT INTO customer_address (customer_id, address_id)
-- SELECT customer_id, id as address_id
-- FROM address;

-- use nobs;
-- ALTER TABLE address
-- DROP FOREIGN KEY fk_customer;
-- ALTER TABLE address
-- DROP COLUMN customer_id;


-- use nobs;
-- CREATE TABLE `cat_facts`(
-- `id` INT AUTO_INCREMENT PRIMARY KEY,
-- `catFactJSON` JSON NOT NULL
-- );

-- describe cat_facts

-- use nobs;
-- CREATE TABLE orders (
-- id BINARY(16) PRIMARY KEY,
-- total DOUBLE NOT NULL
-- );

-- describe orders;

SELECT BIN_TO_UUID(id) as id, total from orders;
