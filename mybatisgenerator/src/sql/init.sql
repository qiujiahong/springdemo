CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '',
  `money` double DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_key` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `dept` (
  `DEPTNO` bigint(20) NOT NULL AUTO_INCREMENT,
  `DNAME` char(20) DEFAULT '',
  `LOC` varchar(50) DEFAULT '',
  `FLAG` int(1) DEFAULT '0',
  PRIMARY KEY (`DEPTNO`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE `emp` (
  `EMPNO` bigint(20) NOT NULL AUTO_INCREMENT,
  `ENAME` varchar(20) DEFAULT '',
  `JOB` varchar(20) DEFAULT '',
  `MGR` int(11) DEFAULT '0',
  `SAL` double(10,2) DEFAULT '0.00',
  `COMM` double(10,2) DEFAULT '0.00',
  `DEPNO` bigint(21) DEFAULT '0',
  `hireDate` date DEFAULT NULL,
  PRIMARY KEY (`EMPNO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;