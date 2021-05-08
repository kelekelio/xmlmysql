CREATE TABLE IF NOT EXISTS `polish_bonus_setlists` (
                                                       `id` int NOT NULL,
                                                       `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;