CREATE TABLE IF NOT EXISTS `quest_data_drivens` (
                                                    `id` int NOT NULL,
                                                    `name` varchar(255) NOT NULL,
    `value0_acquire_` text,
    `reward_npc_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `category_acquire_` text,
    `value1_acquire_` text,
    `con_quest` int DEFAULT NULL,
    `value4_acquire_` text,
    `value10_acquire_` text,
    `con_quest_list` text,
    `value6_acquire_` text,
    `value7_acquire_` text,
    `value2_acquire_` text,
    `value5_acquire_` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;