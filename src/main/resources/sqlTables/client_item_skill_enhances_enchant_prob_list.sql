CREATE TABLE IF NOT EXISTS `client_item_skill_enhances_enchant_prob_list` (
                                                                              `id` int NOT NULL AUTO_INCREMENT,
                                                                              `name` varchar(255) NOT NULL,
    `enchant_prob` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;