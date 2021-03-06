CREATE TABLE IF NOT EXISTS `client_item_collections` (
                                                         `id` int NOT NULL,
                                                         `name` varchar(255) NOT NULL,
    `slot02_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `collection_grade` text,
    `description` text,
    `slot02_spareitem` TEXT,
    `slot02_enchant` int DEFAULT NULL,
    `collection_show` tinyint(1) DEFAULT NULL,
    `slot02_cnt` int DEFAULT NULL,
    `slot01_cnt` int DEFAULT NULL,
    `slot01_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `reward_attr01` text,
    `slot01_spareitem` TEXT,
    `slot01_enchant` int DEFAULT NULL,
    `reward_attr02` text,
    `reward_item01_cnt` int DEFAULT NULL,
    `reward_item01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot06_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot06_cnt` int DEFAULT NULL,
    `slot04_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot03_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot06_enchant` int DEFAULT NULL,
    `slot03_cnt` int DEFAULT NULL,
    `slot05_enchant` int DEFAULT NULL,
    `slot04_enchant` int DEFAULT NULL,
    `slot04_cnt` int DEFAULT NULL,
    `slot03_enchant` int DEFAULT NULL,
    `slot05_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot05_cnt` int DEFAULT NULL,
    `slot07_cnt` int DEFAULT NULL,
    `slot09_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot08_cnt` int DEFAULT NULL,
    `slot07_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot07_enchant` int DEFAULT NULL,
    `slot08_enchant` int DEFAULT NULL,
    `slot09_enchant` int DEFAULT NULL,
    `slot09_cnt` int DEFAULT NULL,
    `slot08_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot04_spareitem` TEXT,
    `slot08_spareitem` TEXT,
    `slot05_spareitem` TEXT,
    `slot06_spareitem` TEXT,
    `slot03_spareitem` TEXT,
    `collection_end` datetime DEFAULT NULL,
    `reward_date` datetime DEFAULT NULL,
    `collection_start` datetime DEFAULT NULL,
    `slot10_enchant` int DEFAULT NULL,
    `slot10_cnt` int DEFAULT NULL,
    `slot10_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `slot07_spareitem` TEXT,
    `slot10_spareitem` TEXT,
    `slot09_spareitem` TEXT,
    `reward_attr03` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;