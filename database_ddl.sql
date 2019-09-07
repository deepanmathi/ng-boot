DROP SCHEMA IF EXISTS `student_course`;
CREATE SCHEMA `student_course`;
use `student_course`;
DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`title`)
) ;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `grade` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FK_STUDENT_id` (`student_id`),
  CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ;
insert into student values(1,"Deepan","Prakash","deepan@gmail.com");
insert into student values(2,"John","Walter","john@gmail.com");

insert into course values(101,"Maths");
insert into course values(102,"science");
insert into course values(103,"physics");

insert into  course_student values (101,1,"A");
insert into  course_student values (102,1,"B+");

insert into  course_student values (102,2,"A+");
insert into  course_student values (103,2,"C");

commit;

