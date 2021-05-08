CREATE TABLE IF NOT EXISTS `client_reinvent_candidates_candidate_list` (
                                                                           `id` int NOT NULL AUTO_INCREMENT,
                                                                           `name` varchar(255) NOT NULL,
    `item_count` int DEFAULT NULL,
    `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;