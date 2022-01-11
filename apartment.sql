/*!40101 SET NAMES utf8 */;
/*!40101 SET SQL_MODE=''*/;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`apartment` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `apartment`;

-- 1.学生
/*Table structure for table `students` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `name` char(10) NOT NULL COMMENT '姓名',
                           `gender` char(2) NOT NULL COMMENT '性别',
                           `birthday` char(15) NOT NULL COMMENT '出生日期',
                           `contact` char(11) NOT NULL COMMENT '联系方式',
                           `student_id` char(11) NOT NULL COMMENT '学号',
                           `college` char(20) NOT NULL COMMENT '学院',
                           `major` char(20) NOT NULL COMMENT '专业',
                           `classes` char(10) NOT NULL COMMENT '班级',
                           `building_id` char(10) NOT NULL COMMENT '楼号',
                           `dorm_id` char(10) NOT NULL COMMENT '宿舍号',
                           `bed_id` int(10) NOT NULL COMMENT '床号',
                           `status` smallint(1) NOT NULL DEFAULT '0' COMMENT '状态（0表示不在，1表示在）',
                           PRIMARY KEY (`student_id`),
                           UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('张道陵', '男', '2001-06-15', '15137187183', '20120820441', '计算机科学与技术学院', '大数据', '数据2001', '8', '110', 4, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('舒子易', '男', '2000-1-1', '15517183871', '1', '计算机科学与技术学院', '软件工程', '软件2001', '11', '518', 1, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('王骑', '男', '1998-10-12', '15623126367', '19023102010', '电子信息工程学院', '光电与信息工程系', '光信1902', 'Y1', '220', 1, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('樱木花道', '男', '2000-07-01', '15152245359', '19110103024', '计算机科学与技术学院', '计算机科学与技术', '计科1903', '11', '518', 2, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('蒙武', '男', '1999-10-10', '15998786878', '19112819687', '计算机科学与技术学院', '软件工程', '软件1901', 'Y1', '220', 2, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('张唐', '男', '2001-12-11', '18923213072', '20110123214', '材料科学与工程学院', '材料科学系', '材科2001', 'Y1', '220', 6, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('蒙珀', '女', '2002-11-21', '18238213214', '20110230102', '化学院', '化学', '化学2001', '2', '330', 2, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('杨端和', '女', '2001-08-12', '18232143231', '20110231013', '计算机科学与技术学院', '计算机科学与技术', '计科2001', '6', '523', 3, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('羌弦', '女', '2001-03-11', '18323132432', '20110320301', '机械工程学院', '机械电子工程', '电子2001', '6', '523', 4, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('紫夏', '女', '2001-03-13', '18932131311', '20110323140', '计算机科学与技术学院', '软件工程', '软件2001', '6', '523', 2, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('流川枫', '男', '2001-03-01', '18866956314', '20110407122', '车辆交通学院', '车辆工程', '车辆1902', 'Y1', '220', 4, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('三井寿', '男', '1999-12-06', '15613516684', '20110504011', '数学学院', '信息科学技术', '信科2003', '11', '518', 3, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('赵艺', '女', '2001-11-23', '18923214321', '20110504503', '电子信息工程学院', '信息与通讯工程系', '信通2003', '2', '330', 4, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('白金星', '男', '2000-01-21', '18232443214', '20110506032', '化学院', '化学', '化学2001', '8', '110', 1, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('王贲', '男', '2002-01-26', '15937783718', '20110506043', '机械工程学院', '机械电子工程', '电子2002', 'Y1', '220', 3, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('章神君', '男', '2002-03-29', '13232432144', '20110724042', '土木工程学院', '建筑电气与智能化', '建智2003', '8', '110', 5, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('嫦娥', '女', '2001-08-15', '15663213677', '20111145141', '能源与动力工程学院', '航空推进系', '航空2001', '2', '330', 1, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('李牧', '男', '2001-01-02', '18732132423', '20116243220', '人文社会科学学院', '军事心理学', '军心2001', '8', '110', 6, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('海音', '女', '2001-01-01', '13242434223', '20116252321', '人文社会科学学院', '军事心理学', '军心2001', '6', '523', 1, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('赤木晴子', '女', '2000-12-21', '15512556259', '20120101040', '计算机科学与技术学院', '计算机科学与技术', '计科1902', '2', '330', 3, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('李拖沓', '男', '2001-02-21', '15938216831', '20120234321', '土木工程学院', '房屋建筑', '建设2002', '8', '110', 2, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('王翦', '男', '2001-02-11', '18323214212', '20120321432', '机械工程学院', '机械电子工程', '电子2002', '11', '518', 4, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('王目酿', '男', '2001-04-13', '15629137819', '20120324017', '计算机科学与技术学院', '大数据', '数据2001', '8', '110', 3, 0);
INSERT INTO `student`(`name`, `gender`, `birthday`, `contact`, `student_id`, `college`, `major`, `classes`, `building_id`, `dorm_id`, `bed_id`, `status`) VALUES ('蒙恬', '男', '2001-09-19', '18912362183', '20123213142', '计算机科学与技术学院', '软件工程', '软件2001', 'Y1', '220', 5, 0);


-- 2.宿管
/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
                           `name` char(20) NOT NULL COMMENT '姓名',
                           `manager_id` char(11) NOT NULL COMMENT '员工号',
                           `contact` char(11) NOT NULL COMMENT '联系方式',
                           PRIMARY KEY (`manager_id`),
                           UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `manager`(`name`, `manager_id`, `contact`) VALUES ('张大爷', '2', '15055556666');
INSERT INTO `manager`(`name`, `manager_id`, `contact`) VALUES ('李叔叔', '30110521341', '19899251656');
INSERT INTO `manager`(`name`, `manager_id`, `contact`) VALUES ('王阿姨', '30120026375', '15059963163');
INSERT INTO `manager`(`name`, `manager_id`, `contact`) VALUES ('居里夫人', '30130434321', '18232744123');
INSERT INTO `manager`(`name`, `manager_id`, `contact`) VALUES ('姜子牙', '30142314553', '15932143531');


-- 3.登录
/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
                            `identity` int(1) NOT NULL COMMENT '身份(1：学生，2：宿管，3：超级管理员)',
                            `account` char(11) NOT NULL COMMENT '账号',
                            `password` char(50) NOT NULL DEFAULT '000' COMMENT '密码',
                            PRIMARY KEY (`account`),
                            UNIQUE KEY `UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '', '000');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '1', 'c4ca4238a0b923820dcc509a6f75849b');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '19023102010', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '19110103024', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '19112819687', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (2, '2', 'c81e728d9d4c2f636f067f89cc14862c');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110123214', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110230102', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110231013', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110320301', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110323140', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110407122', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110504011', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110504503', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110506032', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20110506043', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20111145141', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20116243220', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20116252321', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20120101040', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20120234321', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20120321432', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20120324017', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20120820441', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (1, '20123213142', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (2, '30110521341', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (2, '30120026375', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (2, '30130434321', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (2, '30142314553', '202cb962ac59075b964b07152d234b70');
INSERT INTO `register`(`identity`, `account`, `password`) VALUES (3, 'admin', '21232f297a57a5a743894a0e4a801fc3');


-- 4.宿舍
/*Table structure for table `dorm` */

