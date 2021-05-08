CREATE TABLE IF NOT EXISTS `client_skill_learns` (
                                                     `id` int NOT NULL,
                                                     `name` varchar(255) NOT NULL,
    `autolearn` text,
    `ui_display` tinyint(1) DEFAULT NULL,
    `pc_level` int DEFAULT NULL,
    `race` varchar(8) DEFAULT NULL,
    `skill` varchar(255) DEFAULT NULL,
    `skill_level` int DEFAULT NULL,
    `class` varchar(15) DEFAULT NULL,
    `stigma_display` int DEFAULT NULL,
    `reinforce_requirement` int DEFAULT NULL,
    `skill_requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `advanced_stigma` tinyint(1) DEFAULT NULL,
    `delete_` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;