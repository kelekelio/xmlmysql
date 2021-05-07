DROP TABLE IF EXISTS `real_item_random_options`;
CREATE TABLE IF NOT EXISTS `real_item_random_options` (
                                                          `id` int NOT NULL,
                                                          `name` varchar(255) NOT NULL,
    `set_random_option_num` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;