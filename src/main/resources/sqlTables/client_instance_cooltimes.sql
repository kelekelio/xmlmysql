CREATE TABLE `client_instance_cooltimes` (
  `id` int(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `race` varchar(5) DEFAULT NULL,
  `max_member_dark` int(3) DEFAULT NULL,
  `can_enter_mentor` tinyint(1) DEFAULT NULL,
  `enter_min_level_dark` int(3) DEFAULT NULL,
  `enter_min_level_light` int(3) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `trial_ent_cool_time` int(10) DEFAULT NULL,
  `max_member_light` int(3) DEFAULT NULL,
  `resurrection_alias_1` varchar(255) DEFAULT NULL,
  `bm_restrict_category` int(1) DEFAULT NULL,
  `ent_cool_time` int(10) DEFAULT NULL,
  `exit_world_1` varchar(255) DEFAULT NULL,
  `exit_world_2` varchar(255) DEFAULT NULL,
  `exit_alias_1` varchar(255) DEFAULT NULL,
  `exit_alias_2` varchar(255) DEFAULT NULL,
  `resurrection_alias_2` varchar(255) DEFAULT NULL,
  `share_max_member` int(1) DEFAULT NULL,
  `enter_max_level_light` int(3) DEFAULT NULL,
  `enter_max_level_dark` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;