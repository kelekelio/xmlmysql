CREATE TABLE `skill_base_clients_version` (
  `client_version` char(25) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `id` int(6) DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `client_version` (`client_version`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='skill version table';
