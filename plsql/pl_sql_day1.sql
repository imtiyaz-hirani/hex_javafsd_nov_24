-- create the DB 
create database fsd_oct_sample_db;
-- display all DBs
show databases; 

-- select the DB
use fsd_oct_sample_db;

-- create table 
create table employee
(id int primary key auto_increment,
name varchar(255) not null,
email varchar(255) not null unique,
city varchar(255) default 'chennai',
department varchar(255) ,
salary double default 0); 

-- check table structure
describe employee;

insert into employee(name,email,city,department,salary) 
values 
('harry potter', 'harry@gmail.com', 'london', 'magic', 98000),
('ronald weasley', 'ron@gmail.com', 'surrey', 'admin', 88000),
('hermione granger', 'hermione@gmail.com', 'london', 'magic', 118000);
 
 DELIMITER $$
-- wap to display all employee records 
create procedure fetch_employee_data()
BEGIN
	select * from employee;
END
$$

-- list out all procedures 
show procedure status where Db='fsd_oct_sample_db';

-- call this proc 
CALL fetch_employee_data();

/*
	CAP to fetch employee records based on given city 
*/
DELIMITER $$
create procedure fetch_employee_by_city(IN pcity varchar(255))
BEGIN
	select * from employee where city=pcity;
END
$$
-- call this proc 
CALL fetch_employee_by_city('london');
CALL fetch_employee_by_city('surrey');

-- drop the procedure 
drop procedure fetch_employee_by_city;

/*
	WAP to fetch number of employees based on given department 
*/
DELIMITER $$
create procedure employee_count_by_department(IN pdept varchar(255), OUT pcount INT)
BEGIN
	select count(id) into pcount
    from employee
    where department = pdept; 
END
$$

-- call the proc
CALL  employee_count_by_department('admin', @emp_count);
select @emp_count; 

/*
	WAP to update the salary of employee on the basis of given ID and new_salary. Use INOUT param
*/
DELIMITER //
create procedure update_employee_salary(INOUT pemp_id INT, INOUT pemp_salary double)
BEGIN
	-- update the salary
    update employee
    SET salary = pemp_salary
    where id = pemp_id;
    
    -- set id and new salary value in variables 
    select id,salary into pemp_id,pemp_salary
    from employee 
    where id = pemp_id;
    
END;
//

-- call proc
SET @emp_id = 1; 
SET @emp_salary = 99000;
CALL update_employee_salary(@emp_id,@emp_salary);
select @emp_id,@emp_salary;

select city,count(*) as num_employee 
from employee
where city NOT IN ('paris','mumbai')
group by city 
having num_employee > 1
order by  num_employee DESC; 

-- min, max, sum, count, avg 
/*
city: london   2
|  1 | harry potter     | harry@gmail.com    | london | magic      |  99000 |
|  3 | hermione granger | hermione@gmail.com | london | magic      | 118000 |

city: surrey  1
|  2 | ronald weasley   | ron@gmail.com      | surrey | admin      |  88000 |
*/
-- having is used in queries to give condition on grouping functons. 
-- where clause comes before group by and having can be after group by. 

/*
 cap TO TAKE number_of_emp AS INPUT and give count of each city that has records more than number_of_emp. 
*/
DELIMITER $$
CREATE PROCEDURE count_emp_by_city(IN pnumber_of_emp INT)
BEGIN
SELECT city, COUNT(id) AS number_of_emp
FROM employee
GROUP BY city
HAVING number_of_emp>pnumber_of_emp;
END
$$
 
 drop procedure count_emp_by_city;
-- calling the procedure
CALL count_emp_by_city(1);

/* 
 CAP to display all employee records and rank them based on salary. [hint: use RANK()]
*/
DELIMITER $$
create procedure fetch_emp_by_rank_on_sal()
BEGIN
	SELECT id,name,salary,RANK() over (order by salary DESC) As EMP_RANK
    from employee; 
END;
$$

drop procedure fetch_emp_by_rank_on_sal;

CALL fetch_emp_by_rank_on_sal();











