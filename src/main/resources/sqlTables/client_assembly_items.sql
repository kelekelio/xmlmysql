CREATE TABLE `client_assembly_items` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `part_critical_prob` int DEFAULT NULL,
  `part_critical_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
