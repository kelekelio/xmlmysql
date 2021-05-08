CREATE TABLE IF NOT EXISTS `client_login_events_reward_item_list` (
                                                                      `id` int NOT NULL AUTO_INCREMENT,
                                                                      `name` varchar(255) NOT NULL,
    `reward_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `reward_item_count` int DEFAULT NULL,
    `reward_permit_level` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;