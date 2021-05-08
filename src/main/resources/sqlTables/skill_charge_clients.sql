CREATE TABLE IF NOT EXISTS `skill_charge_clients` (
                                                      `id` int NOT NULL,
                                                      `name` varchar(255) NOT NULL,
    `skill_name1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `skill_name2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `skill_name3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `move_charge` tinyint(1) DEFAULT NULL,
    `charge_time_bonus_type` text,
    `charge_time3` int DEFAULT NULL,
    `charge_time2` int DEFAULT NULL,
    `charge_time1` int DEFAULT NULL,
    `min_charge_time` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;