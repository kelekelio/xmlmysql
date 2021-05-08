CREATE TABLE IF NOT EXISTS `robots` (
                                        `id` int NOT NULL,
                                        `name` varchar(255) NOT NULL,
    `mesh_body` text,
    `default_color` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;