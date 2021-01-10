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
CREATE TABLE IF NOT EXISTS `client_familiars` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `desc_long` varchar(255) DEFAULT NULL,
  `desc_story` varchar(255) DEFAULT NULL,
  `dir` text,
  `mesh` text,
  `tier_grade` text,
  `star_grade` text,
  `is_only_feeds` text,
  `use_func_option` text,
  `physical_bonus_attr1` text,
  `physical_bonus_attr2` text,
  `physical_bonus_attr3` text,
  `physical_bonus_attr4` text,
  `magical_bonus_attr1` text,
  `magical_bonus_attr2` text,
  `magical_bonus_attr3` text,
  `magical_bonus_attr4` text,
  `icon_name` text,
  `growth_pt` text,
  `max_growth_value` text,
  `growth_cost` text,
  `evolve_item` text,
  `evolve_item_num` text,
  `evolve_cost` text,
  `fskill01` text,
  `usefskill01_energy` text,
  `fskill02` text,
  `usefskill02_energy` text,
  `altitude` text,
  `ui_star_grade` text,
  `upper` text,
  `scale` text,
  `can_authorize` text,
  `target_sound` text,
  `art_org_move_speed_normal_walk` text,
  `growth_point_from_pc_kill` text,
  `skill_point_from_pc_kill` text,
  `sub_group_set` text,
  `authorize_grade` text,
  `camera` text,
  `fgroup_set` text,
  `is_only_authorize_feed` text,
  `side` text,
  `skill_point_rate_from_exp` text,
  `iserect` text,
  `skill_point_max` text,
  `art_org_speed_normal_run` text,
  `growth_point_rate_from_exp` text,
  `front` text,
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
  `evolve_type` text,
  `evolve_success_prob` text,
  `evolve_fail_add_prob` text,
  `physical_bonus_attr5` text,
  `can_evolve` text,
  `sub_equal_magical_bonus_attr1` text,
  `sub_equal_magical_bonus_attr2` text,
  `magical_bonus_attr5` text,
  `sub_physical_bonus_attr5` text,
  `sub_magical_bonus_attr5` text,
  `authorize_minion_num` text,
  `authorize_cost` text,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client_familiars`
--
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_en` (`search_en`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_de` (`search_de`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_fr` (`search_fr`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_it` (`search_it`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_pl` (`search_pl`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_es` (`search_es`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_us` (`search_us`);
ALTER TABLE `client_familiars` ADD FULLTEXT KEY `idx_search_ko` (`search_ko`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
