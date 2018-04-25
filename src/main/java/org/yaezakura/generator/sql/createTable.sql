CREATE TABLE `compliant` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `compliantnumber` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `source` int(8) DEFAULT NULL,
  `createuser` varchar(255) NOT NULL,
  `createdate` datetime NOT NULL,
  `optional` varchar(255) NOT NULL DEFAULT '1',
  `checkmode` varchar(255) NOT NULL DEFAULT '1',
  `ScriptType` varchar(255) DEFAULT 'shell',
  `scriptcontext` text,
  `plantform` int(8) NOT NULL,
  `expect_result` text,
  `node_type` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8