-- --------------------------------------------------------
-- 主机:                           192.168.99.100
-- 服务器版本:                        5.7.14 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 operation 的数据库结构
CREATE DATABASE IF NOT EXISTS `operation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `operation`;


-- 导出  表 operation.resources 结构
CREATE TABLE IF NOT EXISTS `resources` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `parent_id` bigint(8) NOT NULL DEFAULT '0',
  `url` varchar(1000) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 正在导出表  operation.resources 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` (`id`, `name`, `description`, `parent_id`, `url`, `gmt_create`, `gmt_modified`) VALUES
	(1, '系统设置', '系统设置', 0, '#', '2016-07-26 02:41:46', '2016-08-05 07:08:03'),
	(2, '资源管理', '资源管理', 1, '#/system/resources', '2016-07-26 02:41:55', '2016-08-05 07:08:37'),
	(3, '角色管理', '角色管理', 1, '#/system/roles', '2016-07-26 02:42:05', '2016-08-05 07:09:00'),
	(4, '用户管理', '用户管理', 1, '#/system/users', '2016-07-26 02:42:14', '2016-08-05 07:09:27'),
	(18, '资讯管理', '资讯管理', 0, '#', '2016-08-05 07:21:13', '2016-08-05 07:21:13'),
	(19, '资讯', '资讯', 18, '#/system/roles', '2016-08-05 07:21:52', '2016-08-05 07:21:52');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;


-- 导出  表 operation.roles 结构
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET latin1 NOT NULL,
  `description` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  operation.roles 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`, `description`, `gmt_create`, `gmt_modified`) VALUES
	(1, 'system', 'miaoshu', '2016-07-27 01:45:14', '2016-07-27 01:55:00'),
	(2, 'admin', 'admin', '2016-07-27 01:45:14', '2016-07-27 01:55:14');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- 导出  表 operation.role_resource 结构
CREATE TABLE IF NOT EXISTS `role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(8) NOT NULL,
  `resource_id` bigint(8) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- 正在导出表  operation.role_resource 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` (`id`, `role_id`, `resource_id`, `gmt_create`, `gmt_modified`) VALUES
	(46, 1, 1, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(47, 1, 2, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(48, 1, 3, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(49, 1, 4, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(50, 1, 18, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(51, 1, 19, '2016-08-11 06:49:26', '2016-08-11 06:49:26'),
	(67, 2, 1, '2016-08-11 07:50:20', '2016-08-11 07:50:20'),
	(68, 2, 2, '2016-08-11 07:50:20', '2016-08-11 07:50:20'),
	(69, 2, 3, '2016-08-11 07:50:20', '2016-08-11 07:50:20'),
	(70, 2, 4, '2016-08-11 07:50:20', '2016-08-11 07:50:20'),
	(71, 2, 18, '2016-08-11 07:50:20', '2016-08-11 07:50:20'),
	(72, 2, 19, '2016-08-11 07:50:20', '2016-08-11 07:50:20');
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;


-- 导出  表 operation.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(200) CHARACTER SET latin1 NOT NULL,
  `login_name` varchar(200) CHARACTER SET latin1 NOT NULL,
  `mobile` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `gender` smallint(2) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  operation.sys_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `user_name`, `password`, `login_name`, `mobile`, `email`, `gender`, `gmt_create`, `gmt_modified`) VALUES
	(2, 'meikebo', 'ddd123', 'meikebo', '18501600702', 'email@google.com', 1, '2016-07-26 09:37:56', '2016-07-27 02:11:16'),
	(9, 'zhoubo', 'b', 'zhoubo', 'zb', 'aa', 1, '2016-08-05 06:52:25', '2016-08-10 08:51:21');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 operation.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(8) NOT NULL,
  `role_id` bigint(8) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  operation.user_role 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`, `gmt_create`, `gmt_modified`) VALUES
	(1, 1, 1, '2016-08-05 02:00:44', '2016-08-05 02:00:44'),
	(2, 1, 2, '2016-08-05 02:00:44', '2016-08-05 02:00:44'),
	(3, 1, 3, '2016-08-05 02:00:44', '2016-08-05 02:00:44'),
	(10, 2, 1, '2016-08-05 04:36:56', '2016-08-05 04:36:56'),
	(16, 9, 2, '2016-08-11 07:49:58', '2016-08-11 07:49:58');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
