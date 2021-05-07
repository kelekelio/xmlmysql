DROP TABLE IF EXISTS `item_random_options`;
CREATE TABLE IF NOT EXISTS `item_random_options` (
                                                     `id` int NOT NULL,
                                                     `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;