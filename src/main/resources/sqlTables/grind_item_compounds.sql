CREATE TABLE IF NOT EXISTS `grind_item_compounds` (
                                                      `id` int NOT NULL,
                                                      `name` varchar(255) NOT NULL,
    `compound_fee` int DEFAULT NULL,
    `grind_item_category` text,
    `result_grind_item_example` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `job` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;