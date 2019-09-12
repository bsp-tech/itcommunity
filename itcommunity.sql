-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table itcommunity.auth_group
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE IF NOT EXISTS `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.auth_group: ~2 rows (approximately)
/*!40000 ALTER TABLE `auth_group` DISABLE KEYS */;
INSERT INTO `auth_group` (`id`, `name`) VALUES
	(1, 'ADMIN'),
	(2, 'CLIENT');
/*!40000 ALTER TABLE `auth_group` ENABLE KEYS */;

-- Dumping structure for table itcommunity.auth_group_role
DROP TABLE IF EXISTS `auth_group_role`;
CREATE TABLE IF NOT EXISTS `auth_group_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`) USING BTREE,
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`group_id`) USING BTREE,
  CONSTRAINT `auth_group_role_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  CONSTRAINT `auth_group_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.auth_group_role: ~0 rows (approximately)
/*!40000 ALTER TABLE `auth_group_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group_role` ENABLE KEYS */;

-- Dumping structure for table itcommunity.auth_role
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE IF NOT EXISTS `auth_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.auth_role: ~2 rows (approximately)
/*!40000 ALTER TABLE `auth_role` DISABLE KEYS */;
INSERT INTO `auth_role` (`id`, `name`, `insert_date_time`, `last_update_time`) VALUES
	(1, 'ADMIN', '2019-05-09 00:00:00', '2019-05-09 00:00:00'),
	(2, 'CLIENT', '2019-05-09 00:00:00', '2019-05-09 00:00:00');
/*!40000 ALTER TABLE `auth_role` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_profile
DROP TABLE IF EXISTS `employee_profile`;
CREATE TABLE IF NOT EXISTS `employee_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` tinyint(4) NOT NULL,
  `approved_date_time` datetime DEFAULT NULL,
  `cv_path` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `github_path` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `is_looking_for_work` tinyint(4) NOT NULL,
  `is_working` tinyint(4) NOT NULL,
  `linkedin_path` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL,
  `about` varchar(255) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `experience` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK5s5kad0xi8m49gscqaxjq2hcw` (`user_id`) USING BTREE,
  CONSTRAINT `employee_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.employee_profile: ~5 rows (approximately)
/*!40000 ALTER TABLE `employee_profile` DISABLE KEYS */;
INSERT INTO `employee_profile` (`id`, `approved`, `approved_date_time`, `cv_path`, `github_path`, `is_looking_for_work`, `is_working`, `linkedin_path`, `user_id`, `insert_date_time`, `last_update_date_time`, `about`, `speciality`, `experience`) VALUES
	(1, 1, '2019-09-10 22:52:06', 'asd', 'asb', 0, 1, 'asdf', 1, '2019-09-06 22:52:34', '2019-09-07 02:42:16', 'lorem', 'developer', 0),
	(4, 1, '2019-09-12 10:22:11', 'aaaa', 'aaaaa', 1, 1, 'aaaaa', 1, '2019-09-12 10:22:11', '2019-09-12 10:22:11', 'asadasdads', 'bbbbbb', 0),
	(7, 1, '2019-09-12 10:30:01', 'aaaaaaaaaaaaaaaa', 'aaaaaaaaaa', 1, 1, 'aaaaaaaaaa', 1, '2019-09-12 10:30:01', '2019-09-12 10:30:01', 'asadasdads', 'bbbbbb', 0),
	(8, 1, '2019-09-12 15:04:51', 'cv Path', 'github', 1, 1, 'linkedin', 1, '2019-09-12 15:04:51', '2019-09-12 15:04:51', 'aboutttttttttttttttt', 'speciality', 0),
	(9, 1, '2019-09-12 16:02:34', 'zzz', 'xxxxx', 1, 1, 'ccccc', 1, '2019-09-12 16:02:34', '2019-09-12 16:02:34', 'xcdxvdvdv', 'bbbbbb', 1);
