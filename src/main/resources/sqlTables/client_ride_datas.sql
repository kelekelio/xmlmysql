CREATE TABLE `client_ride_datas` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `guild_color` text,
  `fly_speed` text,
  `cost_fp` text,
  `altitude` text,
  `side` text,
  `motion` text,
  `bound_radius` text,
  `upper` text,
  `can_sprint` text,
  `camera_offset` text,
  `erect` text,
  `ride_type` text,
  `move_speed` text,
  `sprint_speed` text,
  `start_fp` text,
  `front` text,
  `mesh` text,
  `foot_mat` text,
  `default_color` text,
  `visible_equipments` text,
  `emblem2` text,
  `emblem1` text,
  `wing_mesh` text,
  `scale` text,
  `ride_bone` text,
  `skill` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;