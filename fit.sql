-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220503.92457c1607
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 25, 2022 at 05:29 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fit`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `BranchID` int(11) NOT NULL,
  `city` text NOT NULL,
  `location` text NOT NULL,
  `Bphone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`BranchID`, `city`, `location`, `Bphone`) VALUES
(666, 'riyadh', 'almalqa', 558543144),
(7770, 'riyadh', 'almalqa', 6667888),
(655555, 'damam', 'bahar', 877890),
(9999999, 'Alaraq', 'tmam', 6788841),
(111111111, 'Riyadh', 'jjj', 500223300),
(444444444, 'Makah', 'eee', 500889900),
(555555555, 'Dammam', 'almuruj', 500232300),
(555555556, 'hh', 'hjk', 85678),
(555555557, 'nn', 'k', 89);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `ID` int(11) NOT NULL,
  `MBranchID` int(11) NOT NULL,
  `DOB` text NOT NULL,
  `name` text NOT NULL,
  `Phone_num` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `height` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`ID`, `MBranchID`, `DOB`, `name`, `Phone_num`, `weight`, `height`) VALUES
(123, 444444444, '4/7/2022', 'sara', 993321, 90, 170),
(123991, 111111111, '4/3/2022', 'nada', 4788222, 70, 190),
(126661, 555555556, '20/2/2020', 'leena', 982681, 70, 170),
(44211028, 555555557, '30/8/2001', 'noor', 508988, 60, 169);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`BranchID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `xs` (`MBranchID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `BranchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=555555558;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=441220838;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `xs` FOREIGN KEY (`MBranchID`) REFERENCES `branch` (`BranchID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



