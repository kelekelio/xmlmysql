DROP TABLE IF EXISTS `client_item_upgrades_upgrade_list`;
CREATE TABLE IF NOT EXISTS `client_item_upgrades_upgrade_list` (
                                                     `id` int NOT NULL AUTO_INCREMENT,
                                                     `name` varchar(255) NOT NULL,
    `upgrade_authorize_type` int DEFAULT NULL,
    `upgrade_authorize_count` int DEFAULT NULL,
    `upgrade_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `upgrade_npc` text,
    `check_authorize_count` int DEFAULT NULL,
    `upgrade_enchant_count` int DEFAULT NULL,
    `sub_material_item_count1` int DEFAULT NULL,
    `upgrade_enchant_type` int DEFAULT NULL,
    `check_enchant_count` int DEFAULT NULL,
    `sub_material_item1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `need_qina` int DEFAULT NULL,
    `check_option_slot_count` int DEFAULT NULL,
    `need_abyss_point` int DEFAULT NULL,
    `sub_material_item2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `sub_material_item_count2` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;