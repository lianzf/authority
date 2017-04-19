# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.15)
# Database: authority
# Generation Time: 2017-04-18 06:28:32 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_sys_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_resource`;

CREATE TABLE `t_sys_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `res_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `res_string` varchar(100) DEFAULT NULL COMMENT '资源串',
  `parent_id` int(11) DEFAULT NULL COMMENT '父ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# Dump of table t_sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL COMMENT '用户角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_sys_role` WRITE;
/*!40000 ALTER TABLE `t_sys_role` DISABLE KEYS */;

INSERT INTO `t_sys_role` (`id`, `role_name`, `role_desc`)
VALUES
	(1,'超级管理员','超级管理员');

/*!40000 ALTER TABLE `t_sys_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_role_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role_resource`;

CREATE TABLE `t_sys_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `res_id` int(11) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_sys_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_account` varchar(30) DEFAULT '' COMMENT '用户登录账号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户显示名称',
  `password` varchar(50) DEFAULT NULL COMMENT '用户登录密码',
  `status` int(2) DEFAULT NULL COMMENT '用户状态0-无效；1-有效；',
  `login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_sys_user` WRITE;
/*!40000 ALTER TABLE `t_sys_user` DISABLE KEYS */;

INSERT INTO `t_sys_user` (`user_id`, `user_account`, `user_name`, `password`, `status`, `login_time`, `create_time`)
VALUES
	(1,'admin','超级管理员','admin',1,'2017-04-17 16:38:50',NULL);

/*!40000 ALTER TABLE `t_sys_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_sys_user_role` WRITE;
/*!40000 ALTER TABLE `t_sys_user_role` DISABLE KEYS */;

INSERT INTO `t_sys_user_role` (`id`, `user_id`, `role_id`)
VALUES
	(1,1,1);

/*!40000 ALTER TABLE `t_sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
