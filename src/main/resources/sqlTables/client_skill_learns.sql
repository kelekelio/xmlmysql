CREATE TABLE `client_skill_learns` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `autolearn` tinyint(1) DEFAULT NULL,
  `ui_display` tinyint(1) DEFAULT NULL,
  `pc_level` int(3) DEFAULT NULL,
  `race` varchar(8) DEFAULT NULL,
  `skill` varchar(255) DEFAULT NULL,
  `skill_level` int(2) DEFAULT NULL,
  `class` varchar(15) DEFAULT NULL,
  `stigma_display` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
