-- phpMyAdmin SQL Dump
-- version 3.3.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 04, 2011 at 06:37 AM
-- Server version: 5.1.54
-- PHP Version: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Dissertation`
--

-- --------------------------------------------------------

--
-- Table structure for table `COMPUTED`
--

CREATE TABLE IF NOT EXISTS `COMPUTED` (
  `_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA` varchar(100) NOT NULL,
  `MATRIX_ID` int(11) NOT NULL,
  `ROW_COR` int(11) NOT NULL,
  `COL_COR` int(11) NOT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `COMPUTED`
--

INSERT INTO `COMPUTED` (`_ID`, `DATA`, `MATRIX_ID`, `ROW_COR`, `COL_COR`) VALUES
(45, '7.6207894177669', 11, 1, 11),
(44, '', 0, 0, 0),
(43, '10', 1, 1, 12),
(42, '165', 123, 112, 1),
(41, '192', 123, 12, 19),
(40, '201', 123, 182, 1),
(39, '210', 123, 12, 11),
(38, '219', 123, 122, 12);

-- --------------------------------------------------------

--
-- Table structure for table `Copy`
--

CREATE TABLE IF NOT EXISTS `Copy` (
  `_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MATRIX` int(11) NOT NULL,
  `ROWS` varchar(100) NOT NULL,
  `COL` varchar(100) NOT NULL,
  `ROW_COR` int(20) NOT NULL,
  `COL_COR` int(20) NOT NULL,
  `MATRIX_ID` int(11) NOT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=140 ;

--
-- Dumping data for table `Copy`
--


-- --------------------------------------------------------

--
-- Table structure for table `WAITING`
--

CREATE TABLE IF NOT EXISTS `WAITING` (
  `_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROWS` longtext NOT NULL,
  `COL` longtext NOT NULL,
  `ROW_COR` int(11) NOT NULL,
  `COL_COR` int(11) NOT NULL,
  `MATRIX_ID` int(11) NOT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=166 ;

--
-- Dumping data for table `WAITING`
--