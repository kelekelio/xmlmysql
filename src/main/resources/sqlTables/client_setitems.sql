CREATE TABLE `client_setitems` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `piece_bonus5` text,
  `piece_bonus3` text,
  `description` varchar(255) DEFAULT NULL,
  `item7` varchar(255) DEFAULT NULL,
  `fullset_bonus` text,
  `item4` varchar(255) DEFAULT NULL,
  `item3` varchar(255) DEFAULT NULL,
  `item6` varchar(255) DEFAULT NULL,
  `item5` varchar(255) DEFAULT NULL,
  `item2` varchar(255) DEFAULT NULL,
  `item1` varchar(255) DEFAULT NULL,
  `piece_bonus2` text,
  `item12` varchar(255) DEFAULT NULL,
  `item11` varchar(255) DEFAULT NULL,
  `item13` varchar(255) DEFAULT NULL,
  `item9` varchar(255) DEFAULT NULL,
  `item10` varchar(255) DEFAULT NULL,
  `piece_bonus4` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `item10` (`item10`),
  KEY `item1` (`item1`),
  KEY `item13` (`item13`),
  KEY `item2` (`item2`),
  KEY `item3` (`item3`),
  KEY `item4` (`item4`),
  KEY `item5` (`item5`),
  KEY `item6` (`item6`),
  KEY `item7` (`item7`),
  KEY `item9` (`item9`),
  KEY `item11` (`item11`),
  KEY `item12` (`item12`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
