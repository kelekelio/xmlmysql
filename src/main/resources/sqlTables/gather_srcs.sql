-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 09, 2021 at 12:37 PM
-- Server version: 8.0.21
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aion`
--

-- --------------------------------------------------------

--
-- Table structure for table `gather_srcs`
--

DROP TABLE IF EXISTS `gather_srcs`;
CREATE TABLE IF NOT EXISTS `gather_srcs` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `gather_delay` int DEFAULT NULL,
  `normal_rate1` int DEFAULT NULL,
  `harvest_count` int DEFAULT NULL,
  `aerial_adj` int DEFAULT NULL,
  `harvestskill` varchar(20) DEFAULT NULL,
  `success_adj` int DEFAULT NULL,
  `skill_level` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `source_type` varchar(20) DEFAULT NULL,
  `check_type` int DEFAULT NULL,
  `gather_delay_id` int DEFAULT NULL,
  `source_color` text,
  `source_upper` decimal(8,6) DEFAULT NULL,
  `source_fx` text,
  `material1` varchar(50) DEFAULT NULL,
  `failure_adj` int DEFAULT NULL,
  `captcha_rate` int DEFAULT NULL,
  `motion_name` text,
  `category` varchar(15) DEFAULT NULL,
  `mesh` text,
  `char_level_limit` int DEFAULT NULL,
  `normal_rate2` int DEFAULT NULL,
  `material2` varchar(50) DEFAULT NULL,
  `required_item` varchar(50) DEFAULT NULL,
  `normal_rate3` int DEFAULT NULL,
  `extra_normal_rate3` int DEFAULT NULL,
  `material3` varchar(50) DEFAULT NULL,
  `extra_normal_rate4` int DEFAULT NULL,
  `extra_normal_rate1` int DEFAULT NULL,
  `extra_normal_rate2` int DEFAULT NULL,
  `extra_material1` varchar(50) DEFAULT NULL,
  `erase_value` tinyint(1) DEFAULT NULL,
  `extra_material4` varchar(50) DEFAULT NULL,
  `extra_material3` varchar(50) DEFAULT NULL,
  `extra_material2` varchar(50) DEFAULT NULL,
  `normal_rate5` int DEFAULT NULL,
  `normal_rate4` int DEFAULT NULL,
  `material4` varchar(50) DEFAULT NULL,
  `material5` varchar(50) DEFAULT NULL,
  `normal_rate6` int DEFAULT NULL,
  `material6` varchar(50) DEFAULT NULL,
  `normal_rate7` int DEFAULT NULL,
  `material7` varchar(50) DEFAULT NULL,
  `extra_material7` varchar(50) DEFAULT NULL,
  `extra_material6` varchar(50) DEFAULT NULL,
  `extra_normal_rate7` int DEFAULT NULL,
  `extra_normal_rate5` int DEFAULT NULL,
  `extra_normal_rate6` int DEFAULT NULL,
  `extra_material5` varchar(50) DEFAULT NULL,
  `extra_material8` varchar(50) DEFAULT NULL,
  `extra_normal_rate8` int DEFAULT NULL,
  `normal_rate8` int DEFAULT NULL,
  `material8` varchar(50) DEFAULT NULL,
  `search_ko` varchar(255) DEFAULT NULL,
  `search_en` varchar(255) DEFAULT NULL,
  `search_de` varchar(255) DEFAULT NULL,
  `search_fr` varchar(255) DEFAULT NULL,
  `search_it` varchar(255) DEFAULT NULL,
  `search_pl` varchar(255) DEFAULT NULL,
  `search_es` varchar(255) DEFAULT NULL,
  `search_us` varchar(255) DEFAULT NULL,
  `material_num1` int DEFAULT NULL,
  `extra_material_num1` int DEFAULT NULL,
  `material_num2` int DEFAULT NULL,
  `extra_material_num2` int DEFAULT NULL,
  `extra_material_num4` int DEFAULT NULL,
  `material_num4` int DEFAULT NULL,
  `extra_material_num3` int DEFAULT NULL,
  `material_num3` int DEFAULT NULL,
  `extra_material_num5` int DEFAULT NULL,
  `extra_material_num6` int DEFAULT NULL,
  `material_num6` int DEFAULT NULL,
  `material_num5` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `search_ko` (`search_ko`),
  KEY `search_en` (`search_en`),
  KEY `search_de` (`search_de`),
  KEY `search_fr` (`search_fr`),
  KEY `search_it` (`search_it`),
  KEY `search_pl` (`search_pl`),
  KEY `search_es` (`search_es`),
  KEY `search_us` (`search_us`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
