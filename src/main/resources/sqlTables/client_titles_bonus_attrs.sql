CREATE TABLE IF NOT EXISTS `client_titles_bonus_attrs` (
                                                           `id` int NOT NULL AUTO_INCREMENT,
                                                           `name` varchar(255) NOT NULL,
    `bonus_attr` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;