/*!40000 ALTER TABLE `employee_profile` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_profile_language
DROP TABLE IF EXISTS `employee_profile_language`;
CREATE TABLE IF NOT EXISTS `employee_profile_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `insert_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKs4muhk6x4j4tkxqb1odmnfj7m` (`employee_profile_id`) USING BTREE,
  KEY `FK9wagkcbieklokxxyeeo3e69tq` (`language_id`) USING BTREE,
  CONSTRAINT `employee_profile_language_ibfk_1` FOREIGN KEY (`employee_profile_id`) REFERENCES `employee_profile` (`id`),
  CONSTRAINT `employee_profile_language_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.employee_profile_language: ~7 rows (approximately)
/*!40000 ALTER TABLE `employee_profile_language` DISABLE KEYS */;
INSERT INTO `employee_profile_language` (`id`, `level`, `employee_profile_id`, `language_id`, `insert_date_time`, `last_update_date_time`) VALUES
	(7, 10, 7, 1, '2019-09-12 10:30:01', NULL),
	(8, 9, 7, 2, '2019-09-12 10:30:01', NULL),
	(9, 8, 7, 3, '2019-09-12 10:30:01', NULL),
	(10, 9, 8, 2, '2019-09-12 15:04:51', NULL),
	(11, 10, 8, 3, '2019-09-12 15:04:51', NULL);
/*!40000 ALTER TABLE `employee_profile_language` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_profile_skill
DROP TABLE IF EXISTS `employee_profile_skill`;
CREATE TABLE IF NOT EXISTS `employee_profile_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `insert_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKi0g6h7113kqhy19m5xqu34jhf` (`employee_profile_id`) USING BTREE,
  KEY `FK6vt32pmm7jwvo7yndis5k9395` (`skill_id`) USING BTREE,
  CONSTRAINT `employee_profile_skill_ibfk_1` FOREIGN KEY (`employee_profile_id`) REFERENCES `employee_profile` (`id`),
  CONSTRAINT `employee_profile_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.employee_profile_skill: ~3 rows (approximately)
/*!40000 ALTER TABLE `employee_profile_skill` DISABLE KEYS */;
INSERT INTO `employee_profile_skill` (`id`, `level`, `employee_profile_id`, `skill_id`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 10, 7, 1, '2019-09-12 10:30:01', NULL),
	(2, 9, 7, 2, '2019-09-12 10:30:01', NULL),
	(3, 5, 8, 2, '2019-09-12 15:04:51', NULL);
/*!40000 ALTER TABLE `employee_profile_skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_project
DROP TABLE IF EXISTS `employee_project`;
CREATE TABLE IF NOT EXISTS `employee_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` smallint(6) NOT NULL,
  `position` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `join_date_time` datetime NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKpdp6ekpc8854dn4mebe7d1sdj` (`employee_id`) USING BTREE,
  KEY `FKhi5ffkj0w09uieki7lhiop2ub` (`project_id`) USING BTREE,
  CONSTRAINT `employee_project_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_profile` (`id`),
  CONSTRAINT `employee_project_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `itproject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.employee_project: ~1 rows (approximately)
/*!40000 ALTER TABLE `employee_project` DISABLE KEYS */;
INSERT INTO `employee_project` (`id`, `approved`, `position`, `employee_id`, `project_id`, `join_date_time`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 1, 'developer', 1, 1, '2019-09-02 22:55:41', '2019-09-03 22:55:48', '2019-09-06 23:18:14');
/*!40000 ALTER TABLE `employee_project` ENABLE KEYS */;

-- Dumping structure for table itcommunity.gender
DROP TABLE IF EXISTS `gender`;
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.gender: ~2 rows (approximately)
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` (`id`, `name`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 'male', '2019-09-05 14:57:41', NULL),
	(2, 'female', '2019-09-05 14:57:51', NULL);
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;

-- Dumping structure for table itcommunity.itproject
DROP TABLE IF EXISTS `itproject`;
CREATE TABLE IF NOT EXISTS `itproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `about` longtext NOT NULL,
  `github_path` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `in_development` tinyint(1) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `need_employee` tinyint(1) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `website_path` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `thumbnail` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.itproject: ~1 rows (approximately)
