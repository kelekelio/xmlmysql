CREATE TABLE `npc_clients_version` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `client_version` char(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
