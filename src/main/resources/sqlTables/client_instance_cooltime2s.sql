CREATE TABLE IF NOT EXISTS `client_instance_cooltime2s` (
                                                            `id` int NOT NULL,
                                                            `name` varchar(255) NOT NULL,
    `quna_cost_step01` int DEFAULT NULL,
    `maxcount` int DEFAULT NULL,
    `typevalue` text,
    `quna_cycle` int DEFAULT NULL,
    `type` text,
    `value` int DEFAULT NULL,
    `quna_cost_step04` int DEFAULT NULL,
    `quna_cost_step03` int DEFAULT NULL,
    `quna_cost_step02` int DEFAULT NULL,
    `luna_cost` text,
    `extra_count_buildup_level` int DEFAULT NULL,
    `extra_count_buildup` int DEFAULT NULL,
    `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `component_count` int DEFAULT NULL,
    `price` int DEFAULT NULL,
    `priceincrease` int DEFAULT NULL,
    `pricemaxcount` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;