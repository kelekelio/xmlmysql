CREATE TABLE IF NOT EXISTS `quest_data_drivens_progress_info` (
                                                                  `id` int NOT NULL AUTO_INCREMENT,
                                                                  `name` varchar(255) NOT NULL,
    `category_progress_` text,
    `value0_progress_` text,
    `value1_progress_` text,
    `value2_progress_` text,
    `value3_progress_` text,
    `value4_progress_` text,
    `value5_progress_` text,
    `value6_progress_` text,
    `value7_progress_` text,
    `value9_progress_` text,
    `value8_progress_` text,
    `value10_progress_` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;