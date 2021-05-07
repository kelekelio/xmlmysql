DROP TABLE IF EXISTS `item_random_options_random_attr_group_list`;
CREATE TABLE IF NOT EXISTS `item_random_options_random_attr_group_list` (
                                                               `id` int NOT NULL AUTO_INCREMENT,
                                                               `name` varchar(255) NOT NULL,
    `prob` int DEFAULT NULL,
    `attr_group_id` int DEFAULT NULL,
    `random_attr1` text,
    `random_attr2` text,
    `random_attr3` text,
    `random_attr4` text,
    `random_attr5` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;