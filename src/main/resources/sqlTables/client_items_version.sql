CREATE TABLE `client_items_version` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `client_version` char(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `client_version` (`client_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
