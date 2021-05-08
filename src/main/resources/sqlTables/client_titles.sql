CREATE TABLE IF NOT EXISTS `client_titles` (
                                               `id` int NOT NULL,
                                               `name` varchar(255) NOT NULL,
    `title_race` int DEFAULT NULL,
    `title_priority` int DEFAULT NULL,
    `description` text,
    `title_location` text,
    `title_desc` text,
    `title_type` tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;