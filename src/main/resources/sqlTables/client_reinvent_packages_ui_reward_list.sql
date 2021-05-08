CREATE TABLE IF NOT EXISTS `client_reinvent_packages_ui_reward_list` (
                                                                         `id` int NOT NULL AUTO_INCREMENT,
                                                                         `name` varchar(255) NOT NULL,
    `ui_reward_grade` text,
    `ui_reward_tab_str` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;