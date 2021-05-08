CREATE TABLE IF NOT EXISTS `client_achievement_events_item_list_2` (
                                                                       `id` int NOT NULL AUTO_INCREMENT,
                                                                       `name` varchar(255) NOT NULL,
    `item_name_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `item_amount_2` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;