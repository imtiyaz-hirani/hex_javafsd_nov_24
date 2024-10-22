use fsd_oct_sms_db;

-- Insert into department
INSERT INTO department (id, name) VALUES (1, 'Computer Science');
INSERT INTO department (id, name) VALUES (2, 'Electrical Engineering');
 
-- Insert into course
INSERT INTO course (id, name, credits, department_id) VALUES (1, 'Spring Boot', '3', 1);
INSERT INTO course (id, name, credits, department_id) VALUES (2, 'AWS Services', '3', 1);
INSERT INTO course (id, name, credits, department_id) VALUES (3, 'Circuit Analysis', '4', 2);
 
-- Insert into instructor
INSERT INTO instructor (id, name, salary, contact) VALUES (1, 'John Doe', '70000', '555-1234');
INSERT INTO instructor (id, name, salary, contact) VALUES (2, 'Jane Smith', '80000', '555-5678');
 
-- Insert into course_instructor
INSERT INTO course_instructor (course_id, instructor_id, batch, month, year) VALUES (1, 1, 'A', 'August', '2024');
INSERT INTO course_instructor (course_id, instructor_id, batch, month, year) VALUES (2, 1, 'B', 'August', '2024');
INSERT INTO course_instructor (course_id, instructor_id, batch, month, year) VALUES (3, 2, 'C', 'August', '2024');
 
-- Insert into address
INSERT INTO address (id, state, city) VALUES (1, 'California', 'Los Angeles');
INSERT INTO address (id, state, city) VALUES (2, 'California', 'Los Angeles');
INSERT INTO address (id, state, city) VALUES (3, 'New York', 'New York City');
 
-- Insert into user
INSERT INTO user (id, username, password, role) VALUES (1, 'student1', 'pass123', 'student');
INSERT INTO user (id, username, password, role) VALUES (2, 'student2', 'pass456', 'student');
INSERT INTO user (id, username, password, role) VALUES (3, 'student3', 'pass789', 'student');
 
-- Insert into student
INSERT INTO student (id, name, contact, user_id, address_id) VALUES (1, 'Alice Johnson', '555-0011', 1, 1);
INSERT INTO student (id, name, contact, user_id, address_id) VALUES (2, 'Bob Williams', '555-0022', 2, 2);
INSERT INTO student (id, name, contact, user_id, address_id) VALUES (3, 'Charlie Brown', '555-0033', 3, 3);
 
-- Insert into student_course (Many-to-Many between student and course)
INSERT INTO student_course (student_id, course_id, date_of_enroll) VALUES (1, 1, '2024-10-01');
INSERT INTO student_course (student_id, course_id, date_of_enroll) VALUES (1, 2, '2024-10-01');
INSERT INTO student_course (student_id, course_id, date_of_enroll) VALUES (2, 1, '2024-10-02');
INSERT INTO student_course (student_id, course_id, date_of_enroll) VALUES (2, 3, '2024-10-02');
INSERT INTO student_course (student_id, course_id, date_of_enroll) VALUES (3, 3, '2024-10-03');

update student SET address_id=1 where id=2;
delete from address where id=2;

-- Display student_name, course_name, date_of_enrollment of course enrolled by student living in city 'Los Angeles'
DELIMITER $$
create procedure fetch_info_by_city(IN pcity varchar(255))
BEGIN
select  s.name, c.name, sc.date_of_enroll , c.credits
from address a, student s, student_course sc, course c
where a.id = s.address_id 
	 AND sc.student_id = s.id 
     AND c.id = sc.course_id 
     AND a.city='Los Angeles';
END
$$

CALL fetch_info_by_city('Los Angeles');

/* update job_title of given instructor depending upon following criteria: 
	salary > 100000 : 'Associate Prof'
    salary >= 75000 : 'Asst Prof'
    salary < 75000 : 'Lecturer'
*/
DELIMITER $$
create procedure update_instructor_job_profile(IN pid int)
BEGIN
	declare psal double; 
     
    select salary into psal 
    from instructor 
    where id = pid; 
    
    if psal >= 100000 then
		 update instructor SET job_title ='Associate Prof' where id=pid;
    end if; 
    if psal >= 75000 AND psal < 100000 then
		 update instructor SET job_title ='Asst Prof' where id=pid;
    end if; 
	 if psal < 75000 then
		 update instructor SET job_title ='Lecturer' where id=pid;
    end if; 
END
$$

drop procedure update_instructor_job_profile;
CALL update_instructor_job_profile(1);
CALL update_instructor_job_profile(2);
CALL update_instructor_job_profile(5);

/*
CAP to display all Ids of Instructor table
*/ 
DELIMITER $$
create procedure display_ids_instructor()
BEGIN
	declare i int default 0;
    declare len int; 
    declare pid int; 
    declare str text default '';
    
    select count(*) into len 
    from instructor; 
    -- i= 0,1  len = 2
    while i< len DO
		 select id into pid from instructor limit i,1;
         set str = concat(str,pid, ' '); 
       SET i = i+1;
    END while; 
    select str;
END; 
$$

CALL display_ids_instructor();
drop procedure display_ids_instructor;

/* update job_title of all instructor depending upon following criteria: 
	salary > 100000 : 'Associate Prof'
    salary >= 75000 : 'Asst Prof'
    salary < 75000 : 'Lecturer'
*/

