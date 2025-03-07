--
-- CNG443 Java Final Exam DB
-- Database Schema and Sample Data
--

--
-- Creating cng443user account with password 1234
--

CREATE USER IF NOT EXISTS 'cng443user'@'localhost' IDENTIFIED BY '1234';


--
-- Creating Exam Database
--

CREATE DATABASE IF NOT EXISTS `Exam`;

--
-- Granting privileges to cng443user
--
GRANT ALL PRIVILEGES ON `Exam`.* TO 'cng443user'@'localhost';

--
-- Use this database to create the tables
--
USE `Exam`;


--
-- Table structure for table `Student`
--

CREATE TABLE Student(
                        id VARCHAR(5) NOT NULL,
                        name VARCHAR(40),
                        PRIMARY KEY(id)
);


--
-- Table structure for table `Internship`
--

CREATE TABLE Internship(
                           id VARCHAR(5) NOT NULL,
                           hasInternship VARCHAR(5),
                           status VARCHAR(20),
                           PRIMARY KEY (id),
                           FOREIGN KEY (hasInternship) REFERENCES Student(id)
);



--
-- Add Data for table `Student`
--

Insert into Student (id, name) values ('1', 'Robert Stevens');
Insert into Student (id, name) values ('2', 'Carole Goble');
Insert into Student (id, name) values ('3', 'Xena Xena');
Insert into Student (id, name) values ('4', 'Lonny Koschek');
Insert into Student (id, name) values ('5', 'Elizabet Fabbro');

--
-- Add Data for table `Internship`
--

Insert into Internship (id, hasInternship, status) values ('10', '1', 'Pass');
Insert into Internship (id, hasInternship, status) values ('20', '2', 'Fail');
Insert into Internship (id, hasInternship, status) values ('30', '3', 'Pass');
Insert into Internship (id, hasInternship, status) values ('40', '3', 'Pass');
Insert into Internship (id, hasInternship, status) values ('50', '4', 'Pass');
Insert into Internship (id, hasInternship, status) values ('60', '5', 'Pass');