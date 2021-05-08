CREATE TABLE IF NOT EXISTS `client_reinvent_packages_candidate_list` (
                                                                         `id` int NOT NULL AUTO_INCREMENT,
                                                                         `name` varchar(255) NOT NULL,
    `grade` int DEFAULT NULL,
    `candidate_name` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;