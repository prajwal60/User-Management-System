-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2020 at 07:39 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `history_id` int(6) NOT NULL,
  `user_id` int(6) NOT NULL,
  `time` varchar(30) NOT NULL,
  `action_performed` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`history_id`, `user_id`, `time`, `action_performed`) VALUES
(94, 34, '2020-06-09T23:22:59.598123', 'Test Ran for history');

-- --------------------------------------------------------

--
-- Table structure for table `userdb`
--

CREATE TABLE `userdb` (
  `user_id` int(6) NOT NULL,
  `user_firstname` varchar(20) NOT NULL,
  `user_lastname` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `user_email` varchar(40) NOT NULL,
  `user_gender` varchar(6) NOT NULL,
  `user_birthdate` varchar(30) NOT NULL,
  `user_password` varchar(32) NOT NULL,
  `user_is_admin` varchar(5) NOT NULL,
  `user_created_date` varchar(30) NOT NULL,
  `user_blocked_status` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdb`
--

INSERT INTO `userdb` (`user_id`, `user_firstname`, `user_lastname`, `username`, `user_email`, `user_gender`, `user_birthdate`, `user_password`, `user_is_admin`, `user_created_date`, `user_blocked_status`) VALUES
(34, 'Prabesh', 'Guragain', 'root', 'p@ggg', 'male', '2020-04-28', '25d55ad283aa400af464c76d713c07ad', 'true', '2020-06-09', 'false'),
(35, 'Prabesh', 'Guragain', 'user', 'u@ser', 'male', '2020-04-28', '25d55ad283aa400af464c76d713c07ad', 'false', '2020-06-09', 'false'),
(36, 'Dummy', 'Account', 'dummy', 'dumdum@dummy', 'male', '2020-04-28', '25d55ad283aa400af464c76d713c07ad', 'false', '2020-06-09', 'false');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`history_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `userdb`
--
ALTER TABLE `userdb`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `history_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT for table `userdb`
--
ALTER TABLE `userdb`
  MODIFY `user_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `userdb` (`user_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
