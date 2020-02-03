

insert into course(id, name, created_date, last_updated_date)
	values(10001, 'Ciências da Computação', sysdate(), sysdate());
	
insert into course(id, name, created_date, last_updated_date)
	values(10002, 'Análise e Desenvolvimento de Sistemas', sysdate(), sysdate());
	
insert into course(id, name, created_date, last_updated_date)
	values(10003, 'Enfermagem', sysdate(), sysdate());

	

insert into passport(id, number)values(30001, 'E1234569'); 
insert into passport(id, number)values(30002, 'L4254565');
insert into passport(id, number)values(30003, 'H3236562');
 
 
insert into student(id, name, passport_id)values(20001, 'Jão Silva', 30001);
insert into student(id, name, passport_id)values(20002, 'Leonardo Silva Souza', 30002);
insert into student(id, name, passport_id)values(20003, 'Luca Silva e Silva', 30003);

 
 
insert into review(id, description, rating, course_id)values(40001, 'It is beautiful course', '4', 10001);
insert into review(id, description, rating, course_id)values(40002, 'It is awful course', '1', 10001);
insert into review(id, description, rating, course_id)values(40003, 'It is boring course', '2', 10002);


insert into student_course(student_id, course_id)values(20001,10001);
insert into student_course(student_id, course_id)values(20002,10001);
insert into student_course(student_id, course_id)values(20003,10001);
insert into student_course(student_id, course_id)values(20001,10003);