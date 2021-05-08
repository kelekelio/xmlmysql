CREATE TABLE IF NOT EXISTS `client_npc_purchase_lists` (
                                                           `id` int NOT NULL,
                                                           `name` varchar(255) NOT NULL,
    `use_category` int DEFAULT NULL,
    `description` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;