DROP TABLE IF EXISTS `item_authorizes_enchant_attr_list`;
CREATE TABLE IF NOT EXISTS `item_authorizes_enchant_attr_list` (
                                                                 `id` int NOT NULL AUTO_INCREMENT,
                                                                 `name` varchar(255) NOT NULL,
    `level` int DEFAULT NULL,
    `attr2` text,
    `attr1` text,
    `attr3` text,
    `attr6` text,
    `attr5` text,
    `attr4` text,
    `attr7` text,
    `attr9` text,
    `attr8` text,
    `attr10` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;