CREATE TABLE IF NOT EXISTS `client_monster_cores_core_list` (
                                                                `id` int NOT NULL AUTO_INCREMENT,
                                                                `name` varchar(255) NOT NULL,
    `core_stat_name` text,
    `core_stat_value` int DEFAULT NULL,
    `core_count` int DEFAULT NULL,
    `core_limit_attribute_value` int DEFAULT NULL,
    `core_limit_attribute` text,
    `core_exclusive_attribute` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;