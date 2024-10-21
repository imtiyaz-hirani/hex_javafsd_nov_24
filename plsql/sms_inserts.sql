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