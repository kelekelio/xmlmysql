CREATE TABLE IF NOT EXISTS `client_npc_goodslists` (
                                                       `id` int NOT NULL,
                                                       `name` varchar(255) NOT NULL,
    `description` varchar(255) DEFAULT NULL,
    `use_category` int DEFAULT NULL,
    `guild_level` int DEFAULT NULL,
    `gossip_msg` text,
    `sales_clear_interval` int DEFAULT NULL,
    `sales_clear_turn` int DEFAULT NULL,
    `salestime_table_name` text,
    `advertise_msg` text,
    `sale_explain_desc` text,
    `fame_group_name` text,
    `fame_level` int DEFAULT NULL,
    `sales_server` text,
    `devaship_level` text,
    `ingame_shop_start` text,
    `ingame_shop_end` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;