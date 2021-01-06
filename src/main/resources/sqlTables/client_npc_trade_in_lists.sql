CREATE TABLE `client_npc_trade_in_lists` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `goods_list` text,
  `use_category` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
