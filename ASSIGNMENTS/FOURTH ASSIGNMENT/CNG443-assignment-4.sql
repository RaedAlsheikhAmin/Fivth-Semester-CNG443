--
-- User: `CNG443user`
--
CREATE USER IF NOT EXISTS 'cng443user'@'localhost' IDENTIFIED BY '1234';


--
-- Database: `BasicDB`
--
CREATE DATABASE IF NOT EXISTS `BasicDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- Give all privileges to CNG443user on this database
--
GRANT ALL PRIVILEGES ON `BasicDB`.* TO 'cng443user'@'localhost';


--
-- Use this database to create the tables
--
USE `BasicDB`;


--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userID` int(6) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `firstName` char(50) NOT NULL,
  `lastName` char(50) NOT NULL,
  `registrationDate` date NOT NULL,
  `type` char(1) NOT NULL,
  `preferredPaymentMethod` char(50),
  `taxNumber` double,
  `goldLevel` int(11) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Property`
--

CREATE TABLE `Property` (
  `propertyID` int(11) NOT NULL,
  `noBedRooms` int(11) NOT NULL,
  `noRooms` int(11) NOT NULL,
  `city` char(50) NOT NULL,
  `pricePerDay` double NOT NULL,
  `type` char(1) NOT NULL,
  `propertySize` double
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `Property`
--
ALTER TABLE `Property`
  ADD PRIMARY KEY (`propertyID`);