-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 21, 2017 at 12:07 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onlinequiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `accountrole`
--

DROP TABLE IF EXISTS `accountrole`;
CREATE TABLE IF NOT EXISTS `accountrole` (
  `accountid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`accountid`,`roleid`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) NOT NULL,
  `questionid` int(11) NOT NULL,
  `istrue` tinyint(1) NOT NULL,
  `isStudent` tinyint(1) DEFAULT NULL,
  `prefix` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questionid` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `content`, `questionid`, `istrue`, `isStudent`, `prefix`) VALUES
(1, 'sadhusad', 11, 0, 0, 'a'),
(2, 'iadi', 11, 0, 0, 'b'),
(3, 'ijiodji', 11, 0, 0, 'c'),
(4, 'iiii', 11, 0, 0, 'd'),
(5, 'abc 1', 4, 1, 0, 'a'),
(6, 'abc2', 4, 0, 0, 'b'),
(7, 'abc3', 4, 0, 0, 'c'),
(8, 'abc4', 4, 0, 0, 'd'),
(9, 'a1', 8, 1, 0, 'a'),
(10, 'a2', 8, 0, 0, 'b'),
(11, 'b1', 9, 0, 0, 'c'),
(12, 'b2', 9, 1, 0, 'd'),
(13, 'c1', 10, 1, 0, 'e'),
(14, 'c2', 10, 0, 0, 'f');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Category 1'),
(2, 'Toan');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryid` (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `name`, `categoryid`, `time`) VALUES
(1, 'Toan1', 2, '00:40:00');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `grade` float NOT NULL,
  `questiontypeid` int(11) NOT NULL,
  `examid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questiontypeid` (`questiontypeid`),
  KEY `examid` (`examid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `content`, `grade`, `questiontypeid`, `examid`) VALUES
(4, '1 + 1 = ?', 1, 1, 1),
(8, 'test content1 ', 1, 1, 1),
(9, 'test answr 1', 1, 1, 1),
(10, 'saydy', 1, 1, 1),
(11, 'TTTTTTTTTTTTTT', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `questiontype`
--

DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE IF NOT EXISTS `questiontype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questiontype`
--

INSERT INTO `questiontype` (`id`, `name`) VALUES
(1, 'question Type 1');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE IF NOT EXISTS `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `questionid` int(11) NOT NULL,
  `answerid` int(11) NOT NULL,
  `examid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `questionid` (`questionid`),
  KEY `answerid` (`answerid`),
  KEY `examid` (`examid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accountrole`
--
ALTER TABLE `accountrole`
  ADD CONSTRAINT `accountrole_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `accountrole_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `question` (`id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`questiontypeid`) REFERENCES `questiontype` (`id`),
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`examid`) REFERENCES `exam` (`id`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`answerid`) REFERENCES `answer` (`id`),
  ADD CONSTRAINT `result_ibfk_3` FOREIGN KEY (`examid`) REFERENCES `exam` (`id`),
  ADD CONSTRAINT `result_ibfk_4` FOREIGN KEY (`questionid`) REFERENCES `question` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
