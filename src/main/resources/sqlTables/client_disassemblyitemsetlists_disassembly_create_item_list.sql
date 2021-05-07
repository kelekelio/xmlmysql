DROP TABLE IF EXISTS `client_disassemblyitemsetlists_disassembly_create_item_list`;
CREATE TABLE IF NOT EXISTS `client_disassemblyitemsetlists_disassembly_create_item_list` (
                                                                `id` int NOT NULL AUTO_INCREMENT,
                                                                `name` varchar(255) NOT NULL,
    `num_` int DEFAULT NULL,
    `create_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;