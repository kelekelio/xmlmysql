DROP TABLE IF EXISTS `real_item_random_options_random_option_list`;
CREATE TABLE IF NOT EXISTS `real_item_random_options_random_option_list` (
                                                           `id` int NOT NULL AUTO_INCREMENT,
                                                           `name` varchar(255) NOT NULL,
    `random_attr_name` text,
    `random_attr_max` int DEFAULT NULL,
    `random_attr_min` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;