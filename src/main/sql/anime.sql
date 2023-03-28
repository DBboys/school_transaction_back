 /*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : anime

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 24/10/2022 11:39:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shizuku_anime
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_anime`;
CREATE TABLE `shizuku_anime`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '番剧名',
  `type` int NOT NULL COMMENT '番剧类型，0:季度番，1:剧场版',
  `week_update` int NULL DEFAULT NULL COMMENT '更新时间 0-6 周一-周六',
  `year` int NOT NULL COMMENT '上映年份',
  `quarterly` int NULL DEFAULT NULL COMMENT '上映季度',
  `promotional_image` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '宣传图',
  `avg_score` float(20, 1) NOT NULL COMMENT '总分',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '番剧表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_anime_link
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_anime_link`;
CREATE TABLE `shizuku_anime_link`  (
  `id` bigint NOT NULL COMMENT '主键',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `link` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '链接',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '番剧链接表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_announcement
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_announcement`;
CREATE TABLE `shizuku_announcement`  (
  `id` bigint NOT NULL COMMENT '主键',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_comments
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_comments`;
CREATE TABLE `shizuku_comments`  (
  `id` bigint NOT NULL COMMENT '主键',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_score
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_score`;
CREATE TABLE `shizuku_score`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `score` int NOT NULL COMMENT '分数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评分表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_sub
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_sub`;
CREATE TABLE `shizuku_sub`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订阅时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订阅表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_subtitle
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_subtitle`;
CREATE TABLE `shizuku_subtitle`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '字幕组名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字幕组表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_tag
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_tag`;
CREATE TABLE `shizuku_tag`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_visit
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_visit`;
CREATE TABLE `shizuku_visit`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '访问时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '访问表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shizuku_voice_actor
-- ----------------------------
DROP TABLE IF EXISTS `shizuku_voice_actor`;
CREATE TABLE `shizuku_voice_actor`  (
  `id` bigint NOT NULL COMMENT '主键',
  `anime_id` bigint NOT NULL COMMENT '番剧id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `link` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '介绍链接',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '声优表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `log_id` bigint NOT NULL COMMENT '主键',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类型',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_id` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL COMMENT '主键',
  `username` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `nickname` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '昵称',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gender` int NULL DEFAULT 1 COMMENT '性别，0：女，1：男，2: 其他',
  `head` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `state` int NULL DEFAULT 1 COMMENT '状态，0：禁用，1：启用，2：锁定',
  `role_type` int NULL DEFAULT NULL COMMENT '角色类型：0:超级管理员,1管理员,2：普通用户',
  `is_first_login` int NULL DEFAULT 1 COMMENT '是否第一次登陆：1：是，0：否',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