delimiter $$
create procedure update_instructor_profile()
begin
	declare i int default 0;   -- for while loop 
    declare len int; -- for total number of records in instructor table 
    declare pid int; -- for saving each id temporarily for updation 
	declare psal double; -- for saving instructor salary
    
	select count(*) into len  from instructor;  -- total number of records to be updated 
	
    while i< len do   -- loop to perform update on all rows 
		select id into pid from instructor limit i,1;   -- fetch id of 1 row at a time starting from 1st row 
        
        select salary into psal  -- saves salary into psal of current row 
		from instructor 
		where id = pid; 
        -- for this selected id update job_profile 
        if psal >= 100000 then
			update instructor SET job_title ='Associate Prof' where id=pid;
		end if; 
		if psal >= 75000 AND psal < 100000 then
			update instructor SET job_title ='Asst Prof' where id=pid;
		end if; 
		if psal < 75000 then
			update instructor SET job_title ='Lecturer' where id=pid;
		end if; 
        -- alternatively, we can also save this job_profle into variable and write the query only once
        SET i=i+1;
    end while;
end;
$$

DROP PROCEDURE update_instructor_profile;
call update_instructor_profile();

/*
CAP to fetch details of all students along with their username and city that are associated with given department 
Hint: use manual mapping technique 
*/
DELIMITER $$
create procedure fetch_students_by_department(IN pdept text)
BEGIN
select distinct s.*,u.username,a.city
from student s, student_course sc, course c , department d, user u, address a
where s.id = sc.student_id 
AND sc.course_id = c.id 
AND c.department_id = d.id
AND u.id = s.user_id
AND s.address_id = a.id
AND d.name=pdept;
END;
$$
CALL fetch_students_by_department('Computer Science');

-- fetch details of all students along with their username and city that are associated with given department
select distinct s.*,u.username,a.city
from student s 
JOIN student_course sc ON s.id = sc.student_id
JOIN course c ON sc.course_id = c.id 
JOIN department d ON d.id = c.department_id 
JOIN user u ON u.id = s.user_id
JOIN address a ON a.id = s.address_id
where  d.name='Computer Science';

-- fetch all students who are taught by given instructor. CAP to take instructor name as IN param. USE: JOIN 
delimiter $$
create procedure fetch_student_by_instructor(IN pname text)
begin
select distinct s.* 
from student s join student_course sc ON s.id = sc.student_id
join course c ON sc.course_id = c.id 
join course_instructor ci ON c.id = ci.course_id 
join instructor i on ci.instructor_id = i.id 
where i.name=pname;
end
$$
CALL fetch_student_by_instructor('Jane Smith');

-- CURSORS

-- display all students using cursor. 
DELIMITER $$
create procedure fetch_students_cursor()
begin
	declare sid int; 
    declare sname varchar(255);
    declare done int default 0;
    
	declare student_cur cursor  FOR
				select id,name from student ; -- query into cursor 
	
	-- declare a handler and udate/set the prop done(0/1). 
    -- when the cursor reaches the last row while iterating update done to 1 until then it will be 0 
	declare continue handler FOR NOT FOUND SET done=1;
    -- open cursor
    OPEN student_cur;
    my_loop:
    LOOP 
		FETCH student_cur into sid,sname;
        if done then   -- if done is 1 u leave 
			leave my_loop;
		end if; 
        select sid,sname;   -- stay in loop and display 
    END LOOP;
    -- close cursor 
    close student_cur; 
end
$$
CALL fetch_students_cursor();


/* update job_title of all instructor depending upon following criteria: 
	salary > 100000 : 'Associate Prof'
    salary >= 75000 : 'Asst Prof'
    salary < 75000 : 'Lecturer'
    
    Use cursor. 
*/
delimiter $$
create procedure instructor_job_title_update_cur()
begin
	declare pid int; 
    declare done int default 0; -- initial value is 0 
    declare psal double;
    -- declare cursor 
    declare inst_cur cursor  FOR 
		select id  from instructor ; -- all ids of instructor into cursor 
	
    -- cursor handler 
    declare continue handler FOR NOT FOUND SET done=1; -- when id is not found then done will be 1
    
    -- OPEN cursor 
    OPEN inst_cur;
    my_loop: 
		LOOP 
			FETCH inst_cur into pid;
        if done then   -- if done is 1 u leave 
			leave my_loop;
		end if; 
        -- update job_title her for this pid befoe the loop goes up again to second row 
         select salary into psal  -- saves salary into psal of current row 
		from instructor 
		where id = pid; 
        -- for this selected id update job_profile 
        if psal >= 100000 then
			update instructor SET job_title ='Associate Prof' where id=pid;
		end if; 
		if psal >= 75000 AND psal < 100000 then
			update instructor SET job_title ='Asst Prof' where id=pid;
		end if; 
		if psal < 75000 then
			update instructor SET job_title ='Lecturer' where id=pid;
		end if; 
        END LOOP; 
    -- CLOSE cursor 
    CLOSE inst_cur; 
end; 
$$
-- mysql> update instructor SET job_title='';-- do this in DB to reset job_title 
CALL instructor_job_title_update_cur();

/*
RESULT OF PROC: 
+----+------------+--------+----------+-----------+
| id | name       | salary | contact  | job_title |
+----+------------+--------+----------+-----------+
|  1 | John Doe   | 70000  | 555-1234 | Lecturer  |
|  2 | Jane Smith | 80000  | 555-5678 | Asst Prof |
+----+------------+--------+----------+-----------+
*/








