CREATE TABLE IF NOT EXISTS `client_quest_random_rewards` (
                                                             `id` int NOT NULL,
                                                             `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;