DROP TABLE IF EXISTS `client_housing_custom_parts`;
CREATE TABLE IF NOT EXISTS `client_housing_custom_parts` (
                                                             `id` int NOT NULL,
                                                             `name` varchar(255) NOT NULL,
    `filename` text,
    `color` text,
    `description` text,
    `dir` text,
    `type` text,
    `icon_name` text,
    `quality` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;