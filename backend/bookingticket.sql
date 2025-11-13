/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : bookingticket

 Target Server Type    : MySQL
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 05/11/2025 00:41:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for booking
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `booking_date` datetime(6) NULL DEFAULT NULL,
  `total` int NULL DEFAULT NULL,
  `payment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_paid` int NULL DEFAULT NULL,
  `round_trip_ticket` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKkgseyy7t56x7lkjgu3wah5s3t`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of booking
-- ----------------------------

-- ----------------------------
-- Table structure for booking_detail
-- ----------------------------
DROP TABLE IF EXISTS `booking_detail`;
CREATE TABLE `booking_detail`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `booking_id` int NULL DEFAULT NULL,
  `trip_id` int NULL DEFAULT NULL,
  `round_trip_ticket` int NULL DEFAULT NULL,
  `quantity` int NULL DEFAULT NULL,
  `seat_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  `noidon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ghichu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK59941ondg9nwaifm2umnrduev`(`booking_id` ASC) USING BTREE,
  INDEX `FK2xohu6ps4mm6twrfw4xtacgp`(`trip_id` ASC) USING BTREE,
  CONSTRAINT `FK2xohu6ps4mm6twrfw4xtacgp` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK59941ondg9nwaifm2umnrduev` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of booking_detail
-- ----------------------------

-- ----------------------------
-- Table structure for catch_point
-- ----------------------------
DROP TABLE IF EXISTS `catch_point`;
CREATE TABLE `catch_point`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `route_id` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKm58dq6gy4x1ht7yyeubl8fg05`(`route_id` ASC) USING BTREE,
  CONSTRAINT `FKm58dq6gy4x1ht7yyeubl8fg05` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of catch_point
-- ----------------------------
INSERT INTO `catch_point` VALUES (1, 30, 'Bến xe An Sương', 'Bến Xe An Sương, Quốc Lộ 22, Ấp Đông Lân, Bà Điểm, Hóc Môn, TP Hồ Chí Minh', '2024-06-20 14:14:24.000000', '2024-06-20 14:14:24.000000');
INSERT INTO `catch_point` VALUES (2, 30, 'Bến Xe Miền Tây', ' BX Miền Tây: 395 Kinh Dương Vương , P.An Lạc , Q.Bình Tân , TP.HCM', '2024-06-20 14:15:24.000000', '2025-10-29 22:16:28.000000');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, 'Bà Rịa - Vũng tàu', 'https://drive.google.com/thumbnail?id=1hvDCq1x-g9vmx7235RlW8uCv_u-QW8o9', '2024-06-20 13:26:07.000000', '2025-10-22 13:05:39.000000');
INSERT INTO `city` VALUES (2, 'Bình Dương', 'https://drive.google.com/thumbnail?id=1XpLJGuViEo2mt_VMhl5_UxmlAtf1fG2A', '2024-06-20 13:26:25.000000', '2024-06-27 15:24:34.000000');
INSERT INTO `city` VALUES (3, 'Bình Phước', 'https://drive.google.com/thumbnail?id=1VUqPM7yoLXn8Tcz_gs_aR2haMMP3tyIM', '2024-06-20 13:26:43.000000', '2024-06-27 15:24:48.000000');
INSERT INTO `city` VALUES (4, 'Đồng Nai', 'https://drive.google.com/thumbnail?id=160o0mrhn71evwKVfmob98qnkATonu4Er', '2024-06-20 13:27:07.000000', '2024-06-27 15:25:02.000000');
INSERT INTO `city` VALUES (5, 'Tây Ninh', 'https://drive.google.com/thumbnail?id=1mbuhUkur3BqaB5Ybkecpxn7P0hSvJTBl', '2024-06-20 13:31:54.000000', '2024-06-27 15:25:18.000000');
INSERT INTO `city` VALUES (6, 'TP. Hồ Chí Minh', 'https://drive.google.com/thumbnail?id=1jjBTnl34L0hxcNQGGkGq8Oq14w-Nu87c', '2024-06-20 13:33:01.000000', '2024-06-27 15:25:34.000000');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, 'Cần liên hệ', 'nguyenvana@gmail.com', 'Nguyễn Văn A', 'Cần liên hệ', '2024-06-27 06:58:34.000000');

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES (1, 'Nguyễn Văn A', 'a@gmail.com', '12345678900', 1, '2024-04-14 22:09:09.000000', '2025-10-24 17:32:09.000000');
INSERT INTO `driver` VALUES (2, 'Nguyễn Văn B', 'b007@gmail.com', '12345678999', 1, '2024-04-14 22:09:09.000000', '2025-10-15 18:04:41.000000');
INSERT INTO `driver` VALUES (3, 'Nguyễn Văn C', 'c@gmail.com', '12345678', 1, '2024-04-14 22:09:09.000000', '2024-04-14 22:09:13.000000');
INSERT INTO `driver` VALUES (4, 'Nguyễn Văn D', 'd@gmail.com', '12345678', 1, '2024-04-14 22:09:09.000000', '2024-04-14 22:09:13.000000');
INSERT INTO `driver` VALUES (9, 'Nguyễn A', 'aa@gmail.com', '0123456789999', 1, '2025-10-15 19:13:09.000000', '2025-10-15 19:13:15.000000');

