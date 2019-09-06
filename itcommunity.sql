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

-- Dumping structure for table itcommunity.employee_profile
DROP TABLE IF EXISTS `employee_profile`;
CREATE TABLE IF NOT EXISTS `employee_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` bit(1) NOT NULL,
  `approved_date_time` datetime NOT NULL,
  `cv_path` varchar(255) DEFAULT NULL,
  `github_path` varchar(255) DEFAULT NULL,
  `insert_date_time` datetime NOT NULL,
  `is_looking_for_work` bit(1) NOT NULL,
  `is_working` bit(1) NOT NULL,
  `last_update_date_time` datetime NOT NULL,
  `linkedin_path` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5s5kad0xi8m49gscqaxjq2hcw` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.employee_profile: 0 rows
/*!40000 ALTER TABLE `employee_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_profile` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_profile_language
DROP TABLE IF EXISTS `employee_profile_language`;
CREATE TABLE IF NOT EXISTS `employee_profile_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `insert_user_id` int(11) DEFAULT NULL,
  `language_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs4muhk6x4j4tkxqb1odmnfj7m` (`employee_profile_id`),
  KEY `FK7j30pdjum3yw8s98g6suimrsv` (`insert_user_id`),
  KEY `FK9wagkcbieklokxxyeeo3e69tq` (`language_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.employee_profile_language: 0 rows
/*!40000 ALTER TABLE `employee_profile_language` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_profile_language` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_profile_skill
DROP TABLE IF EXISTS `employee_profile_skill`;
CREATE TABLE IF NOT EXISTS `employee_profile_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `insert_user_id` int(11) DEFAULT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi0g6h7113kqhy19m5xqu34jhf` (`employee_profile_id`),
  KEY `FKhlppa0870a9httphd222l38l7` (`insert_user_id`),
  KEY `FK6vt32pmm7jwvo7yndis5k9395` (`skill_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.employee_profile_skill: 0 rows
/*!40000 ALTER TABLE `employee_profile_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_profile_skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.employee_project
DROP TABLE IF EXISTS `employee_project`;
CREATE TABLE IF NOT EXISTS `employee_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` smallint(6) NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `join_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NOT NULL,
  `position` varchar(255) DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpdp6ekpc8854dn4mebe7d1sdj` (`employee_id`),
  KEY `FKhi5ffkj0w09uieki7lhiop2ub` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.employee_project: 0 rows
/*!40000 ALTER TABLE `employee_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_project` ENABLE KEYS */;

-- Dumping structure for table itcommunity.gender
DROP TABLE IF EXISTS `gender`;
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `insert_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK215eyw15xo7olf04ivx8wsnfj` (`insert_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.gender: 2 rows
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` (`id`, `insert_date_time`, `last_update_date_time`, `name`, `insert_user_id`) VALUES
	(1, '2019-09-05 14:57:41', NULL, 'male', 1),
	(2, '2019-09-05 14:57:51', NULL, 'female', 1);
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;

-- Dumping structure for table itcommunity.itproject
DROP TABLE IF EXISTS `itproject`;
CREATE TABLE IF NOT EXISTS `itproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `about` longtext CHARACTER SET utf8 NOT NULL,
  `github_path` varchar(255) DEFAULT NULL,
  `in_development` tinyint(1) NOT NULL,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `need_employee` tinyint(1) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `website_path` varchar(255) DEFAULT NULL,
  `insert_user_id` int(11) NOT NULL,
  `thumbnail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnm613r98cxys625b04c4vmrgk` (`insert_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.itproject: 1 rows
/*!40000 ALTER TABLE `itproject` DISABLE KEYS */;
INSERT INTO `itproject` (`id`, `about`, `github_path`, `in_development`, `insert_date_time`, `last_update_date_time`, `name`, `need_employee`, `publish_date`, `website_path`, `insert_user_id`, `thumbnail`) VALUES
	(1, 'Bu proyekt IT sahəsində olan, hal-hazırda çalışan və ya çalışmayan hər kəsi eyni platforma altında cəmləyir. IT sahəsində olan şəxs özü haqqında qısa məlumat təsvir edir, hansı bacarıqları hansı səviyyədə bilir onu qeyd edir, cv-sini, linkedin profilini, hal-hazırda çalışıb çalışmadığını qeyd edir.\nBu proyekt ona imkan yaradacaq ki, hansısa şirkət və ya entrepreneur IT sahəsindən hər hansısa məqsədlə(işə götürmə, seminar vermək üçün, freelance layihələr və s.) şəxs axtardıqda rahatlıqla bu portaldan istifadə edə biləcək.', 'https://github.com/bsp-tech/itcommunity', 1, '2019-09-05 15:00:00', NULL, 'test', NULL, NULL, 'https://github.com/bsp-tech/itcommunity', 1, 'https://web-material3.yokogawa.com/f50b5c6f3b3ab4006f471295cdff5684f5afafe9.png');
/*!40000 ALTER TABLE `itproject` ENABLE KEYS */;

-- Dumping structure for table itcommunity.language
DROP TABLE IF EXISTS `language`;
CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `insert_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdwp1pgedsyc6fy6jwl968ssvo` (`insert_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.language: 0 rows
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- Dumping structure for table itcommunity.project_skill
DROP TABLE IF EXISTS `project_skill`;
CREATE TABLE IF NOT EXISTS `project_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `insert_user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6d8u9eejfdghrefo87s61bdk1` (`insert_user_id`),
  KEY `FKebssgfcqvrsaxrs00sj0anbi9` (`project_id`),
  KEY `FKrhm021cfqcutusb89uxtgyred` (`skill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.project_skill: 2 rows
/*!40000 ALTER TABLE `project_skill` DISABLE KEYS */;
INSERT INTO `project_skill` (`id`, `insert_date_time`, `last_update_date_time`, `insert_user_id`, `project_id`, `skill_id`) VALUES
	(1, '2019-05-09 00:00:00', NULL, 1, 1, 1),
	(2, '2019-05-09 00:00:00', NULL, 1, 1, 2);
/*!40000 ALTER TABLE `project_skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `insert_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgw4yqgxj9ncnn8e9kndmnqleh` (`insert_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.role: 2 rows
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `insert_date_time`, `last_update_time`, `name`, `insert_user_id`) VALUES
	(1, '2019-05-09 00:00:00', '2019-05-09 00:00:00', 'ADMIN', 1),
	(2, '2019-05-09 00:00:00', '2019-05-09 00:00:00', 'CLIENT', 1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table itcommunity.skill
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `insert_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8lybb5iwlwxoold07nw25oh2o` (`insert_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.skill: 2 rows
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` (`id`, `insert_date_time`, `last_update_time`, `name`, `insert_user_id`) VALUES
	(1, NULL, NULL, 'Java', 1),
	(2, NULL, NULL, 'Bootstrap', 1);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;

-- Dumping structure for table itcommunity.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `gender_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcbf93j56y7t2tyhunb4neewva` (`gender_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.user: 2 rows
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `age`, `email`, `enabled`, `insert_date_time`, `last_update_date_time`, `name`, `password`, `surname`, `username`, `gender_id`) VALUES
	(1, 26, 'sarkhanrasullu@gmail.com', 1, '2019-09-05 15:00:00', NULL, 'Sarkhan', '111111', 'Rasullu', 'sarkhan', 0),
	(6, 1111, 'aa@mail.ru', 0, '2019-09-05 17:59:36', NULL, 'aa', '1111', 'aa', 'aa', 2),
	(7, 111, 'aasdcsdc@mail.ru', 0, '2019-09-06 12:53:48', NULL, 'aa', '1111', 'aa', 'aa', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table itcommunity.user_role
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime NOT NULL,
  `last_update_date_time` datetime DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table itcommunity.user_role: 1 rows
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `insert_date_time`, `last_update_date_time`, `role_id`, `user_id`) VALUES
	(2, '2019-09-05 17:59:36', NULL, 2, 6),
	(3, '2019-09-06 12:53:48', NULL, 2, 7);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
