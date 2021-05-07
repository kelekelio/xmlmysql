DROP TABLE IF EXISTS `item_enchants`;
CREATE TABLE IF NOT EXISTS `item_enchants` (
                                               `id` int NOT NULL,
                                               `name` varchar(255) NOT NULL,
    `start_limitless` int DEFAULT NULL,
    `stat_type` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;