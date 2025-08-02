CREATE DATABASE mvc
USE mvc
CREATE TABLE category (
	cat_id varchar(10) primary key,
	cat_name nvarchar(50),
	cat_description nvarchar(1000)
)
CREATE  TABLE Product (
	pro_id varchar(10) primary key,
	pro_name varchar(50),
	pro_price bigint ,
	pro_quantity int ,
	pro_description varchar(500),
	cat_id varchar(10) FOREIGN KEY REFERENCES category(cat_id)
)
INSERT INTO category (cat_id, cat_name, cat_description)
VALUES
    ('1', 'Apple', ''),
    ('2', 'Samsung', ''),
    ('3', 'Xiaomi', '');

INSERT INTO product (pro_id, pro_name, pro_price, pro_quantity, pro_description, cat_id)
VALUES
    ('1', 'IPhone 15', 22000000, 20, 'New', '1'),
    ('2', 'IPhone 14', 17000000, 10, 'Like New', '1'),
    ('3', 'Samsung S24', 22000000, 15, 'New', '2'),
    ('4', 'Redmi K30 5G', 5500000, 30, 'China', '3'),
    ('5', 'Redmi Note 14', 13000000, 12, 'China', '3');
	
SELECT * FROM category
SELECT * FROM product

