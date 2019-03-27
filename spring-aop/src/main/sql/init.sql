DROP TABLE IF EXISTS `account`;
CREATE TABLE account(
  id INT(11)  NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) DEFAULT '',
  money DOUBLE    DEFAULT 0.0,
  PRIMARY KEY (`id`)
);


insert into account (name,money) values ('老公',1000.2);
insert into account (name,money) values ('老婆',0.8);
