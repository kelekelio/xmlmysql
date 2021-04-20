CREATE TABLE `client_toypet_buffs` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `food_item` text,
  `food_consume_count` int DEFAULT NULL,
  `bonus_attr1` text,
  `bonus_attr2` text,
  `bonus_attr3` text,
  `bonus_attr4` text,
  `bonus_attr5` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
