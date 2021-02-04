-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 09, 2021 at 01:45 PM
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
-- Table structure for table `client_familiars`
--

DROP TABLE IF EXISTS `client_familiars`;
CREATE TABLE `client_familiars` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `desc_long` text,
  `desc_story` text,
  `dir` text,
  `mesh` text,
  `tier_grade` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `star_grade` int DEFAULT NULL,
  `is_only_feeds` tinyint(1) DEFAULT NULL,
  `use_func_option` tinyint(1) DEFAULT NULL,
  `physical_bonus_attr1` text,
  `physical_bonus_attr2` text,
  `physical_bonus_attr3` text,
  `physical_bonus_attr4` text,
  `magical_bonus_attr1` text,
  `magical_bonus_attr2` text,
  `magical_bonus_attr3` text,
  `magical_bonus_attr4` text,
  `icon_name` text,
  `growth_pt` int DEFAULT NULL,
  `max_growth_value` int DEFAULT NULL,
  `growth_cost` int DEFAULT NULL,
  `evolve_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `evolve_item_num` int DEFAULT NULL,
  `evolve_cost` int DEFAULT NULL,
  `fskill01` text,
  `usefskill01_energy` text,
  `fskill02` text,
  `usefskill02_energy` text,
  `ui_star_grade` int DEFAULT NULL,
  `can_authorize` tinyint(1) DEFAULT NULL,
  `growth_point_from_pc_kill` int DEFAULT NULL,
  `skill_point_from_pc_kill` int DEFAULT NULL,
  `sub_group_set` text,
  `authorize_grade` int DEFAULT NULL,
  `fgroup_set` text,
  `is_only_authorize_feed` tinyint(1) DEFAULT NULL,
  `skill_point_rate_from_exp` int DEFAULT NULL,
  `skill_point_max` int DEFAULT NULL,
  `growth_point_rate_from_exp` int DEFAULT NULL,
  `wing` text,
  `sub_physical_bonus_attr1` text,
  `sub_physical_bonus_attr3` text,
  `sub_physical_bonus_attr2` text,
  `sub_physical_bonus_attr4` text,
  `sub_magical_bonus_attr2` text,
  `sub_magical_bonus_attr1` text,
  `sub_magical_bonus_attr4` text,
  `sub_magical_bonus_attr3` text,
  `sub_equal_physical_bonus_attr1` text,
  `sub_equal_physical_bonus_attr2` text,
  `evolve_type` int DEFAULT NULL,
  `evolve_success_prob` int DEFAULT NULL,
  `evolve_fail_add_prob` int DEFAULT NULL,
  `physical_bonus_attr5` text,
  `can_evolve` tinyint(1) DEFAULT NULL,
  `sub_equal_magical_bonus_attr1` text,
  `sub_equal_magical_bonus_attr2` text,
  `magical_bonus_attr5` text,
  `sub_physical_bonus_attr5` text,
  `sub_magical_bonus_attr5` text,
  `authorize_minion_num` int DEFAULT NULL,
  `authorize_cost` int DEFAULT NULL,
  `sub_equal_physical_bonus_attr3` text,
  `sub_equal_physical_bonus_attr4` text,
  `sub_equal_physical_bonus_attr5` text,
  `sub_equal_magical_bonus_attr4` text,
  `sub_equal_magical_bonus_attr5` text,
  `sub_equal_magical_bonus_attr3` text,
  `search_ko` text,
  `search_us` text,
  `search_es` text,
  `search_pl` text,
  `search_it` text,
  `search_fr` text,
  `search_de` text,
  `search_en` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  FULLTEXT KEY `idx_search_de` (`search_de`),
  FULLTEXT KEY `idx_search_fr` (`search_fr`),
  FULLTEXT KEY `idx_search_it` (`search_it`),
  FULLTEXT KEY `idx_search_pl` (`search_pl`),
  FULLTEXT KEY `idx_search_es` (`search_es`),
  FULLTEXT KEY `idx_search_us` (`search_us`),
  FULLTEXT KEY `idx_search_ko` (`search_ko`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;
