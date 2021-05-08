CREATE TABLE IF NOT EXISTS `client_instance_cooltimes_ui_gauge` (
                                                                    `id` int NOT NULL AUTO_INCREMENT,
                                                                    `name` varchar(255) NOT NULL,
    `ui_gauge_max` text,
    `ui_gauge_title` text,
    `ui_gauge_desc` text,
    `ui_gauge_unit_color` text,
    `ui_gauge_unit_desc` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;