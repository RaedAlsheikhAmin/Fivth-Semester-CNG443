--
-- CNG443 Java Sample DB       
-- Database Schema and Sample Data 
--

--
-- Creating cng443user account with password 1234
--

CREATE USER IF NOT EXISTS 'cng443user'@'localhost' IDENTIFIED BY '1234';


--
-- Creating Exam Database
--

CREATE DATABASE IF NOT EXISTS `Test`;

--
-- Granting privileges to cng443user
--
GRANT ALL PRIVILEGES ON `Test`.* TO 'cng443user'@'localhost';


--
-- Use this database to create the tables
--
USE `Test`;


--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `eno` int(11) NOT NULL,
  `etitle` varchar(50) DEFAULT NULL,
  `timeAllowed` int(11) DEFAULT NULL,
  `numberOfQuestionsPerPage` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`eno`, `etitle`, `timeAllowed`, `numberOfQuestionsPerPage`) VALUES
(3, 'Hello World', 10, 3),
(4, 'Java', 4, 2),
(6, 'struct', 2, 2),
(7, 'struct2', 2, 2),
(14, 'struct3', 20, 14),
(20, 'C', 20, 100);
