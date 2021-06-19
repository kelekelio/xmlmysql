-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 01:03 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kr_live`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_item_upgrades_upgrade_list`
--

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
    KEY `name` (`name`),
    KEY `upgrade_item` (`upgrade_item`),
    KEY `sub_material_item1` (`sub_material_item1`),
    KEY `sub_material_item2` (`sub_material_item2`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
