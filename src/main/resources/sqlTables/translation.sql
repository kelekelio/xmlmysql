CREATE TABLE `translation` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `body` text,
  `LAN_EN` text,
  `LAN_DE` text,
  `LAN_FR` text,
  `LAN_ES` text,
  `LAN_IT` text,
  `LAN_PL` text,
  `LAN_KO` text,
  `LAN_US` text,
  `LAN_CN` text,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
