CREATE TABLE `transaction`(
    `id` INT(11) NOT NULL,
`username` VARCHAR(45) NOT NULL,
`products` VARCHAR(500) NOT NULL,
`amounts` DOUBLE NOT NULL,
PRIMARY KEY (`id`));