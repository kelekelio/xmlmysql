CREATE TABLE `client_combine_recipes_combine_recipe_expansion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `component_quantity` int DEFAULT NULL,
  `component1` text,
  `compo1_quantity` int DEFAULT NULL,
  `component2` text,
  `compo2_quantity` int DEFAULT NULL,
  `component3` text,
  `compo3_quantity` int DEFAULT NULL,
  `component4` text,
  `compo4_quantity` int DEFAULT NULL,
  `component5` text,
  `compo5_quantity` int DEFAULT NULL,
  `component6` text,
  `compo6_quantity` int DEFAULT NULL,
  `component7` text,
  `compo7_quantity` int DEFAULT NULL,
  `component8` text,
  `compo8_quantity` int DEFAULT NULL,
  `component9` text,
  `compo9_quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
