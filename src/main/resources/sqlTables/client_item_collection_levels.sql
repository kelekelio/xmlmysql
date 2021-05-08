CREATE TABLE IF NOT EXISTS `client_item_collection_levels` (
                                                               `id` int NOT NULL AUTO_INCREMENT,
                                                               `collection_exp` int DEFAULT NULL,
                                                               `collection_level` int DEFAULT NULL,
                                                               `collection_grade` text,
                                                               `reward_attr01` text,
                                                               `reward_attr02` text,
                                                               PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;