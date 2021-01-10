-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 09, 2021 at 08:31 PM
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
-- Table structure for table `quests`
--

DROP TABLE IF EXISTS `quests`;
CREATE TABLE IF NOT EXISTS `quests` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `category2` text,
  `minlevel_permitted` text,
  `dev_name` text,
  `f_mission` text,
  `category1` text,
  `description` text,
  `race_permitted` text,
  `search_ko` text,
  `search_en` text,
  `search_de` text,
  `search_fr` text,
  `search_it` text,
  `search_pl` text,
  `search_es` text,
  `search_us` text,
  `client_version` char(25) DEFAULT NULL,
  `reward_exp1` text,
  `gender_permitted` text,
  `client_level` text,
  `max_repeat_count` text,
  `maxlevel_permitted` text,
  `class_permitted` text,
  `bm_restrict_category` text,
  `reward_gold1` text,
  `mgrouptag` text,
  `cannot_share` text,
  `__type_desc__` text,
  `cannot_giveup` text,
  `collect_item1` text,
  `collect_progress` text,
  `drop_prob_1` text,
  `drop_each_member_1` tinyint(1) DEFAULT NULL,
  `drop_monster_1` text,
  `drop_item_1` text,
  `selectable_reward_item1_3` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_2` varchar(255) DEFAULT NULL,
  `check_item1_1` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_1` varchar(255) DEFAULT NULL,
  `reward_title1` varchar(255) DEFAULT NULL,
  `drop_prob_2` int DEFAULT NULL,
  `drop_each_member_2` tinyint(1) DEFAULT NULL,
  `drop_monster_2` text,
  `selectable_reward_item1_4` varchar(255) DEFAULT NULL,
  `drop_item_2` text,
  `reward_exp2` int DEFAULT NULL,
  `reward_exp3` int DEFAULT NULL,
  `reward_exp4` int DEFAULT NULL,
  `selectable_reward_item4_2` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_3` varchar(255) DEFAULT NULL,
  `selectable_reward_item3_2` varchar(255) DEFAULT NULL,
  `selectable_reward_item4_1` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_2` varchar(255) DEFAULT NULL,
  `selectable_reward_item3_1` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_1` varchar(255) DEFAULT NULL,
  `use_class_reward` int DEFAULT NULL,
  `reward_item1_1` varchar(255) DEFAULT NULL,
  `reward_item1_3` varchar(255) DEFAULT NULL,
  `reward_item1_2` varchar(255) DEFAULT NULL,
  `collect_item2` varchar(255) DEFAULT NULL,
  `drop_prob_3` int DEFAULT NULL,
  `drop_monster_3` text,
  `drop_item_3` text,
  `drop_each_member_3` tinyint(1) DEFAULT NULL,
  `drop_prob_4` int DEFAULT NULL,
  `drop_each_member_4` tinyint(1) DEFAULT NULL,
  `drop_monster_4` text,
  `drop_item_4` text,
  `finished_quest_cond1` varchar(255) DEFAULT NULL,
  `reward_gold2` int DEFAULT NULL,
  `reward_item2_1` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_7` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_6` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_5` varchar(255) DEFAULT NULL,
  `collect_item3` varchar(255) DEFAULT NULL,
  `collect_item4` varchar(255) DEFAULT NULL,
  `check_item1_4` varchar(255) DEFAULT NULL,
  `check_item1_2` varchar(255) DEFAULT NULL,
  `check_item1_3` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_8` varchar(255) DEFAULT NULL,
  `reward_abyss_point1` int DEFAULT NULL,
  `reward_item1_4` varchar(255) DEFAULT NULL,
  `quest_work_item1` varchar(255) DEFAULT NULL,
  `quest_work_item2` varchar(255) DEFAULT NULL,
  `quest_work_item3` varchar(255) DEFAULT NULL,
  `quest_work_item4` varchar(255) DEFAULT NULL,
  `reward_title2` varchar(255) DEFAULT NULL,
  `reward_gold3` int DEFAULT NULL,
  `reward_item3_1` varchar(255) DEFAULT NULL,
  `quest_repeat_cycle` varchar(4) DEFAULT NULL,
  `reward_gold4` int DEFAULT NULL,
  `extra_category` varchar(15) DEFAULT NULL,
  `inventory_item_name1` varchar(255) DEFAULT NULL,
  `check_item2_1` varchar(255) DEFAULT NULL,
  `acquired_quest_cond1` varchar(255) DEFAULT NULL,
  `reward_item_ext_1` varchar(255) DEFAULT NULL,
  `reward_gold_ext` int DEFAULT NULL,
  `reward_repeat_count` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `reward_item4_1` varchar(255) DEFAULT NULL,
  `check_item4_1` varchar(255) DEFAULT NULL,
  `inventory_item_name2` varchar(255) DEFAULT NULL,
  `check_item3_1` varchar(255) DEFAULT NULL,
  `knight_selectable_reward` text,
  `chanter_selectable_reward` text,
  `fighter_selectable_reward` text,
  `assassin_selectable_reward` text,
  `ranger_selectable_reward` text,
  `priest_selectable_reward` text,
  `elementalist_selectable_reward` text,
  `wizard_selectable_reward` text,
  `selectable_reward_item_ext_2` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_1` varchar(255) DEFAULT NULL,
  `selectable_reward_item3_4` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_4` varchar(255) DEFAULT NULL,
  `selectable_reward_item3_3` varchar(255) DEFAULT NULL,
  `reward_title_ext` varchar(255) DEFAULT NULL,
  `abyss_rank` int DEFAULT NULL,
  `target_type` varchar(6) DEFAULT NULL,
  `reward_abyss_point2` int DEFAULT NULL,
  `reward_extend_inventory1` int DEFAULT NULL,
  `reward_abyss_point3` int DEFAULT NULL,
  `finished_quest_cond3` varchar(255) DEFAULT NULL,
  `finished_quest_cond2` varchar(255) DEFAULT NULL,
  `inventory_item_name3` varchar(255) DEFAULT NULL,
  `reward_abyss_point4` int DEFAULT NULL,
  `equiped_item_name5` text,
  `equiped_item_name3` text,
  `equiped_item_name4` text,
  `equiped_item_name1` text,
  `equiped_item_name2` text,
  `unfinished_quest_cond5` varchar(255) DEFAULT NULL,
  `unfinished_quest_cond3` varchar(255) DEFAULT NULL,
  `unfinished_quest_cond4` varchar(255) DEFAULT NULL,
  `unfinished_quest_cond1` varchar(255) DEFAULT NULL,
  `unfinished_quest_cond2` varchar(255) DEFAULT NULL,
  `selectable_reward_item4_5` varchar(255) DEFAULT NULL,
  `selectable_reward_item3_5` varchar(255) DEFAULT NULL,
  `selectable_reward_item4_4` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_5` varchar(255) DEFAULT NULL,
  `selectable_reward_item4_3` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_8` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_7` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_6` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_5` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_4` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_3` varchar(255) DEFAULT NULL,
  `reward_item_ext_2` varchar(255) DEFAULT NULL,
  `finished_quest_cond4` varchar(255) DEFAULT NULL,
  `selectable_reward_item2_6` varchar(255) DEFAULT NULL,
  `reward_extend_stigma1` tinyint(1) DEFAULT NULL,
  `combineskill` varchar(20) DEFAULT NULL,
  `finished_quest_cond5` varchar(255) DEFAULT NULL,
  `combine_skillpoint` int DEFAULT NULL,
  `recipe_name` varchar(255) DEFAULT NULL,
  `npcfaction_name` varchar(30) DEFAULT NULL,
  `package_permitted` int DEFAULT NULL,
  `selectable_reward_item1_10` varchar(255) DEFAULT NULL,
  `selectable_reward_item1_9` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_10` varchar(255) DEFAULT NULL,
  `selectable_reward_item_ext_9` varchar(255) DEFAULT NULL,
  `noacquired_quest_cond2` text,
  `noacquired_quest_cond1` text,
  `noacquired_quest_cond4` text,
  `noacquired_quest_cond3` text,
  `noacquired_quest_cond5` text,
  `mentor_quest_type` int DEFAULT NULL,
  `acquired_quest_cond2` text,
  `pcguild_level` int DEFAULT NULL,
  `reward_item_ext_3` varchar(255) DEFAULT NULL,
  `reward_item_ext_4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `idx_client_version` (`client_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quests`
--
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_us` (`search_us`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_es` (`search_es`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_pl` (`search_pl`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_it` (`search_it`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_fr` (`search_fr`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_de` (`search_de`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_en` (`search_en`);
ALTER TABLE `quests` ADD FULLTEXT KEY `idx_search_ko` (`search_ko`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
