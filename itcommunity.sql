/*
 Navicat Premium Data Transfer

 Source Server         : herokuitcommunity
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : otmaa16c1i9nwrek.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306
 Source Schema         : sqo01ngo0q42ejvi

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 15/09/2019 17:50:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_group
-- ----------------------------
INSERT INTO `auth_group` VALUES (1, 'ADMIN');
INSERT INTO `auth_group` VALUES (2, 'CLIENT');
INSERT INTO `auth_group` VALUES (3, 'EMPLOYEE');

-- ----------------------------
-- Table structure for auth_group_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_role`;
CREATE TABLE `auth_group_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`group_id`) USING BTREE,
  CONSTRAINT `auth_group_role_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_group_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_group_role
-- ----------------------------
INSERT INTO `auth_group_role` VALUES (3, 2, 3, '2019-09-06 22:52:34', NULL);
INSERT INTO `auth_group_role` VALUES (4, 3, 4, '2019-09-06 22:52:34', NULL);

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES (1, 'CREATE_PROJECT', '2019-05-09 00:00:00', '2019-09-14 19:28:41');
INSERT INTO `auth_role` VALUES (3, 'CREATE_EMPLOYEE_PROFILE', '2019-09-14 20:58:09', '2019-09-14 20:58:21');
INSERT INTO `auth_role` VALUES (4, 'JOIN_TEAM', '2019-09-14 20:58:09', NULL);

-- ----------------------------
-- Table structure for employee_profile
-- ----------------------------
DROP TABLE IF EXISTS `employee_profile`;
CREATE TABLE `employee_profile`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` bit(1) NOT NULL,
  `approved_date_time` datetime(0) NOT NULL,
  `cv_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `github_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `is_looking_for_work` bit(1) NOT NULL,
  `is_working` bit(1) NOT NULL,
  `linkedin_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `speciality` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experience` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK5s5kad0xi8m49gscqaxjq2hcw`(`user_id`) USING BTREE,
  CONSTRAINT `employee_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_profile
-- ----------------------------
INSERT INTO `employee_profile` VALUES (57, b'1', '2019-09-15 06:02:35', 'cvPath_test', 'github_test', b'1', b'1', 'linkedin_test', 6, '2019-09-15 06:02:35', '2019-09-15 06:02:35', 'About meeeeeeee', 'Developer', 1);
INSERT INTO `employee_profile` VALUES (60, b'1', '2019-09-15 06:23:52', '', '', b'1', b'0', '', 7, '2019-09-15 06:23:52', '2019-09-15 06:23:52', 'I am a young programmer', 'React.js', 1);

-- ----------------------------
-- Table structure for employee_profile_language
-- ----------------------------
DROP TABLE IF EXISTS `employee_profile_language`;
CREATE TABLE `employee_profile_language`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKs4muhk6x4j4tkxqb1odmnfj7m`(`employee_profile_id`) USING BTREE,
  INDEX `FK9wagkcbieklokxxyeeo3e69tq`(`language_id`) USING BTREE,
  INDEX `FK7j30pdjum3yw8s98g6suimrsv`(`insert_user_id`) USING BTREE,
  CONSTRAINT `FK7j30pdjum3yw8s98g6suimrsv` FOREIGN KEY (`insert_user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_profile_language_ibfk_1` FOREIGN KEY (`employee_profile_id`) REFERENCES `employee_profile` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_profile_language_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_profile_language
-- ----------------------------
INSERT INTO `employee_profile_language` VALUES (24, 8, 57, 1, '2019-09-15 06:02:35', NULL, NULL);
INSERT INTO `employee_profile_language` VALUES (25, 1, 57, 2, '2019-09-15 06:02:35', NULL, NULL);
INSERT INTO `employee_profile_language` VALUES (26, 9, 57, 3, '2019-09-15 06:02:35', NULL, NULL);

-- ----------------------------
-- Table structure for employee_profile_skill
-- ----------------------------
DROP TABLE IF EXISTS `employee_profile_skill`;
CREATE TABLE `employee_profile_skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NULL DEFAULT NULL,
  `employee_profile_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKi0g6h7113kqhy19m5xqu34jhf`(`employee_profile_id`) USING BTREE,
  INDEX `FK6vt32pmm7jwvo7yndis5k9395`(`skill_id`) USING BTREE,
  INDEX `FKhlppa0870a9httphd222l38l7`(`insert_user_id`) USING BTREE,
  CONSTRAINT `FKhlppa0870a9httphd222l38l7` FOREIGN KEY (`insert_user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_profile_skill_ibfk_1` FOREIGN KEY (`employee_profile_id`) REFERENCES `employee_profile` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_profile_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_profile_skill
-- ----------------------------
INSERT INTO `employee_profile_skill` VALUES (24, 3, 57, 1, '2019-09-15 06:02:35', NULL, NULL);

-- ----------------------------
-- Table structure for employee_project
-- ----------------------------
DROP TABLE IF EXISTS `employee_project`;
CREATE TABLE `employee_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved` smallint(6) NOT NULL,
  `position` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `join_date_time` datetime(0) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKpdp6ekpc8854dn4mebe7d1sdj`(`employee_id`) USING BTREE,
  INDEX `FKhi5ffkj0w09uieki7lhiop2ub`(`project_id`) USING BTREE,
  CONSTRAINT `employee_project_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_profile` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_project_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `itproject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gender
-- ----------------------------
DROP TABLE IF EXISTS `gender`;
CREATE TABLE `gender`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK215eyw15xo7olf04ivx8wsnfj`(`insert_user_id`) USING BTREE,
  CONSTRAINT `FK215eyw15xo7olf04ivx8wsnfj` FOREIGN KEY (`insert_user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gender
-- ----------------------------
INSERT INTO `gender` VALUES (1, 'male', '2019-09-05 14:57:41', NULL, NULL);
INSERT INTO `gender` VALUES (2, 'female', '2019-09-05 14:57:51', NULL, NULL);

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for itproject
-- ----------------------------
DROP TABLE IF EXISTS `itproject`;
CREATE TABLE `itproject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `about` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `github_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `in_development` tinyint(1) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `need_employee` tinyint(1) NULL DEFAULT NULL,
  `publish_date` datetime(0) NULL DEFAULT NULL,
  `website_path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `thumbnail` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of itproject
-- ----------------------------
INSERT INTO `itproject` VALUES (1, 'Bu proyekt IT sahəsində olan, hal-hazırda çalışan və ya çalışmayan hər kəsi eyni platforma altında cəmləyir. IT sahəsində olan şəxs özü haqqında qısa məlumat təsvir edir, hansı bacarıqları hansı səviyyədə bilir onu qeyd edir, cv-sini, linkedin profilini, hal-hazırda çalışıb çalışmadığını qeyd edir.\nBu proyekt ona imkan yaradacaq ki, hansısa şirkət və ya entrepreneur IT sahəsindən hər hansısa məqsədlə(işə göt', 'https://github.com/bsp-tech/itcommunity', 1, 'test', 1, '2019-09-16 22:56:38', 'https://github.com/bsp-tech/itcommunity', 'https://web-material3.yokogawa.com/f50b5c6f3b3ab4006f471295cdff5684f5afafe9.png', '2019-09-05 15:00:00', '2019-09-06 23:17:15', 0);

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES (1, 'English', '2019-09-07 02:20:46', NULL, 0);
INSERT INTO `language` VALUES (2, 'Russian', '2019-09-07 02:20:50', NULL, 0);
INSERT INTO `language` VALUES (3, 'Turkish', '2019-09-07 02:20:54', NULL, 0);

-- ----------------------------
-- Table structure for project_skill
-- ----------------------------
DROP TABLE IF EXISTS `project_skill`;
CREATE TABLE `project_skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKebssgfcqvrsaxrs00sj0anbi9`(`project_id`) USING BTREE,
  INDEX `FKrhm021cfqcutusb89uxtgyred`(`skill_id`) USING BTREE,
  CONSTRAINT `project_skill_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `itproject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_skill
-- ----------------------------
INSERT INTO `project_skill` VALUES (1, 1, 1, '2019-05-09 00:00:00', NULL, 0);
INSERT INTO `project_skill` VALUES (2, 1, 2, '2019-05-09 00:00:00', NULL, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime(0) NOT NULL,
  `last_update_time` datetime(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insert_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKgw4yqgxj9ncnn8e9kndmnqleh`(`insert_user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `insert_date_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `insert_user_id` int(11) NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8lybb5iwlwxoold07nw25oh2o`(`insert_user_id`) USING BTREE,
  CONSTRAINT `FK8lybb5iwlwxoold07nw25oh2o` FOREIGN KEY (`insert_user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (1, 'Java', NULL, '2019-09-15 01:21:56', NULL, 1);
INSERT INTO `skill` VALUES (2, 'Bootstrap', NULL, '2019-09-15 01:21:56', NULL, 1);
INSERT INTO `skill` VALUES (3, 'asdkjansd', NULL, NULL, NULL, NULL);
INSERT INTO `skill` VALUES (4, 'asdasda', '2019-09-15 02:36:34', NULL, NULL, 0);
INSERT INTO `skill` VALUES (5, 'cdcd', '2019-09-15 02:56:28', NULL, NULL, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `gender_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `insert_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `thumbnail` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKcbf93j56y7t2tyhunb4neewva`(`gender_id`) USING BTREE,
  INDEX `group_id`(`group_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 26, 'sarkhanrasullu@gmail.com', 1, 'Sarkhan', '$2a$10$n/baNikq3Om/YbAJPrE9KOJZgrbTxBWPMUOat0P9SPvaVR9E9A4s2', 'Rasullu', 1, 2, '2019-09-14 23:15:10', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 26, 'test@gmail.com', 1, 'Jale', '$2a$10$3hwgGFL79xNZtfXlYCtxvuIQZkDND.TO7w6oX5iQH6Lb10gpvAeEy', 'Mammadli', 2, 3, '2019-09-15 06:00:41', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 15, 'azermuradli1@gmail.com', 1, 'Azar', '$2a$10$l2YaBxrrY166nGQikHLHP.2RFkNRgoe9B9Nh5CeUo7MgEg6QblYH2', 'Muradli', 1, 3, '2019-09-15 06:12:43', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, 19, 'hamidsultanzadeh@gmail.com', 1, 'Hamid', '$2a$10$zsPQpKCeHZPk6suCQTI9IeGahhtzZW7epoY9EtjQ47AQHocBYR5ma', 'Sultanzadeh', 1, 2, '2019-09-15 11:37:49', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_gender
-- ----------------------------
DROP TABLE IF EXISTS `user_gender`;
CREATE TABLE `user_gender`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insert_date_time` datetime(0) NULL DEFAULT NULL,
  `last_update_date_time` datetime(0) NULL DEFAULT NULL,
  `gender_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKlm91fyos9x4ex3t0ok55a1a6g`(`gender_id`) USING BTREE,
  INDEX `FK7o6u6b52gqejs1ljomkvn3e4e`(`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
