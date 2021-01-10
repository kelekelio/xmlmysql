-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 09, 2021 at 08:25 PM
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
-- Table structure for table `npc_clients`
--

DROP TABLE IF EXISTS `npc_clients`;
CREATE TABLE IF NOT EXISTS `npc_clients` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `hpgauge_level` int DEFAULT NULL,
  `dir` text,
  `attack_delay` int DEFAULT NULL,
  `ui_type` varchar(50) DEFAULT NULL,
  `mesh` text,
  `hide_path` tinyint(1) DEFAULT NULL,
  `magical_skill_boost` int DEFAULT NULL,
  `tribe` text,
  `attack_range` decimal(9,6) DEFAULT NULL,
  `attack_rate` int DEFAULT NULL,
  `npc_type` varchar(50) DEFAULT NULL,
  `race_type` varchar(20) DEFAULT NULL,
  `disk_type` text,
  `game_lang` text,
  `npc_title` varchar(255) DEFAULT NULL,
  `ui_race_type` text,
  `undetectable` tinyint(1) DEFAULT NULL,
  `pc_type` text,
  `buy_price_rate` int DEFAULT NULL,
  `npc_function_type` text,
  `tab_list` text,
  `recovery_opt2` int DEFAULT NULL,
  `recovery_opt1` int DEFAULT NULL,
  `recovery` tinyint(1) DEFAULT NULL,
  `extra_currency_trade_info` text,
  `extendcharwarehouse_end` int DEFAULT NULL,
  `extendcharwarehouse_start` int DEFAULT NULL,
  `give_item_proc` tinyint(1) DEFAULT NULL,
  `remove_item_option` tinyint(1) DEFAULT NULL,
  `change_item_skin` tinyint(1) DEFAULT NULL,
  `gather_skill_levelup` text,
  `extendinventory_end` int DEFAULT NULL,
  `extendinventory_start` int DEFAULT NULL,
  `package_permitted` int DEFAULT NULL,
  `extendaccountwarehouse_start` int DEFAULT NULL,
  `extendaccountwarehouse_end` int DEFAULT NULL,
  `npcfaction_name` text,
  `abyss_trade_info` text,
  `guide_func` text,
  `sell_price_rate` int DEFAULT NULL,
  `pvpzone_world_name` text,
  `pvpzone` text,
  `pvpzone_location_alias` text,
  `edit_character_gender` tinyint(1) DEFAULT NULL,
  `edit_character_all` tinyint(1) DEFAULT NULL,
  `trade_in_trade_info` text,
  `func_itemcharge` text,
  `object_type` text,
  `str_type` text,
  `huge_mob` text,
  `visible_range` int DEFAULT NULL,
  `hide_pc_fx_shader` text,
  `spawn_animation` text,
  `artifact_id` text,
  `abyss_npc_type` text,
  `deadbody_name_id` text,
  `use_script` text,
  `match_maker` text,
  `rotation_period` text,
  `animation_marker` text,
  `bindstone_capacity` text,
  `bindstone_type` text,
  `bindstone_usecount` text,
  `check_can_see` text,
  `html_bg` varchar(255) DEFAULT NULL,
  `instance_entry` int DEFAULT NULL,
  `compound_weapon` int DEFAULT NULL,
  `coupon_trade_info` text,
  `func_pet_manage` int DEFAULT NULL,
  `arrange_rotation_side` tinyint(1) DEFAULT NULL,
  `arrange_rotation_updown` tinyint(1) DEFAULT NULL,
  `arrange_place` text,
  `arrange_midair` tinyint(1) DEFAULT NULL,
  `furniture_category` text,
  `trade_info` text,
  `ctab` text,
  `magical_skill_boost_resist` int DEFAULT NULL,
  `hide_map` tinyint(1) DEFAULT NULL,
  `except_autohunt` tinyint(1) DEFAULT NULL,
  `exclusion_list` tinyint(1) DEFAULT NULL,
  `scaling_drop` text,
  `massive_looting_item` text,
  `massive_looting_num` int DEFAULT NULL,
  `massive_looting_min_level` int DEFAULT NULL,
  `massive_looting_max_level` int DEFAULT NULL,
  `can_talk_invisible` tinyint(1) DEFAULT NULL,
  `unrotatable` tinyint(1) DEFAULT NULL,
  `func_giveup_craftskill` text,
  `ap_buy_price_rate2` text,
  `abyss_trade_buy_info` text,
  `func_itemcharge2` text,
  `item_replace` text,
  `custom_match_maker` text,
  `subdialog_type` text,
  `tab` text,
  `subdialog_value2` text,
  `subdialog_value` text,
  `func_enterhouse_to_instant` text,
  `ins_creation_id_1` text,
  `ins_creation_id_2` text,
  `sell_price_rate2` text,
  `ap_sell_price_rate2` text,
  `ap_sell_price_rate` text,
  `abyss_qina_trade_info` text,
  `buy_tab` text,
  `buy_price_rate2` text,
  `trade_buy_info` text,
  `ap_buy_price_rate` text,
  `item_upgrade` text,
  `itemcharge_rate` text,
  `func_recreate_personal_ins` tinyint(1) DEFAULT NULL,
  `vip_grade_max` text,
  `vip_grade_min` text,
  `event_tool_trade_info` text,
  `stare_distance` decimal(9,6) DEFAULT NULL,
  `search_ko` text,
  `search_en` text,
  `search_de` text,
  `search_fr` text,
  `search_it` text,
  `search_pl` text,
  `search_es` text,
  `search_us` text,
  `client_version` char(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `idx_client_version` (`client_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `npc_clients`
--
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_us` (`search_us`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_es` (`search_es`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_pl` (`search_pl`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_it` (`search_it`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_fr` (`search_fr`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_de` (`search_de`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_en` (`search_en`);
ALTER TABLE `npc_clients` ADD FULLTEXT KEY `idx_search_ko` (`search_ko`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
