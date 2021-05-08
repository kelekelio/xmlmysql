CREATE TABLE IF NOT EXISTS `client_transform_collections` (
                                                              `id` int NOT NULL,
                                                              `name` varchar(255) NOT NULL,
    `trans_01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `trans_02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `physical_reward_attr1` text,
    `description` text,
    `trans_icon_show` tinyint(1) DEFAULT NULL,
    `magical_reward_attr1` text,
    `trans_03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `trans_04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `trans_05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `trans_06` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `reward_skill_active` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `trans_num` int DEFAULT NULL,
    `trans_grade` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;