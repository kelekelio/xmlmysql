-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 11:56 AM
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
-- Table structure for table `client_combine_recipes_combine_recipe_expansion`
--

DROP TABLE IF EXISTS `client_combine_recipes_combine_recipe_expansion`;
CREATE TABLE IF NOT EXISTS `client_combine_recipes_combine_recipe_expansion` (
                                                                                 `id` int NOT NULL AUTO_INCREMENT,
                                                                                 `name` varchar(255) NOT NULL,
    `component_quantity` int DEFAULT NULL,
    `component1` varchar(255) DEFAULT NULL,
    `compo1_quantity` int DEFAULT NULL,
    `component2` varchar(255) DEFAULT NULL,
    `compo2_quantity` int DEFAULT NULL,
    `component3` varchar(255) DEFAULT NULL,
    `compo3_quantity` int DEFAULT NULL,
    `component4` varchar(255) DEFAULT NULL,
    `compo4_quantity` int DEFAULT NULL,
    `component5` varchar(255) DEFAULT NULL,
    `compo5_quantity` int DEFAULT NULL,
    `component6` varchar(255) DEFAULT NULL,
    `compo6_quantity` int DEFAULT NULL,
    `component7` varchar(255) DEFAULT NULL,
    `compo7_quantity` int DEFAULT NULL,
    `component8` varchar(255) DEFAULT NULL,
    `compo8_quantity` int DEFAULT NULL,
    `component9` varchar(255) DEFAULT NULL,
    `compo9_quantity` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`),
    KEY `component1` (`component1`),
    KEY `component2` (`component2`),
    KEY `component3` (`component3`),
    KEY `component4` (`component4`),
    KEY `component5` (`component5`),
    KEY `component6` (`component6`),
    KEY `component7` (`component7`),
    KEY `component8` (`component8`),
    KEY `component9` (`component9`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
