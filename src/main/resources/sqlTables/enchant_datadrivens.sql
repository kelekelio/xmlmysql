CREATE TABLE IF NOT EXISTS `enchant_datadrivens` (
                                                     `id` int NOT NULL,
                                                     `name` varchar(255) NOT NULL,
    `driven_enchant_type` text,
    `next_enchant_prob` int DEFAULT NULL,
    `matter_quality` text,
    `target_item_quality` text,
    `next_enchant_penalty` int DEFAULT NULL,
    `next_enchant_price` int DEFAULT NULL,
    `matter_item_category` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;