-- ----------------------------
-- Table structure for kindvehicle
-- ----------------------------
DROP TABLE IF EXISTS `kindvehicle`;
CREATE TABLE `kindvehicle`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kindvehicle
-- ----------------------------
INSERT INTO `kindvehicle` VALUES (1, 'Giường nằm', '2024-04-14 22:53:40.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `kindvehicle` VALUES (2, 'Limousine', '2024-04-14 22:53:40.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `kindvehicle` VALUES (3, 'Ghế ngồi', '2024-04-14 22:53:40.000000', '2024-04-21 21:24:15.000000');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3wxdofviqe2smmvh1w1yf98o1`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FK3wxdofviqe2smmvh1w1yf98o1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 311 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `end_day` datetime(6) NULL DEFAULT NULL,
  `start_day` datetime(6) NULL DEFAULT NULL,
  `discount_percent` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES (1, 'XY4D5CU0', 'Giảm giá cho thành viên mới', '2024-06-28 14:35:00.000000', '2024-06-20 14:35:00.000000', 10, '2024-06-20 14:35:52.000000', '2024-06-20 14:35:52.000000');
INSERT INTO `promotion` VALUES (3, 'SINHVIENMOI', 'Mã cho sinh viên', '2025-10-26 15:58:00.000000', '2025-10-16 21:57:00.000000', 50, '2025-10-16 15:58:10.000000', '2025-10-25 22:57:28.000000');
INSERT INTO `promotion` VALUES (4, 'KWXQH5XT', 'Mã tạo ngẫu nhiên', '2025-11-01 15:58:00.000000', '2025-10-24 15:58:00.000000', 30, '2025-10-16 15:58:36.000000', '2025-10-16 15:58:36.000000');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `rating` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsdujhwxnw678xtqnvqre9gl3h`(`trip_id` ASC) USING BTREE,
  INDEX `FKiyf57dy48lyiftdrf7y87rnxi`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FKiyf57dy48lyiftdrf7y87rnxi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsdujhwxnw678xtqnvqre9gl3h` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_route` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `diemdi` int NULL DEFAULT NULL,
  `diemden` int NULL DEFAULT NULL,
  `khoangcach` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `thoigiandi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `trangthai` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK6ngj368ymedbl29qg2exi7cxk`(`diemden` ASC) USING BTREE,
  INDEX `FKou0ir92ph8xo13qulrcsrcsmq`(`diemdi` ASC) USING BTREE,
  CONSTRAINT `FK6ngj368ymedbl29qg2exi7cxk` FOREIGN KEY (`diemden`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKou0ir92ph8xo13qulrcsrcsmq` FOREIGN KEY (`diemdi`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES (1, 'Bà Rịa - Vũng tàu - Bình Dương', 1, 2, '90', '2', 1, '2024-06-20 13:41:31.000000', '2024-06-20 13:41:31.000000');
INSERT INTO `route` VALUES (2, 'Bình Dương - Bà Rịa - Vũng tàu', 2, 1, '90', '2', 1, '2024-06-20 13:41:45.000000', '2024-06-20 13:41:45.000000');
INSERT INTO `route` VALUES (3, 'Bà Rịa - Vũng tàu - Bình Phước', 1, 3, '140', '3', 1, '2024-06-20 13:42:01.000000', '2024-06-20 13:42:01.000000');
INSERT INTO `route` VALUES (4, 'Bình Phước - Bà Rịa - Vũng tàu', 3, 1, '140', '3', 1, '2024-06-20 13:42:16.000000', '2024-06-20 13:42:16.000000');
INSERT INTO `route` VALUES (5, 'Bà Rịa - Vũng tàu - Đồng Nai', 1, 4, '60', '1.5', 1, '2024-06-20 13:42:31.000000', '2024-06-20 13:42:31.000000');
INSERT INTO `route` VALUES (6, 'Đồng Nai - Bà Rịa - Vũng tàu', 4, 1, '60', '1.5', 1, '2024-06-20 13:43:00.000000', '2024-06-20 13:43:00.000000');
INSERT INTO `route` VALUES (7, 'Bà Rịa - Vũng tàu - Tây Ninh', 1, 5, '180', '3.5', 1, '2024-06-20 13:43:23.000000', '2024-06-20 13:43:23.000000');
INSERT INTO `route` VALUES (8, 'Tây Ninh - Bà Rịa - Vũng tàu', 5, 1, '180', '3.5', 1, '2024-06-20 13:44:41.000000', '2024-06-20 13:44:41.000000');
INSERT INTO `route` VALUES (9, 'Bà Rịa - Vũng tàu - TP. Hồ Chí Minh', 1, 6, '100', '2', 1, '2024-06-20 13:44:56.000000', '2024-06-20 14:30:17.000000');
INSERT INTO `route` VALUES (10, 'TP. Hồ Chí Minh - Bà Rịa - Vũng tàu', 6, 1, '100', '2', 1, '2024-06-20 13:45:16.000000', '2024-06-20 14:30:25.000000');
INSERT INTO `route` VALUES (11, 'Bình Dương - Bình Phước', 2, 3, '90', '2', 1, '2024-06-20 13:45:42.000000', '2024-06-20 13:45:42.000000');
INSERT INTO `route` VALUES (12, 'Bình Phước - Bình Dương', 3, 2, '90', '2', 1, '2024-06-20 13:46:00.000000', '2024-06-20 13:46:00.000000');
INSERT INTO `route` VALUES (13, 'Bình Dương - Đồng Nai', 2, 4, '60', '1.5', 1, '2024-06-20 13:46:30.000000', '2024-06-20 13:46:30.000000');
INSERT INTO `route` VALUES (14, 'Đồng Nai - Bình Dương', 4, 2, '60', '1.5', 1, '2024-06-20 13:47:00.000000', '2024-06-20 13:47:00.000000');
INSERT INTO `route` VALUES (15, 'Bình Dương - Tây Ninh', 2, 5, '100', '2', 1, '2024-06-20 13:47:18.000000', '2024-06-20 13:47:18.000000');
INSERT INTO `route` VALUES (16, 'Tây Ninh - Bình Dương', 5, 2, '100', '2', 1, '2024-06-20 13:47:37.000000', '2024-06-20 13:47:37.000000');
INSERT INTO `route` VALUES (17, 'Bình Dương - TP. Hồ Chí Minh', 2, 6, '30', '1', 1, '2024-06-20 13:48:04.000000', '2024-06-20 14:30:48.000000');
INSERT INTO `route` VALUES (18, 'TP. Hồ Chí Minh - Bình Dương', 6, 2, '30', '1', 1, '2024-06-20 13:49:19.000000', '2024-06-20 14:31:02.000000');
INSERT INTO `route` VALUES (19, 'Bình Phước - Đồng Nai', 3, 4, '120', '2.5', 1, '2024-06-20 13:49:59.000000', '2024-06-20 13:49:59.000000');
INSERT INTO `route` VALUES (20, 'Đồng Nai - Bình Phước', 4, 3, '120', '2.5', 1, '2024-06-20 13:50:31.000000', '2024-06-20 13:50:31.000000');
INSERT INTO `route` VALUES (21, 'Bình Phước - Tây Ninh', 3, 5, '150', '3', 1, '2024-06-20 13:50:55.000000', '2024-06-20 13:50:55.000000');
INSERT INTO `route` VALUES (22, 'Tây Ninh - Bình Phước', 5, 3, '150', '3', 1, '2024-06-20 13:51:12.000000', '2024-06-20 13:51:12.000000');
INSERT INTO `route` VALUES (23, 'Bình Phước - TP. Hồ Chí Minh', 3, 6, '110', '2.5', 1, '2024-06-20 13:51:43.000000', '2024-06-20 14:31:13.000000');
INSERT INTO `route` VALUES (24, 'TP. Hồ Chí Minh - Bình Phước', 6, 3, '110', '2.5', 1, '2024-06-20 13:52:10.000000', '2024-06-20 14:31:19.000000');
INSERT INTO `route` VALUES (25, 'Đồng Nai - Tây Ninh', 4, 5, '150', '3', 1, '2024-06-20 13:52:31.000000', '2024-06-20 13:52:31.000000');
INSERT INTO `route` VALUES (26, 'Tây Ninh - Đồng Nai', 5, 4, '150', '3', 1, '2024-06-20 13:52:45.000000', '2024-06-20 13:52:45.000000');
INSERT INTO `route` VALUES (27, 'Đồng Nai - TP. Hồ Chí Minh', 4, 6, '60', '1.5', 1, '2024-06-20 13:53:02.000000', '2024-06-20 14:31:25.000000');
INSERT INTO `route` VALUES (28, 'TP. Hồ Chí Minh - Đồng Nai', 6, 4, '60', '1.5', 1, '2024-06-20 13:53:49.000000', '2024-06-20 14:31:32.000000');
INSERT INTO `route` VALUES (29, 'Tây Ninh - TP. Hồ Chí Minh', 5, 6, '100', '2', 1, '2024-06-20 13:54:00.000000', '2024-06-20 14:31:37.000000');
INSERT INTO `route` VALUES (30, 'TP. Hồ Chí Minh - Tây Ninh', 6, 5, '100', '2', 1, '2024-06-20 13:54:09.000000', '2025-10-24 16:26:41.000000');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenghe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `loaixe_id` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK9cr2xku9vc0n4xg2i3q6e5ekl`(`loaixe_id` ASC) USING BTREE,
  CONSTRAINT `FK9cr2xku9vc0n4xg2i3q6e5ekl` FOREIGN KEY (`loaixe_id`) REFERENCES `kindvehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, 'A01', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (2, 'A02', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (3, 'A03', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (4, 'A04', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (5, 'A05', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (6, 'A06', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (7, 'A07', 1, 1, '2024-04-14 22:55:07.000000', '2025-10-19 10:19:38.000000');
INSERT INTO `seat` VALUES (8, 'A08', 1, 1, '2024-04-14 22:55:07.000000', '2025-10-19 10:19:54.000000');
INSERT INTO `seat` VALUES (9, 'A09', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (10, 'A10', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `seat` VALUES (11, 'A11', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (12, 'A12', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (13, 'A13', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (14, 'A14', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (15, 'A15', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (16, 'A16', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (17, 'A17', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (18, 'A18', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (19, 'A19', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (20, 'A20', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (21, 'A21', 1, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (22, 'A01', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (23, 'A02', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (24, 'A03', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (25, 'A04', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (26, 'A05', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (27, 'A06', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (28, 'A07', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (29, 'A08', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (30, 'A09', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (31, 'A10', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `seat` VALUES (32, 'A11', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (33, 'A12', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (34, 'A13', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (35, 'A14', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (36, 'A15', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (37, 'A16', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (38, 'A17', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (39, 'A18', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (40, 'A19', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (41, 'A20', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (42, 'A21', 2, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (43, 'A01', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (44, 'A02', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (45, 'A03', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (46, 'A04', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (47, 'A05', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 02:36:23.000000');
INSERT INTO `seat` VALUES (48, 'A06', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (49, 'A07', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (50, 'A08', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (51, 'A09', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 09:08:52.000000');
INSERT INTO `seat` VALUES (52, 'A10', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `seat` VALUES (53, 'A11', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (54, 'A12', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (55, 'A13', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (56, 'A14', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (57, 'A15', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (58, 'A16', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (59, 'A17', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (60, 'A18', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (61, 'A19', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (62, 'A20', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');
INSERT INTO `seat` VALUES (63, 'A21', 3, 1, '2024-04-14 22:55:07.000000', '2024-04-14 22:55:09.000000');

-- ----------------------------
-- Table structure for seat_reservsation
-- ----------------------------
DROP TABLE IF EXISTS `seat_reservsation`;
CREATE TABLE `seat_reservsation`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `booking_id` int NULL DEFAULT NULL,
  `trip_id` int NULL DEFAULT NULL,
  `seat_id` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK86bskijp07j65wdyb5u939d5h`(`booking_id` ASC) USING BTREE,
  INDEX `FKdogs4skrjosgkdt8yrxd1r264`(`seat_id` ASC) USING BTREE,
  INDEX `FKc27yd48ljgw68twxfjbdoxdof`(`trip_id` ASC) USING BTREE,
  CONSTRAINT `FK86bskijp07j65wdyb5u939d5h` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKc27yd48ljgw68twxfjbdoxdof` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKdogs4skrjosgkdt8yrxd1r264` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of seat_reservsation
-- ----------------------------

-- ----------------------------
-- Table structure for trip
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `route_id` int NULL DEFAULT NULL,
  `vehicle_id` int NULL DEFAULT NULL,
  `ngaykhoihanh` date NULL DEFAULT NULL,
  `giokhoihanh` time(6) NULL DEFAULT NULL,
  `giave` int NULL DEFAULT NULL,
  `taixe_id` int NULL DEFAULT NULL,
  `controng` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKd2h5nli11j3hsr670tlswlnm7`(`taixe_id` ASC) USING BTREE,
  INDEX `FKeva4adpyk6glllffnw5ypj20j`(`route_id` ASC) USING BTREE,
  INDEX `FKrji8htecrp06ao6s7nfubswnr`(`vehicle_id` ASC) USING BTREE,
  CONSTRAINT `FKd2h5nli11j3hsr670tlswlnm7` FOREIGN KEY (`taixe_id`) REFERENCES `driver` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKeva4adpyk6glllffnw5ypj20j` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKrji8htecrp06ao6s7nfubswnr` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of trip
-- ----------------------------
INSERT INTO `trip` VALUES (1, 30, 1, '2025-10-09', '15:09:00.000000', 120000, 1, 21, 2, '2024-06-20 14:09:18.000000', '2025-10-23 16:55:45.000000');
INSERT INTO `trip` VALUES (2, 29, 2, '2025-10-10', '16:10:00.000000', 120000, 2, 21, 2, '2024-06-20 14:09:54.000000', '2025-10-10 12:19:14.000000');
INSERT INTO `trip` VALUES (3, 30, 6, '2025-10-31', '17:10:00.000000', 121000, 3, 21, 1, '2024-06-20 14:10:36.000000', '2025-10-31 23:13:33.000000');
INSERT INTO `trip` VALUES (4, 30, 5, '2025-10-28', '18:11:00.000000', 200000, 4, 21, 1, '2024-06-20 14:11:13.000000', '2025-10-28 12:57:37.000000');
INSERT INTO `trip` VALUES (5, 29, 4, '2025-10-29', '16:23:00.000000', 500000, 1, 21, 1, '2025-09-23 16:23:18.000000', '2025-10-28 12:57:51.000000');
INSERT INTO `trip` VALUES (6, 2, 1, '2025-10-25', '12:12:00.000000', 200000, 2, 21, 1, '2025-10-23 12:11:28.000000', NULL);
INSERT INTO `trip` VALUES (8, 1, 1, '2025-10-23', '18:28:00.000000', 20000, 1, 21, 1, '2025-10-23 17:28:58.000000', NULL);
INSERT INTO `trip` VALUES (9, 1, 1, '2025-10-24', '10:14:00.000000', 20000, 1, 21, 1, '2025-10-24 10:11:05.000000', NULL);
INSERT INTO `trip` VALUES (10, 1, 1, '2025-11-13', '12:10:00.000000', 200000, 1, 21, 1, '2025-10-28 12:08:29.000000', '2025-11-05 00:18:28.000000');
INSERT INTO `trip` VALUES (11, 2, 1, '2025-11-08', '21:43:00.000000', 50000000, 2, 21, 1, '2025-11-04 21:42:10.000000', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `confirm_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Nguyễn Văn B', '$2a$10$gabxjiwA.veuqREmm4KPK.vaqg59LAIX5BN8KYlOJDFGyiYCGrwBG', 'abc@gmail.com', '1234567', 1, 2, 'Đăng ký', '', '2024-04-23 22:52:54.000000', '2024-04-23 22:52:59.000000');
INSERT INTO `user` VALUES (2, 'Nguyễn Văn C', '$2a$10$gabxjiwA.veuqREmm4KPK.vaqg59LAIX5BN8KYlOJDFGyiYCGrwBG', 'abcd@gmail.com', '12345679', 2, 2, 'Google', '', '2024-04-23 22:52:54.000000', '2024-04-23 22:52:59.000000');
INSERT INTO `user` VALUES (3, 'Nguyễn Văn D', '$2a$10$gabxjiwA.veuqREmm4KPK.vaqg59LAIX5BN8KYlOJDFGyiYCGrwBG', 'abcde@gmail.com', '123456780', 1, 1, 'Đăng ký', '', '2024-04-23 22:52:54.000000', '2025-10-31 20:59:57.000000');

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `loaixe_id` int NULL DEFAULT NULL,
  `bienso` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `succhua` int NULL DEFAULT NULL,
  `trangthai` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  `updated_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8yvp5l18p5adpwmtarb8jpqc`(`loaixe_id` ASC) USING BTREE,
  CONSTRAINT `FK8yvp5l18p5adpwmtarb8jpqc` FOREIGN KEY (`loaixe_id`) REFERENCES `kindvehicle` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES (1, 'Vehicle001', 1, 'BS001', 21, 1, '2025-11-04 21:42:10.000000', '2025-11-04 21:42:10.000000');
INSERT INTO `vehicle` VALUES (2, 'Vehicle002', 2, 'BS002', 21, 1, '2025-10-23 12:12:43.000000', '2025-10-23 12:12:43.000000');
INSERT INTO `vehicle` VALUES (3, 'Vehicle003', 3, 'BS003', 21, 1, '2024-06-20 14:10:36.000000', '2024-06-20 14:10:36.000000');
INSERT INTO `vehicle` VALUES (4, 'Vehicle004', 1, 'BS004', 21, 1, '2024-04-14 22:53:40.000000', '2024-04-21 21:24:15.000000');
INSERT INTO `vehicle` VALUES (5, 'Vehicle005', 2, 'BS005', 21, 1, '2024-04-14 22:53:40.000000', '2024-04-14 22:53:44.000000');
INSERT INTO `vehicle` VALUES (6, 'Vehicle006', 3, 'BS006', 21, 1, '2024-04-14 22:53:40.000000', '2024-04-14 22:53:44.000000');

-- ----------------------------
-- Table structure for waiting_seat
-- ----------------------------
DROP TABLE IF EXISTS `waiting_seat`;
CREATE TABLE `waiting_seat`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NULL DEFAULT NULL,
  `seat_id` int NULL DEFAULT NULL,
  `created_at` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKkood0ttlamq7wvedqa6mnb0r9`(`seat_id` ASC) USING BTREE,
  INDEX `FKdgkoylnn9b9db0g7dtruvuttw`(`trip_id` ASC) USING BTREE,
  CONSTRAINT `FKdgkoylnn9b9db0g7dtruvuttw` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKkood0ttlamq7wvedqa6mnb0r9` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of waiting_seat
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
