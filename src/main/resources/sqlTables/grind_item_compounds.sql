-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 01:16 PM
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
-- Table structure for table `grind_item_compounds`
--

DROP TABLE IF EXISTS `grind_item_compounds`;
CREATE TABLE IF NOT EXISTS `grind_item_compounds` (
                                                      `id` int NOT NULL,
                                                      `name` varchar(255) NOT NULL,
    `compound_fee` int DEFAULT NULL,
    `grind_item_category` text,
    `result_grind_item_example` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `job` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`),
    KEY `result_grind_item_example` (`result_grind_item_example`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
