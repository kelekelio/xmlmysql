CREATE TABLE `client_toypet_warehouses` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `warehouse_slot_count` int DEFAULT NULL,
  `warehouse_slot_type` text,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
