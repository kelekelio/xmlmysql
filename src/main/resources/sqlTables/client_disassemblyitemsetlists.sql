DROP TABLE IF EXISTS `client_disassemblyitemsetlists`;
CREATE TABLE IF NOT EXISTS `client_disassemblyitemsetlists` (
                                                                `id` int NOT NULL,
                                                                `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;