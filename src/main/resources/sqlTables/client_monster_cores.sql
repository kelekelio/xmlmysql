CREATE TABLE IF NOT EXISTS `client_monster_cores` (
                                                      `id` int NOT NULL,
                                                      `name` varchar(255) NOT NULL,
    `max_core_value` int DEFAULT NULL,
    `category_icon` text,
    `description` text,
    `category_desc` text,
    `icon_name` text,
    `quality` text,
    `pennant_boss_buff_tip` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;