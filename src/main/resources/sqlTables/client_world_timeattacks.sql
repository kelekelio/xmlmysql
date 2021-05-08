CREATE TABLE IF NOT EXISTS `client_world_timeattacks` (
                                                          `id` int NOT NULL,
                                                          `name` varchar(255) NOT NULL,
    `s_time_maximum` int DEFAULT NULL,
    `a_score_minimum` int DEFAULT NULL,
    `time_limit` int DEFAULT NULL,
    `worldname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `b_time_maximum` int DEFAULT NULL,
    `a_time_maximum` int DEFAULT NULL,
    `c_score_minimum` int DEFAULT NULL,
    `c_time_maximum` int DEFAULT NULL,
    `d_score_minimum` int DEFAULT NULL,
    `d_time_maximum` int DEFAULT NULL,
    `b_score_minimum` int DEFAULT NULL,
    `s_score_minimum` int DEFAULT NULL,
    `type` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;