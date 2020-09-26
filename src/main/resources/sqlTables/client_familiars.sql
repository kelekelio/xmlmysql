-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 26, 2020 at 11:21 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
CREATE TABLE IF NOT EXISTS `client_familiars` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `desc_story` text,
  `altitude` text,
  `ui_star_grade` text,
  `upper` text,
  `description` text,
  `tier_grade` text,
  `scale` text,
  `dir` text,
  `icon_name` text,
  `can_authorize` text,
  `target_sound` text,
  `is_only_feeds` text,
  `art_org_move_speed_normal_walk` text,
  `growth_point_from_pc_kill` text,
  `skill_point_from_pc_kill` text,
  `fskill02` text,
  `sub_group_set` text,
  `authorize_grade` text,
  `camera` text,
  `mesh` text,
  `fgroup_set` text,
  `is_only_authorize_feed` text,
  `side` text,
  `physical_bonus_attr3` text,
  `skill_point_rate_from_exp` int(11) DEFAULT NULL,
  `physical_bonus_attr4` text,
  `physical_bonus_attr1` text,
  `physical_bonus_attr2` text,
  `iserect` text,
  `usefskill02_energy` text,
  `desc_long` text,
  `skill_point_max` text,
  `art_org_speed_normal_run` text,
  `use_func_option` text,
  `growth_point_rate_from_exp` int(11) DEFAULT NULL,
  `magical_bonus_attr1` text,
  `magical_bonus_attr3` text,
  `growth_pt` text,
  `magical_bonus_attr2` text,
  `front` text,
  `wing` text,
  `magical_bonus_attr4` text,
  `star_grade` text,
  `growth_cost` int(11) DEFAULT NULL,
  `evolve_item` text,
  `max_growth_value` int(11) DEFAULT NULL,
  `evolve_item_num` int(11) DEFAULT NULL,
  `fskill01` text,
  `evolve_cost` int(11) DEFAULT NULL,
  `usefskill01_energy` int(11) DEFAULT NULL,
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
  `evolve_type` int(2) DEFAULT NULL,
  `evolve_success_prob` int(11) DEFAULT NULL,
  `evolve_fail_add_prob` int(11) DEFAULT NULL,
  `physical_bonus_attr5` text,
  `can_evolve` text,
  `sub_equal_magical_bonus_attr1` text,
  `sub_equal_magical_bonus_attr2` text,
  `magical_bonus_attr5` text,
  `sub_physical_bonus_attr5` text,
  `sub_magical_bonus_attr5` text,
  `authorize_minion_num` int(2) DEFAULT NULL,
  `authorize_cost` int(11) DEFAULT NULL,
  `sub_equal_physical_bonus_attr3` text,
  `sub_equal_physical_bonus_attr4` text,
  `sub_equal_physical_bonus_attr5` text,
  `sub_equal_magical_bonus_attr4` text,
  `sub_equal_magical_bonus_attr5` text,
  `sub_equal_magical_bonus_attr3` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
