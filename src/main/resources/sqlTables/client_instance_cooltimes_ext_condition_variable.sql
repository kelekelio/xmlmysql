CREATE TABLE IF NOT EXISTS `client_instance_cooltimes_ext_condition_variable` (
                                                                                  `id` int NOT NULL AUTO_INCREMENT,
                                                                                  `name` varchar(255) NOT NULL,
    `variable` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;