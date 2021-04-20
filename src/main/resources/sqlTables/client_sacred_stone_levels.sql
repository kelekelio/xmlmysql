--
-- Table structure for table `client_sacred_stone_levels`
--

DROP TABLE IF EXISTS `client_sacred_stone_levels`;
CREATE TABLE IF NOT EXISTS `client_sacred_stone_levels` (
                                                            `id` int NOT NULL AUTO_INCREMENT,
                                                            `add_phy_attribute_2` text,
                                                            `add_phy_attribute_1` text,
                                                            `add_mag_attribute_1` text,
                                                            `add_mag_attribute_2` text,
                                                            `phy_perk_skill_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `mag_perk_skill_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `add_phy_attribute_3` text,
    `add_mag_attribute_3` text,
    `require_fame_id_d` int DEFAULT NULL,
    `require_fame_id_l` int DEFAULT NULL,
    `require_fame_level` int DEFAULT NULL,
    `level` int DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client_sacred_stone_levels`
--