/*!40000 ALTER TABLE `itproject` DISABLE KEYS */;
INSERT INTO `itproject` (`id`, `about`, `github_path`, `in_development`, `name`, `need_employee`, `publish_date`, `website_path`, `thumbnail`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 'Bu proyekt IT sahəsində olan, hal-hazırda çalışan və ya çalışmayan hər kəsi eyni platforma altında cəmləyir. IT sahəsində olan şəxs özü haqqında qısa məlumat təsvir edir, hansı bacarıqları hansı səviyyədə bilir onu qeyd edir, cv-sini, linkedin profilini, hal-hazırda çalışıb çalışmadığını qeyd edir.\nBu proyekt ona imkan yaradacaq ki, hansısa şirkət və ya entrepreneur IT sahəsindən hər hansısa məqsədlə(işə göt', 'https://github.com/bsp-tech/itcommunity', 1, 'test', 1, '2019-09-16 22:56:38', 'https://github.com/bsp-tech/itcommunity', 'https://web-material3.yokogawa.com/f50b5c6f3b3ab4006f471295cdff5684f5afafe9.png', '2019-09-05 15:00:00', '2019-09-06 23:17:15');
/*!40000 ALTER TABLE `itproject` ENABLE KEYS */;

-- Dumping structure for table itcommunity.language
DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.language: ~3 rows (approximately)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` (`id`, `name`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 'English', '2019-09-07 02:20:46', NULL),
	(2, 'Russian', '2019-09-07 02:20:50', NULL),
	(3, 'Turkish', '2019-09-07 02:20:54', NULL);
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- Dumping structure for table itcommunity.project_skill
DROP TABLE IF EXISTS `project_skill`;
CREATE TABLE IF NOT EXISTS `project_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKebssgfcqvrsaxrs00sj0anbi9` (`project_id`) USING BTREE,
  KEY `FKrhm021cfqcutusb89uxtgyred` (`skill_id`) USING BTREE,
  CONSTRAINT `project_skill_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `itproject` (`id`),
  CONSTRAINT `project_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.project_skill: ~2 rows (approximately)
/*!40000 ALTER TABLE `project_skill` DISABLE KEYS */;
INSERT INTO `project_skill` (`id`, `project_id`, `skill_id`, `insert_date_time`, `last_update_date_time`) VALUES
	(1, 1, 1, '2019-05-09 00:00:00', NULL),
	(2, 1, 2, '2019-05-09 00:00:00', NULL);
/*!40000 ALTER TABLE `project_skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.skill
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `insert_date_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.skill: ~2 rows (approximately)
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` (`id`, `name`, `insert_date_time`, `last_update_time`) VALUES
	(1, 'Java', NULL, NULL),
	(2, 'Bootstrap', NULL, NULL);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET latin1 NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 NOT NULL,
  `surname` varchar(255) CHARACTER SET latin1 NOT NULL,
  `gender_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `insert_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `thumbnail` varchar(300) DEFAULT NULL,
  `avatar_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKcbf93j56y7t2tyhunb4neewva` (`gender_id`) USING BTREE,
  KEY `group_id` (`group_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table itcommunity.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `age`, `email`, `enabled`, `name`, `password`, `surname`, `gender_id`, `group_id`, `insert_date_time`, `last_update_date_time`, `thumbnail`, `avatar_path`) VALUES
	(1, 26, 'sarkhanrasullu@gmail.com', 1, 'Sarkhan', '111111', 'Rasullu', 1, 1, '2019-09-05 15:00:00', '2019-09-07 01:10:09', 'https://web-material3.yokogawa.com/f50b5c6f3b3ab4006f471295cdff5684f5afafe9.png', NULL),
	(2, 45, 'memmedli.jale93@gmail.com', 0, 'Jala', 'ihnfiushfis', 'Mammadli', 1, 2, '2019-09-07 20:57:52', '2019-09-12 16:13:04', NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
