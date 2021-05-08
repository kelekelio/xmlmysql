CREATE TABLE IF NOT EXISTS `client_achievements` (
                                                     `id` int NOT NULL,
                                                     `name` varchar(255) DEFAULT NULL,
    `title` text,
    `description` text,
    `active` tinyint(1) NOT NULL,
    `type` text,
    `repeats` text,
    `race` text,
    `minlevel` int NOT NULL,
    `maxlevel` int NOT NULL,
    `completecount` int NOT NULL,
    `gold` int DEFAULT NULL,
    `exp` int DEFAULT NULL,
    `ap` int DEFAULT NULL,
    `gp` int DEFAULT NULL,
    `completecond` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;