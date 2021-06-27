

insert into course(id,name, created_date, last_updated_date)
values(1001,'English',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(1002,'Science',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(1003,'Maths',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(1004,'Micro',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(1005,'SST',sysdate(),sysdate());
insert into course(id,name, created_date, last_updated_date)
values(1006,'CSC',sysdate(),sysdate());


insert into passport(id,number)
values(4001,'IND1');
insert into passport(id,number)
values(4002,'IND2');
insert into passport(id,number)
values(4003,'IND3');


insert into student(id,name,passport_id)
values(2001,'Piyush',4001);
insert into student(id,name,passport_id)
values(2002,'Ankita',4002);
insert into student(id,name,passport_id)
values(2003,'Dexter',4003);


insert into review(id,rating, desc, course_id)
values(5001,5,'Great',1001);
insert into review(id,rating, desc, course_id)
values(5002,4,'Good',1001);
insert into review(id,rating, desc, course_id)
values(5003,3,'Average',1003);

insert into student_course(student_id,course_id)
values(2001,1001);
insert into student_course(student_id,course_id)
values(2002,1001);
insert into student_course(student_id,course_id)
values(2003,1001);
insert into student_course(student_id,course_id)
values(2001,1003);