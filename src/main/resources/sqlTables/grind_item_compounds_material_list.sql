CREATE TABLE IF NOT EXISTS `grind_item_compounds_material_list` (
                                                                    `id` int NOT NULL AUTO_INCREMENT,
                                                                    `name` varchar(255) NOT NULL,
    `material_grind_item_color` int DEFAULT NULL,
    `material_grind_item_quality` int DEFAULT NULL,
    `material_grind_item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `material_grind_item_prefix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;