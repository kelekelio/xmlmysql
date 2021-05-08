CREATE TABLE IF NOT EXISTS `client_achievement_actions` (
                                                            `id` int NOT NULL,
                                                            `name` varchar(255) NOT NULL,
    `description` text,
    `title` text,
    `type` text,
    `maxprogress` int DEFAULT NULL,
    `completecond` text,
    `completecond_tag` text,
    `levelgap` int DEFAULT NULL,
    `target_type` text,
    `gold` int DEFAULT NULL,
    `exp` int DEFAULT NULL,
    `gp` int DEFAULT NULL,
    `retrieve_item` text,
    `ap` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
