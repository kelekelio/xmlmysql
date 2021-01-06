CREATE TABLE `client_npc_goodslists` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `goods_list` text,
  `description` varchar(255) DEFAULT NULL,
  `use_category` int(1) DEFAULT NULL,
  `guild_level` int(2) DEFAULT NULL,
  `gossip_msg` varchar(255) DEFAULT NULL,
  `sales_clear_interval` int(4) DEFAULT NULL,
  `sales_clear_turn` int(4) DEFAULT NULL,
  `salestime_table_name` text,
  `advertise_msg` text,
  `sale_explain_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
