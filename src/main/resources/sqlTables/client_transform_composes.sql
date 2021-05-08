CREATE TABLE IF NOT EXISTS `client_transform_composes` (
                                                           `id` int NOT NULL,
                                                           `name` varchar(255) NOT NULL,
    `compose_fee_6ea` int DEFAULT NULL,
    `compose_fee_3ea` int DEFAULT NULL,
    `compose_fee_2ea` int DEFAULT NULL,
    `compose_fee_5ea` int DEFAULT NULL,
    `compose_fee_4ea` int DEFAULT NULL,
    `down_rate_5ea` int DEFAULT NULL,
    `up_rate_3ea` int DEFAULT NULL,
    `up_rate_4ea` int DEFAULT NULL,
    `down_rate_4ea` int DEFAULT NULL,
    `down_rate_3ea` int DEFAULT NULL,
    `up_rate_5ea` int DEFAULT NULL,
    `down_rate_2ea` int DEFAULT NULL,
    `up_rate_6ea` int DEFAULT NULL,
    `up_rate_2ea` int DEFAULT NULL,
    `same_rate_4ea` int DEFAULT NULL,
    `same_rate_5ea` int DEFAULT NULL,
    `same_rate_2ea` int DEFAULT NULL,
    `same_rate_3ea` int DEFAULT NULL,
    `same_rate_6ea` int DEFAULT NULL,
    `down_rate_6ea` int DEFAULT NULL,
    `material_grade` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;