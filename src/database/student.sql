create database student;
use student;
create table student (
        id int(3) NOT NULL AUTO_INCREMENT,
        Name varchar(120) NOT NULL,
        DateOfBirth date NOT NULL,
        Email varchar(225) NOT NULL,
        Address varchar(225) NOT NULL,
        Phone int NOT NULL,
        PRIMARY KEY (id),
        Class_id INT,
        FOREIGN KEY (class_id) REFERENCES classroom(id)
);


CREATE TABLE classroom (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255)
);

insert into student(Name, DateOfBirth, Email, Address,Phone, Class_id) values
('Tráng', '1999-12-03', 'dinh1@gmail.com', 'HY', '0987688961', 1),
('Tráng1', '1999-12-03', 'dinh2@gmail.com', 'HY', '0987688962', 1),
('Tráng2', '1999-12-03', 'dinh3@gmail.com', 'HY', '0987688963', 2),
('Tráng3', '1999-12-03', 'dinh4@gmail.com', 'HY', '0987688964', 2);

insert into classroom (name) values
    ('C0823H1'),
    ('C0923H5');

# chọn tất cả
SELECT student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name
FROM student
         JOIN classroom ON student.class_id = classroom.id;

# chọn theo id
SELECT student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name
FROM student
         JOIN classroom ON student.class_id = classroom.id
WHERE student.id = 5;

#Tìm theo ten
SELECT student.id, student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name
                FROM student
                    JOIN classroom ON student.class_id = classroom.id
                WHERE student.name LIKE '%T%';