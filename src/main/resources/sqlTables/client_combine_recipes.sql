CREATE TABLE `client_combine_recipes` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `combineskill` varchar(15) DEFAULT NULL,
  `qualification_race` varchar(10) DEFAULT NULL,
  `required_skillpoint` int(5) DEFAULT NULL,
  `auto_learn` int(1) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `product_quantity` int(3) DEFAULT NULL,
  `require_dp` int(4) DEFAULT NULL,
  `max_production_count` int(3) DEFAULT NULL,
  `desc_craftman` varchar(255) DEFAULT NULL,
  `craft_delay_id` int(6) DEFAULT NULL,
  `craft_delay_time` int(10) DEFAULT NULL,
  `task_type` int(1) DEFAULT NULL,
  `combo1_product` TEXT,
  `combo2_product` TEXT,
  `combo3_product` TEXT,
  `combo4_product` TEXT,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;