CREATE TABLE `client_toypet_items` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `mesh` text,
  `attach_part` text,
  `desc_long` text,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
