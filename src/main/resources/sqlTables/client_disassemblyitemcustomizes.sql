CREATE TABLE IF NOT EXISTS `client_disassemblyitemcustomizes` (
                                                                  `id` int NOT NULL,
                                                                  `name` varchar(255) NOT NULL,
    `custom_name` text,
    `disassembly_name` text,
    `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `wrap_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;