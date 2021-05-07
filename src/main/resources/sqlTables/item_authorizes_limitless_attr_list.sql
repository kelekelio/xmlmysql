DROP TABLE IF EXISTS `item_authorizes_limitless_attr_list`;
CREATE TABLE IF NOT EXISTS `item_authorizes_limitless_attr_list` (
                                                                   `id` int NOT NULL AUTO_INCREMENT,
                                                                   `name` varchar(255) NOT NULL,
    `attr_name` text,
    `idx` int DEFAULT NULL,
    `attr_value` int DEFAULT NULL,
    `random_enchant` int DEFAULT NULL,
    `random_range` int DEFAULT NULL,
    `random_prob` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;