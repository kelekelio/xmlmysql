CREATE TABLE IF NOT EXISTS `client_reinvent_packages` (
                                                          `id` int NOT NULL,
                                                          `name` varchar(255) NOT NULL,
    `goal_point` int DEFAULT NULL,
    `material_desc` text,
    `renewal_cost` int DEFAULT NULL,
    `renewal_max` int DEFAULT NULL,
    `activate` tinyint(1) DEFAULT NULL,
    `tab_name` text,
    `renewal_increment` int DEFAULT NULL,
    `min_level` int DEFAULT NULL,
    `renewal_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `tab_label` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;