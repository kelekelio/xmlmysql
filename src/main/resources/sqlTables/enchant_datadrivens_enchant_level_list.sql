CREATE TABLE IF NOT EXISTS `enchant_datadrivens_enchant_level_list` (
                                                                        `id` int NOT NULL AUTO_INCREMENT,
                                                                        `name` varchar(255) NOT NULL,
    `enchant_price_basic` int DEFAULT NULL,
    `enchant_penalty_type` text,
    `enchant_level` int DEFAULT NULL,
    `enchant_price_type` text,
    `enchant_prob` int DEFAULT NULL,
    `enchant_bonus_level4_prob` int DEFAULT NULL,
    `enchant_bonus_level3_prob` int DEFAULT NULL,
    `enchant_bonus_level2_prob` int DEFAULT NULL,
    `sp_enchant_penalty_type` text,
    `sp_enchant_penalty_prob` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;