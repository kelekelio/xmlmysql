CREATE TABLE `client_assemble_parts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `part_item` text,
  `part_item_num` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22648 DEFAULT CHARSET=utf8;
