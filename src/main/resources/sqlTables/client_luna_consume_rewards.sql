CREATE TABLE IF NOT EXISTS `client_luna_consume_rewards` (
                                                             `id` int NOT NULL,
                                                             `name` varchar(255) NOT NULL,
    `luna_sum_count` int DEFAULT NULL,
    `gacha_cost` int DEFAULT NULL,
    `num_1` int DEFAULT NULL,
    `create_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;