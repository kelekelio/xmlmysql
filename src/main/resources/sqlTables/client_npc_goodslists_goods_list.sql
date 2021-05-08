CREATE TABLE IF NOT EXISTS `client_npc_goodslists_goods_list` (
                                                                  `id` int NOT NULL AUTO_INCREMENT,
                                                                  `name` varchar(255) NOT NULL,
    `item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `sell_limit` int DEFAULT NULL,
    `buy_limit` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;