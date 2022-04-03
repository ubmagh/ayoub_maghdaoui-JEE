/*
 Navicat Premium Data Transfer

 Source Server         : MylocalSQL
 Source Server Type    : MySQL
 Source Server Version : 100422
 Source Host           : localhost:3306
 Source Schema         : patients_db

 Target Server Type    : MySQL
 Target Server Version : 100422
 File Encoding         : 65001

 Date: 03/04/2022 12:31:27
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_naissance` date NULL DEFAULT NULL,
  `malade` bit(1) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 395 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (352, '2022-03-26', b'0', 'Ayoub', 10);
INSERT INTO `patient` VALUES (353, '2022-03-26', b'0', 'Ali', 10);
INSERT INTO `patient` VALUES (354, '2022-03-26', b'0', 'Fatima', 10);
INSERT INTO `patient` VALUES (355, '2022-03-26', b'0', 'Hassan', 10);
INSERT INTO `patient` VALUES (356, '2022-03-26', b'0', 'hanane', 10);
INSERT INTO `patient` VALUES (357, '2022-03-26', b'0', 'mohamed', 10);
INSERT INTO `patient` VALUES (358, '2022-03-26', b'0', 'yusuf', 10);
INSERT INTO `patient` VALUES (359, '2022-03-26', b'0', 'yassamine', 10);
INSERT INTO `patient` VALUES (360, '2022-03-26', b'0', 'amine', 10);
INSERT INTO `patient` VALUES (361, '2022-03-26', b'0', 'ayman', 10);
INSERT INTO `patient` VALUES (362, '2022-03-26', b'0', 'lahcen', 10);
INSERT INTO `patient` VALUES (363, '2022-03-26', b'0', 'naoufal', 10);
INSERT INTO `patient` VALUES (364, '2022-03-26', b'0', 'mouad', 10);
INSERT INTO `patient` VALUES (365, '2022-03-27', b'0', 'Ahmed', 10);
INSERT INTO `patient` VALUES (366, '2022-03-27', b'0', 'Ayoub', 10);
INSERT INTO `patient` VALUES (367, '2022-03-27', b'0', 'Ali', 10);
INSERT INTO `patient` VALUES (368, '2022-03-27', b'0', 'Fatima', 10);
INSERT INTO `patient` VALUES (369, '2022-03-27', b'0', 'Hassan', 10);
INSERT INTO `patient` VALUES (370, '2022-03-27', b'0', 'hanane', 10);
INSERT INTO `patient` VALUES (371, '2022-03-27', b'0', 'mohamed', 10);
INSERT INTO `patient` VALUES (372, '2022-03-27', b'0', 'yussuf', 10);
INSERT INTO `patient` VALUES (374, '2022-03-27', b'0', 'amine', 10);
INSERT INTO `patient` VALUES (375, '2022-03-27', b'0', 'ayman', 10);
INSERT INTO `patient` VALUES (376, '2022-03-27', b'0', 'lahcen', 10);
INSERT INTO `patient` VALUES (377, '2022-03-27', b'0', 'naoufal', 10);
INSERT INTO `patient` VALUES (378, '2022-03-27', b'0', 'mouad', 10);
INSERT INTO `patient` VALUES (379, '2022-03-27', b'0', 'Ahmed', 10);
INSERT INTO `patient` VALUES (380, '2022-03-27', b'0', 'Ayoub', 10);
INSERT INTO `patient` VALUES (381, '2022-03-27', b'0', 'Ali', 10);
INSERT INTO `patient` VALUES (382, '2022-03-27', b'0', 'Fatima', 10);
INSERT INTO `patient` VALUES (383, '2022-03-27', b'0', 'Hassan', 10);
INSERT INTO `patient` VALUES (384, '2022-03-27', b'0', 'hanane', 10);
INSERT INTO `patient` VALUES (385, '2022-03-27', b'0', 'mohamed', 10);
INSERT INTO `patient` VALUES (386, '2022-03-27', b'0', 'yusuf', 10);
INSERT INTO `patient` VALUES (387, '2022-03-27', b'0', 'yassamine', 10);
INSERT INTO `patient` VALUES (388, '2022-03-27', b'0', 'amine', 10);
INSERT INTO `patient` VALUES (389, '2022-03-27', b'0', 'ayman', 10);
INSERT INTO `patient` VALUES (390, '2022-03-27', b'0', 'lahcen', 10);
INSERT INTO `patient` VALUES (391, '2022-03-27', b'0', 'naoufal', 10);
INSERT INTO `patient` VALUES (392, '2022-03-27', b'0', 'mouad', 10);
INSERT INTO `patient` VALUES (393, '1000-10-10', b'0', 'Ze3ter', 299);
INSERT INTO `patient` VALUES (394, '2022-03-26', b'0', 'hanane', 10);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('ADMIN');
INSERT INTO `roles` VALUES ('USER');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `active` bit(1) NULL DEFAULT b'1',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '$2a$10$UTq6QmaRLfawvJ2YV9uHge.J2pimnR14a110tHb0yfR5u2n1gFuIK', b'1');
INSERT INTO `users` VALUES ('user', '$2a$10$UTq6QmaRLfawvJ2YV9uHge.J2pimnR14a110tHb0yfR5u2n1gFuIK', b'1');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles`  (
  `username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`username`, `role`) USING BTREE,
  INDEX `role`(`role`) USING BTREE,
  CONSTRAINT `role` FOREIGN KEY (`role`) REFERENCES `roles` (`role`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES ('admin', 'ADMIN');
INSERT INTO `users_roles` VALUES ('user', 'USER');

SET FOREIGN_KEY_CHECKS = 1;
