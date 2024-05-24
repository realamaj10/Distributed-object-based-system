/***********Database Creation********/
CREATE DATABASE `electronic_shop`;
/***********************************/

USE `electronic_shop`;

/***********Table Creation********/
CREATE TABLE `electronic_shop`.`Products`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`price` DOUBLE NOT NULL ,
`arrival_date` DATE NOT NULL,
`manufacturer` VARCHAR(100) NOT NULL,
`quantity` INT NOT NULL,
PRIMARY KEY (`id`))
ENGINE = InnoDB;

/***********Table Creation********/
CREATE TABLE `electronic_shop`.`Sales` (
`id` INT NOT NULL AUTO_INCREMENT,
`sale_date` DATE NOT NULL,
`total_amount` DOUBLE NOT NULL,
`number_product` INT NOT NULL,
`product_id` INT NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (product_id) REFERENCES Products(id))
ENGINE = InnoDB;

/***********Inserting Data in Table********/
INSERT INTO `products` (`id`, `name`, `price`, `arrival_date`, `manufacturer`, `quantity`) VALUES
(NULL, 'Hp Pavilion', '1500', '2022-01-03', 'HP', '15'),
(NULL, 'Dell XPS', '900', '2022-02-01', 'Dell', '35'),
(NULL, 'PlayStation 5', '500', '2022-01-15', 'PlayStation', '8'),
(NULL, 'Xbox', '400', '2021-11-19', 'Microsoft', '5'),
(NULL, 'Cameras', '150', '2021-12-10', 'Nikon', '20'),
(NULL, 'Logitech MX Keys', '90', '2021-11-05', 'Logi', '100'),
(NULL, 'Bicycles', '400', '2022-01-15', 'BMX', '3'),
(NULL, 'MX Master 3', '90', '2022-01-08', 'Logi', '6'),
(NULL, 'S10', '500', '2022-01-29', 'Samsung', '300'),
(NULL, 'MacBook M1 Pro 2021', '2000', '2022-01-16', 'Apple', '2');

/***********Inserting Data in Table********/
INSERT INTO `sales` (`id`, `sale_date`, `total_amount`, `number_product`, `product_id`) VALUES
(NULL, '2022-03-12', '4500', '3', '1'),
(NULL, '2022-02-20', '3500', '5', '2'),
(NULL, '2022-03-24', '1000', '2', '3'),
(NULL, '2022-03-30', '3250', '10', '9'),
(NULL, '2022-02-05', '1500', '10', '5');