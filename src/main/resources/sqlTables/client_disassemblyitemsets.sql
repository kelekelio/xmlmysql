DROP TABLE IF EXISTS `client_disassemblyitemsets`;
CREATE TABLE IF NOT EXISTS `client_disassemblyitemsets` (
                                                            `id` int NOT NULL,
                                                            `name` varchar(255) NOT NULL,
    `slot_effect` int DEFAULT NULL,
    `retry_max_count` int DEFAULT NULL,
    `per_retry` int DEFAULT NULL,
    `per_retry_rate` decimal(8,6) DEFAULT NULL,
    `per_type` text,
    `component_per_retry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `component_per_retry_count` int DEFAULT NULL,
    `component_per_retry_type` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;