DROP TABLE IF EXISTS `dorm`;

CREATE TABLE `dorm` (
                        `name` char(20) NOT NULL COMMENT '宿舍名',
                        `building_id` char(10) DEFAULT NULL COMMENT '楼号（4/Y1...）',
                        `dorm_id` char(10) DEFAULT NULL COMMENT '宿舍号（311/209...）',
                        `bed_num` int(2) DEFAULT NULL COMMENT '床位数',
                        `people_num` int(2) DEFAULT NULL COMMENT '人数',
                        `deposit` double DEFAULT 0 NOT NULL COMMENT '宿舍费用'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dorm`(`name`, `building_id`, `dorm_id`, `bed_num`, `people_num`, `deposit`) VALUES ('百草园', '11', '518', 4, 4, 1000);
INSERT INTO `dorm`(`name`, `building_id`, `dorm_id`, `bed_num`, `people_num`, `deposit`) VALUES ('三味书屋', '2', '330', 4, 3, 2000);
INSERT INTO `dorm`(`name`, `building_id`, `dorm_id`, `bed_num`, `people_num`, `deposit`) VALUES ('幸福屋', 'Y1', '220', 6, 6, 2350);
INSERT INTO `dorm`(`name`, `building_id`, `dorm_id`, `bed_num`, `people_num`, `deposit`) VALUES ('菩提树屋', '6', '523', 4, 4, 1200);
INSERT INTO `dorm`(`name`, `building_id`, `dorm_id`, `bed_num`, `people_num`, `deposit`) VALUES ('凌霄宝殿', '8', '110', 6, 6, 1500);


-- 5.楼宇
/*Table structure for table `building` */

DROP TABLE IF EXISTS `building`;

CREATE TABLE `building` (
                            `name` char(20) NOT NULL COMMENT '楼宇名',
                            `building_id` char(10) NOT NULL COMMENT '楼宇号（4/Y1...）',
                            `address` char(30) DEFAULT NULL COMMENT '位置',
                            `manager_id` char(11) NOT NULL COMMENT '楼宇管理员号',
                            PRIMARY KEY (`building_id`),
                            UNIQUE KEY `UNIQUE` (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `building`(`name`, `building_id`, `address`, `manager_id`) VALUES ('11号男生公寓', '11', '大学生艺术中心北50米', '30120026375');
INSERT INTO `building`(`name`, `building_id`, `address`, `manager_id`) VALUES ('2号女生公寓', '2', '第一餐厅东100米', '30120026375');
INSERT INTO `building`(`name`, `building_id`, `address`, `manager_id`) VALUES ('6号女生公寓', '6', '第三餐厅东南100米', '30130434321');
INSERT INTO `building`(`name`, `building_id`, `address`, `manager_id`) VALUES ('8号男生宿舍', '8', '大学生艺术中心南200米', '30142314553');
INSERT INTO `building`(`name`, `building_id`, `address`, `manager_id`) VALUES ('研究生1号男生公寓', 'Y1', '第二操场北35米', '30110521341');


-- 6.操作
/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
                       `log_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '操作号',
                       `account_id` char(11) NOT NULL COMMENT '用户id',
                       `type` int(1) NOT NULL COMMENT '（1：缴费，2：签入，3：签出）',
                       `building_id` char(10) DEFAULT NULL COMMENT '楼号（如有）',
                       `dorm_id` char(10) DEFAULT NULL COMMENT '宿舍号（如有）',
                       `payment_account` int(10) DEFAULT NULL COMMENT '缴费金额（如有）',
                       `date` datetime DEFAULT NULL COMMENT '操作日期',
                       PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `log`(`log_id`, `account_id`, `type`, `building_id`, `dorm_id`, `payment_account`, `date`) VALUES (NULL, '1', 1, '11', '518', 301, '2022-01-10 03:38:00');
INSERT INTO `log`(`log_id`, `account_id`, `type`, `building_id`, `dorm_id`, `payment_account`, `date`) VALUES (NULL, '1', 2, NULL, NULL, NULL, '2022-01-10 10:07:08');
INSERT INTO `log`(`log_id`, `account_id`, `type`, `building_id`, `dorm_id`, `payment_account`, `date`) VALUES (NULL, '1', 3, NULL, NULL, NULL, '2022-01-10 10:55:56');

