/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.27 : Database - user-center
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`user-center` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `user-center`;

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `text` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comments` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `type` int DEFAULT NULL,
  `tenant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'webApp',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `post` */

insert  into `post`(`pid`,`title`,`text`,`date`,`comments`,`uid`,`type`,`tenant_id`) values (1,'buaa','this is a test','2023-12-09 00:00:00',0,1,0,'webApp'),(5,'今天真高兴','哈哈哈哈哈哈哈哈哈哈哈哈哈','2023-12-09 13:31:49',0,1,1,'webApp');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `name` varchar(255) NOT NULL,
  `sex` tinyint NOT NULL,
  `age` int NOT NULL,
  `tenant_id` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `student` */

insert  into `student`(`name`,`sex`,`age`,`tenant_id`) values ('C罗',1,38,'webApp'),('zhangzhe',1,22,'webApp'),('梅西',1,36,'webApp');

/*Table structure for table `sys_fields` */

DROP TABLE IF EXISTS `sys_fields`;

CREATE TABLE `sys_fields` (
  `field_id` int NOT NULL AUTO_INCREMENT,
  `table_id` int NOT NULL,
  `field_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `data_type` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `is_nullable` tinyint(1) NOT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`field_id`),
  KEY `table_id` (`table_id`),
  CONSTRAINT `sys_fields_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `sys_tables` (`table_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sys_fields` */

insert  into `sys_fields`(`field_id`,`table_id`,`field_name`,`data_type`,`is_nullable`,`tenant_id`) values (1,1,'name','string',0,'webApp'),(2,1,'sex','string',0,'webApp'),(3,1,'age','int',0,'webApp'),(4,2,'name','string',0,'webApp'),(5,2,'price','int',0,'webApp'),(6,3,'id','long',0,'webApp'),(7,3,'code','string',0,'webApp'),(8,3,'name','string',0,'webApp'),(9,3,'data_scope','string',0,'webApp'),(10,3,'create_time','datetime',0,'webApp'),(11,3,'update_time','datetime',0,'webApp'),(12,3,'tenant_id','string',0,'webApp'),(13,3,'creator_id','string',0,'webApp'),(14,1,'tenant_id','string',0,'webApp'),(15,4,'pid','int',0,'webApp'),(16,4,'title','string',0,'webApp'),(17,4,'text','string',0,'webApp'),(18,4,'date','datetime',0,'webApp'),(19,4,'comments','int',0,'webApp'),(20,4,'uid','int',0,'webApp'),(21,4,'type','int',0,'webApp'),(22,4,'tenant_id','string',0,'webApp');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `path_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `css` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sort` int NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `type` tinyint(1) NOT NULL,
  `hidden` tinyint(1) NOT NULL DEFAULT '0',
  `tenant_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '租户字段',
  `creator_id` int DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`name`,`url`,`path`,`path_method`,`css`,`sort`,`create_time`,`update_time`,`type`,`hidden`,`tenant_id`,`creator_id`) values (2,12,'用户管理','#!user','system/user.html',NULL,'layui-icon-friends',2,'2017-11-17 16:56:59','2018-09-19 11:26:14',1,0,'webApp',1),(3,12,'角色管理','#!role','system/role.html',NULL,'layui-icon-user',3,'2017-11-17 16:56:59','2019-01-14 15:34:40',1,0,'webApp',1),(4,12,'菜单管理','#!menus','system/menus.html',NULL,'layui-icon-menu-fill',4,'2017-11-17 16:56:59','2018-09-03 02:23:47',1,0,'webApp',1),(9,37,'数据表管理','#!datasource','datasource/list.html',NULL,'layui-icon-file',3,'2017-11-17 16:56:59','2019-01-17 20:18:44',1,0,'webApp',1),(10,37,'文档中心','#!swagger','http://127.0.0.1:9900/doc.html',NULL,'layui-icon-app',4,'2017-11-17 16:56:59','2019-01-17 20:18:48',1,0,'webApp',1),(11,12,'我的信息','#!myInfo','system/myInfo.html',NULL,'layui-icon-login-qq',10,'2017-11-17 16:56:59','2018-09-02 06:12:24',1,0,'webApp',1),(12,-1,'认证管理','javascript:;','',NULL,'layui-icon-set',1,'2017-11-17 16:56:59','2018-12-13 15:02:49',1,0,'webApp',1),(35,12,'应用管理','#!app','attestation/app.html',NULL,'layui-icon-link',5,'2017-11-17 16:56:59','2019-01-14 15:35:15',1,0,'webApp',1),(37,-1,'系统管理','javascript:;','',NULL,'layui-icon-set',2,'2018-08-25 10:41:58','2019-01-23 14:01:58',1,0,'webApp',1),(62,63,'应用监控','#!admin','http://127.0.0.1:6500/#/wallboard',NULL,'layui-icon-chart-screen',4,'2019-01-08 15:32:19','2019-01-17 20:22:44',1,0,'webApp',1),(63,-1,'系统监控','javascript:;','',NULL,'layui-icon-set',2,'2019-01-10 18:35:05','2019-01-10 18:35:05',1,0,'webApp',1),(64,63,'系统日志','#!sysLog','log/sysLog.html',NULL,'layui-icon-file-b',1,'2019-01-10 18:35:55','2019-01-12 00:27:20',1,0,'webApp',1),(65,37,'代码生成器','#!generator','generator/list.html',NULL,'layui-icon-template',2,'2019-01-14 00:47:36','2019-01-23 14:06:31',1,0,'webApp',1),(66,63,'慢查询SQL','#!slowQueryLog','log/slowQueryLog.html',NULL,'layui-icon-snowflake',2,'2019-01-16 12:00:27','2019-01-16 15:32:31',1,0,'webApp',1),(67,-1,'任务管理','#!job','http://127.0.0.1:8081/',NULL,'layui-icon-date',3,'2019-01-17 20:18:22','2019-01-23 14:01:53',1,0,'webApp',1),(68,63,'应用吞吐量监控','#!sentinel','http://127.0.0.1:6999',NULL,'layui-icon-chart',5,'2019-01-22 16:31:55','2019-01-22 16:34:03',1,0,'webApp',1),(69,37,'配置中心','#!nacos','http://127.0.0.1:8848/nacos',NULL,'layui-icon-tabs',1,'2019-01-23 14:06:10','2019-01-23 14:06:10',1,0,'webApp',1),(70,63,'APM监控','#!apm','http://127.0.0.1:8080',NULL,'layui-icon-engine',6,'2019-02-27 10:31:55','2019-02-27 10:31:55',1,0,'webApp',1),(71,-1,'搜索管理','javascript:;','',NULL,'layui-icon-set',3,'2018-08-25 10:41:58','2019-01-23 15:07:07',1,0,'webApp',1),(72,71,'索引管理','#!index','search/index_manager.html',NULL,'layui-icon-template',1,'2019-01-10 18:35:55','2019-01-12 00:27:20',1,0,'webApp',1),(73,71,'用户搜索','#!userSearch','search/user_search.html',NULL,'layui-icon-user',2,'2019-01-10 18:35:55','2019-01-12 00:27:20',1,0,'webApp',1),(74,12,'Token管理','#!tokens','system/tokens.html',NULL,'layui-icon-unlink',6,'2019-07-11 16:56:59','2019-07-11 16:56:59',1,0,'webApp',1),(75,2,'用户列表','/api-user/users','user-list','GET',NULL,1,'2019-07-29 16:56:59','2019-07-29 16:56:59',2,0,'webApp',1),(76,2,'查询用户角色','/api-user/roles','user-roles','GET',NULL,2,'2019-07-29 16:56:59','2019-07-29 16:56:59',2,0,'webApp',1),(77,2,'用户添加','/api-user/users/saveOrUpdate','user-btn-add','POST',NULL,3,'2019-07-29 16:56:59','2019-07-29 16:56:59',2,0,'webApp',1),(78,2,'用户导出','/api-user/users/export','user-btn-export','POST',NULL,4,'2019-07-29 16:56:59','2019-07-29 16:56:59',2,0,'webApp',1),(79,2,'用户导入','/api-user/users/import','user-btn-import','POST',NULL,5,'2019-07-29 16:56:59','2019-07-29 16:56:59',2,0,'webApp',1),(80,-1,'用户管理','#!user','',NULL,NULL,1,'2019-08-06 20:02:13','2019-08-06 20:02:13',1,0,'zlt',1),(81,-1,'商品管理','#!product','',NULL,NULL,2,'2019-08-06 20:02:13','2019-08-06 20:02:13',1,0,'zlt',1),(82,-1,'支付管理','#!pay','',NULL,NULL,3,'2019-08-06 20:02:13','2019-08-06 20:02:13',1,0,'zlt',1),(83,-1,'交易管理','#!trading','',NULL,NULL,4,'2019-08-06 20:02:13','2019-08-06 20:02:13',1,0,'zlt',1),(84,-1,'系统管理','#!system','',NULL,NULL,1,'2019-08-06 20:02:13','2019-08-06 20:02:13',1,0,'app',1),(85,63,'审计日志','#!auditLog','log/auditLog.html',NULL,'layui-icon-file-b',3,'2020-02-04 12:00:27','2020-02-04 15:32:31',1,0,'webApp',1),(86,37,'评论审核','#!review','review/comments.html',NULL,'layui-icon-file',5,'2023-12-04 15:13:34','2023-12-04 15:13:37',1,0,'webApp',1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色code',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名',
  `data_scope` varchar(32) COLLATE utf8mb4_general_ci DEFAULT 'ALL' COMMENT '数据权限范围配置：ALL/全部权限，CREATOR/创建者权限',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `tenant_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '租户字段',
  `creator_id` int DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`),
  KEY `idx_code` (`code`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`code`,`name`,`data_scope`,`create_time`,`update_time`,`tenant_id`,`creator_id`) values (1,'ADMIN','管理员','ALL','2023-11-30 17:14:43','2023-11-30 17:14:43','webApp',1),(6,'developer','开发','ALL','2023-12-02 19:14:43','2023-12-02 19:14:47','webApp',1),(7,'operator','运营','ALL','2023-12-02 19:16:16','2023-12-02 19:16:19','webApp',1);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` int NOT NULL,
  `menu_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (1,2),(1,3),(1,4),(1,9),(1,10),(1,11),(1,12),(1,35),(1,37),(1,62),(1,63),(1,64),(1,65),(1,66),(1,67),(1,68),(1,69),(1,70),(1,71),(1,72),(1,73),(1,74),(1,75),(1,76),(1,77),(1,78),(1,79),(1,85),(2,2),(2,3),(2,4),(2,11),(2,12),(2,35),(3,2),(3,3),(3,4),(3,12),(4,80),(4,81),(4,82),(4,83),(5,84),(6,9),(6,11),(6,12),(6,37),(6,65),(7,11),(7,12),(7,37),(7,86);

/*Table structure for table `sys_role_user` */

DROP TABLE IF EXISTS `sys_role_user`;

CREATE TABLE `sys_role_user` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_role_user` */

insert  into `sys_role_user`(`user_id`,`role_id`) values (1,1),(2,1),(7,2),(8,2),(9,3),(10,3),(11,4),(12,5),(27,2),(28,6),(29,7);

/*Table structure for table `sys_tables` */

DROP TABLE IF EXISTS `sys_tables`;

CREATE TABLE `sys_tables` (
  `table_id` int NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tenant_id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `table_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sys_tables` */

insert  into `sys_tables`(`table_id`,`table_name`,`tenant_id`,`table_description`) values (1,'student','webApp','student table'),(2,'food','webApp','food table'),(3,'sys_role','webApp','system role'),(4,'post','webApp','post table');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `head_img_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `open_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  `creator_id` int DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_mobile` (`mobile`),
  KEY `idx_open_id` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`nickname`,`head_img_url`,`mobile`,`sex`,`enabled`,`type`,`create_time`,`update_time`,`company`,`open_id`,`is_del`,`creator_id`) values (2,'user','$2a$10$OhfZv4VQJiqMEukpf1qXA.V7UMiHjr86g6lJqPvKUoHwrPk35steG','体验用户','https://img1.baidu.com/it/u=2774478026,308641059&fm=253&fmt=auto&app=138&f=JPEG?w=256&h=256','18888888887',1,1,'APP','2023-11-28 16:56:59','2023-11-28 16:56:59','ENGJ',NULL,0,1),(3,'test','$2a$10$RD18sHNphJMmcuLuUX/Np.IV/7Ngbjd3Jtj3maFLpwaA6KaHVqPtq','测试账户','http://payo7kq4i.bkt.clouddn.com/QQ%E5%9B%BE%E7%89%8720180819191900.jpg','13851539156',0,1,'APP','2017-11-17 16:56:59','2023-12-13 14:01:44','ENGJ',NULL,1,1),(27,'123','{bcrypt}$2a$10$AtCRuqlYLdaXecfLICTBNugAVkSxQd9RHMrxuKuK9k1GEF7S7hgdq','张哲',NULL,'11111111111',0,1,'BACKEND','2023-11-30 16:37:28','2023-11-30 16:37:28',NULL,NULL,0,1),(28,'TieBa_A','$2a$10$TJkwVdlpbHKnV45.nBxbgeFHmQRmyWlshg94lFu2rKxVtT2OMniDO','TieBa_A',NULL,'12345678999',0,1,'BACKEND','2023-12-02 20:04:20','2023-12-02 20:04:23','ENGJ',NULL,0,1),(29,'TieBa_B','$2a$10$TJkwVdlpbHKnV45.nBxbgeFHmQRmyWlshg94lFu2rKxVtT2OMniDO','TieBa_B',NULL,'12345678999',0,1,'BACKEND','2023-12-04 15:18:37','2023-12-04 15:18:39','ENGJ',NULL,0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
