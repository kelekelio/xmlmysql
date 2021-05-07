CREATE TABLE IF NOT EXISTS `client_assembly_items_assemble_parts` (
                                                                      `id` int NOT NULL AUTO_INCREMENT,
                                                                      `name` varchar(255) NOT NULL,
    `part_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `part_item_num` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;