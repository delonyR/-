CREATE TABLE `school`.`student`( `stu_id` INT(9) UNSIGNED NOT NULL COMMENT '学生学号', `name` VARCHAR(60) NOT NULL COMMENT '学生姓名', `sex` VARCHAR(1) NOT NULL COMMENT '学生性别', `age` INT(3) UNSIGNED NOT NULL COMMENT '学生年龄', `class` VARCHAR(5) NOT NULL COMMENT '学生班级（几年几班）', PRIMARY KEY (`stu_id`) ) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;
CREATE TABLE `school`.`teacher`( `t_id` INT(9) UNSIGNED NOT NULL COMMENT '教工号', `name` VARCHAR(60) NOT NULL COMMENT '教师姓名', `sex` VARCHAR(1) NOT NULL COMMENT '教师性别', `age` INT(3) UNSIGNED NOT NULL COMMENT '教师年龄', `class` VARCHAR(5) COMMENT '执教班级（几年几班）', PRIMARY KEY (`t_id`) ) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci; 
INSERT INTO `school`.`student` (`stu_id`, `name`, `sex`, `age`, `class`) VALUES ('221900406', '绮珺尘', '男', '14', '八年四班'); 
INSERT INTO `school`.`teacher` (`t_id`, `name`, `sex`, `age`, `class`) VALUES ('114523657', 'Mr.yao', '男', '35', '九年七班'); 
INSERT INTO `school`.`student` (`stu_id`, `name`, `sex`, `age`, `class`) VALUES ('221900444', '陈俊琦', '男', '15', '九年七班'); 
DELETE FROM `school`.`student` WHERE `stu_id` = '221900406'; 
UPDATE `school`.`student` SET `stu_id` = '221900406' WHERE `stu_id` = '221900444';
SELECT * FROM student;