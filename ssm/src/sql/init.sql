drop table if EXISTS `item`;
create table `item`(
	`id` int(11) not null auto_increment,
	`name` VARCHAR(20) DEFAULT '',
	`price` FLOAT DEFAULT 0,
	`pic` VARCHAR(100) DEFAULT '',
	`createtime` DATE,
	`detail` VARCHAR(100),
	PRIMARY KEY (`id`)
);
insert into item (`id`,name,price,pic,`createtime`,detail) values
 (1,'nick',1.2,'','2018-09-12 10:00:00','我不知道')



drop table if EXISTS `orders`;
create table `orders`(
	`id` int(11) not null auto_increment,
	`userId` int(11)  DEFAULT 0,
	`number` VARCHAR(20) DEFAULT '',
	`createtime` DATE,
	`note` VARCHAR(100) DEFAULT '',
	PRIMARY KEY (`id`)
);


drop table if EXISTS `user`;
create table `user`(
	`id` int(11) not null auto_increment,
	`username` VARCHAR(20) DEFAULT '',
	`birthday` DATE,
	`sex` VARCHAR(2) DEFAULT '',
	`address` VARCHAR(100) DEFAULT '',
	PRIMARY KEY (`id`)
);