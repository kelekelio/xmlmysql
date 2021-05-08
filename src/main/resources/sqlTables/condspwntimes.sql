CREATE TABLE IF NOT EXISTS `condspwntimes` (
                                               `id` int NOT NULL,
                                               `name` varchar(255) NOT NULL,
    `duration` int DEFAULT NULL,
    `world` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `typevalue` text,
    `start` int DEFAULT NULL,
    `conditions` text,
    `type` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;