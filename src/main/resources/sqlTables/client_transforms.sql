CREATE TABLE IF NOT EXISTS `client_transforms` (
                                                   `id` int NOT NULL,
                                                   `name` varchar(255) NOT NULL,
    `preview_mesh` text,
    `compose_value` int DEFAULT NULL,
    `gender` text,
    `description` text,
    `icon_name` text,
    `desc_long` text,
    `grade_desc` text,
    `grade` int DEFAULT NULL,
    `skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `preview_dir` text,
    `motion_name_acq` text,
    `motion_name_idle` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;