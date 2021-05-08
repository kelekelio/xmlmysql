CREATE TABLE IF NOT EXISTS `client_login_events` (
                                                     `id` int NOT NULL,
                                                     `name` varchar(255) NOT NULL,
    `attend_type` text,
    `active` tinyint(1) DEFAULT NULL,
    `attend_stamp_title` text,
    `attend_stamp_sub_title` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;