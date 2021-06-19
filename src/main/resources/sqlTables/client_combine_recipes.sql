-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 12:14 PM
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
-- Table structure for table `client_combine_recipes`
--

DROP TABLE IF EXISTS `client_combine_recipes`;
CREATE TABLE IF NOT EXISTS `client_combine_recipes` (
                                                        `id` int NOT NULL,
                                                        `name` varchar(255) NOT NULL,
    `description` varchar(255) DEFAULT NULL,
    `combineskill` varchar(15) DEFAULT NULL,
    `qualification_race` varchar(10) DEFAULT NULL,
    `required_skillpoint` int DEFAULT NULL,
    `auto_learn` int DEFAULT NULL,
    `product` varchar(255) DEFAULT NULL,
    `product_quantity` int DEFAULT NULL,
    `require_dp` int DEFAULT NULL,
    `max_production_count` int DEFAULT NULL,
    `desc_craftman` text CHARACTER SET utf8 COLLATE utf8_general_ci,
    `craft_delay_id` int DEFAULT NULL,
    `craft_delay_time` int DEFAULT NULL,
    `task_type` int DEFAULT NULL,
    `combo1_product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `combo2_product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `combo3_product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `combo4_product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`),
    KEY `combineskill` (`combineskill`),
    KEY `qualification_race` (`qualification_race`),
    KEY `required_skillpoint` (`required_skillpoint`),
    KEY `product` (`product`),
    KEY `combo1_product` (`combo1_product`),
    KEY `combo2_product` (`combo2_product`),
    KEY `combo3_product` (`combo3_product`),
    KEY `combo4_product` (`combo4_product`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
