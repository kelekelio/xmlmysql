DROP TABLE IF EXISTS `client_disassemblyitemsets_disassemble_set_list`;
CREATE TABLE IF NOT EXISTS `client_disassemblyitemsets_disassemble_set_list` (
                                                             `id` int NOT NULL AUTO_INCREMENT,
                                                             `name` varchar(255) NOT NULL,
    `apply_level_` text,
    `set_list_name_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `apply_class_` text,
    `apply_race_` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;