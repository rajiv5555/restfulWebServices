# SpringBootStructure
Swagger,Logger,Exception handling,Monitoring

#Added support of rest and graphQL
http://localhost:8060/gui

#this is not schema based approach.

#mysql table

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` text CHARACTER SET latin1 COLLATE latin1_general_cs,
  `school_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

select * from student;
insert into student values(3,"rajiv","delhi","dav");
