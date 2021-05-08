CREATE TABLE IF NOT EXISTS `client_item_skill_enhances_enchant_skill_list` (
                                                                               `id` int NOT NULL AUTO_INCREMENT,
                                                                               `name` varchar(255) NOT NULL,
    `skill_group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `skill_prob` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;