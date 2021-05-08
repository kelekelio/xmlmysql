CREATE TABLE IF NOT EXISTS `client_reinvent_materials` (
                                                           `id` int NOT NULL,
                                                           `name` varchar(255) NOT NULL,
    `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `package_id` int DEFAULT NULL,
    `point` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;