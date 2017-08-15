DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id          INT PRIMARY KEY,
  username    VARCHAR(64) NOT NULL,
  password    VARCHAR(64)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
  category_id   INT PRIMARY KEY,
  name VARCHAR (50) NOT NULL,
  description   VARCHAR (100)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  product_id    INT PRIMARY KEY auto_increment,
  category_id   INT NOT NULL,
  name  VARCHAR (50) NOT NULL,
  price         DECIMAL
);

DELETE FROM users;
INSERT INTO users (id, username, password) VALUES
  (1, 'usr1', 'bigSecret'),
  (2, 'usr2', 'topSecret');


DELETE FROM category;
INSERT INTO category (category_id, name, description) VALUES
  (1, 'Beverages', 'test'),
  (2, 'Condiments', 'test'),
  (3, 'Oil', 'test');

DELETE FROM product;
INSERT INTO product (product_id, category_id, name, price) VALUES
  (1, 1, 'Northwind Traders Chai', 18.0000),
  (2, 2, 'Northwind Traders Syrup', 7.5000),
  (3, 2, 'Northwind Traders Cajun Seasoning', 16.5000),
  (4, 3, 'Northwind Traders Olive Oil', 16.0125),
  (5, 3, 'Northwind Traders Boysenberry Spread', 18.75),
  (6, 3, 'Northwind Traders Dried Pears', 22.5),
  (7, 3, 'Northwind Traders Curry Sauce', 30),
  (8, 2, 'Northwind Traders Walnuts', 17.4375),
  (9, 3, 'Northwind Traders Fruit Cocktail', 29.25),
  (10, 1, 'Northwind Traders Chocolate Biscuits Mix', 6.9),
  (11, 3, 'Northwind Traders Marmalade', 60.75),
  (12, 2, 'Northwind Traders Scones',  7.5),
  (13, 1, 'Northwind Traders Beer', 10.5),
  (14, 3, 'Northwind Traders Crab Meat',  13.8),
  (15, 3, 'Northwind Traders Clam Chowder', 7.2375);
