CREATE TABLE `client_toypet_dopings` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `use_doping_food` tinyint(1) DEFAULT NULL,
  `use_doping_scroll` int DEFAULT NULL,
  `description` text,
  `use_doping_drink` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
