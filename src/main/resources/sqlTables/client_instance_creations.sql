CREATE TABLE IF NOT EXISTS `client_instance_creations` (
                                                           `id` int NOT NULL,
                                                           `name` varchar(255) NOT NULL,
    `worldname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `quna_buff_luna_price_id` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;