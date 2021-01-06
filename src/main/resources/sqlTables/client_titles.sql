CREATE TABLE `client_titles` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `title_race` int(1) DEFAULT NULL,
  `title_priority` int(3) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title_location` varchar(255) DEFAULT NULL,
  `title_desc` varchar(255) DEFAULT NULL,
  `title_type` tinyint(1) DEFAULT NULL,
  `bonus_attrs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
