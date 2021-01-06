CREATE TABLE `zonemaps` (
  `id` int(9) NOT NULL,
  `name` text,
  `world_width` int(5) DEFAULT '0',
  `world_height` int(5) DEFAULT '0',
  `offset_x` int(5) DEFAULT '0',
  `offset_y` int(5) DEFAULT '0',
  `map_width` int(5) DEFAULT '0',
  `map_height` int(5) DEFAULT '0',
  `map_category` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
