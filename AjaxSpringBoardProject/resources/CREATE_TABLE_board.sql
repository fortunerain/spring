CREATE TABLE `board` (
  `seq` int(11) NOT NULL DEFAULT '1',
  `title` varchar(45) DEFAULT NULL,
  `writer` varchar(45) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `regDate` datetime DEFAULT NULL,
  `cnt` int(11) DEFAULT '0',
  `searchCondition` varchar(45) DEFAULT NULL,
  `searchKeyword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
