CREATE TABLE IF NOT EXISTS `client_ride_datas` (
                                                   `id` int NOT NULL,
                                                   `name` varchar(255) NOT NULL,
    `guild_color` tinyint(1) DEFAULT NULL,
    `fly_speed` decimal(9,6) DEFAULT NULL,
    `cost_fp` int DEFAULT NULL,
    `motion` text,
    `can_sprint` tinyint(1) DEFAULT NULL,
    `ride_type` int DEFAULT NULL,
    `move_speed` decimal(9,6) DEFAULT NULL,
    `sprint_speed` decimal(9,6) DEFAULT NULL,
    `start_fp` int DEFAULT NULL,
    `mesh` text,
    `default_color` text,
    `emblem2` text,
    `emblem1` text,
    `skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `ridebag_show_item` text,
    `ridebag_view_camera` text,
    `guild_level_permitted` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;