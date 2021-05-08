CREATE TABLE IF NOT EXISTS `client_item_skill_enhances` (
                                                            `id` int NOT NULL,
                                                            `name` varchar(255) NOT NULL,
    `enchant_prob` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;