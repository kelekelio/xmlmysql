CREATE TABLE `client_toypet_merchants` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `rate_price` int DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
