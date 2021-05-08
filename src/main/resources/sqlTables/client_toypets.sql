CREATE TABLE `client_toypets` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `desc_long` text,
  `icon_name` text,
  `dir` text,
  `mesh` text,
  `pet_condition_reward` varchar(255) DEFAULT NULL,
  `bag` varchar(255) DEFAULT NULL,
  `combat_reaction` text,
  `color` text,
  `func_type_name1` varchar(255) DEFAULT NULL,
  `func_type_name2` varchar(255) DEFAULT NULL,
  `func_type2` varchar(50) DEFAULT NULL,
  `func_type1` varchar(50) DEFAULT NULL,
  `enemy_alarm` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;