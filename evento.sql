-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 09, 2013 at 03:38 PM
-- Server version: 5.1.61
-- PHP Version: 5.3.3-1ubuntu9.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `evento`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friend_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `contacts`
--


-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `venue` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `address` text COLLATE utf8_unicode_ci NOT NULL,
  `event_hour` int(11) NOT NULL,
  `event_min` int(11) NOT NULL,
  `period` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `ticketCount` int(11) NOT NULL,
  `ticketCategory` int(11) NOT NULL,
  `publish` int(11) NOT NULL,
  `ticketExpiryDate` date NOT NULL,
  `date` date NOT NULL,
  `organizerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=37 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `title`, `venue`, `address`, `event_hour`, `event_min`, `period`, `description`, `ticketCount`, `ticketCategory`, `publish`, `ticketExpiryDate`, `date`, `organizerId`) VALUES
(25, 'This is a new event', 'This is a new event', 'This is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new event\r\n\r\nThis is a new eventThis is a new event\r\n\r\nThis is a new event', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">This is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new event</font><div><font face="Arial, Verdana" size="2"><br/></font></div><div><font face="Arial, Verdana" size="2"><br/></font></div><div><font face="Arial, Verdana" size="2">This is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new eventThis is a new event</font></div>', 100, 2, 1, '2013-02-28', '2013-02-26', 7),
(24, 'Hello Event', 'Hello Event', 'Hello EventHello EventHello Event\r\nHello EventHello Event\r\nHello Event', 1, 1, 'AM', '<font face="Arial, Verdana" size="2"><strong>Hello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello EventHello Event</strong></font>', 51, 1, 1, '2013-04-24', '2013-02-25', 7),
(23, 'This is a new event', 'whats up', 'yap', 1, 1, 'AM', 'asdfasdf', 0, 1, 0, '2013-02-27', '2013-02-25', 7),
(21, 'asdfasdf', 'asdfasdf', 'asdfasdf', 1, 1, 'AM', 'asdfasdf', 0, 1, 0, '2013-02-27', '2013-02-25', 6),
(22, 'New Event', 'New Event', 'New Event', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">New Event</font>', 0, 1, 1, '2013-02-28', '2013-02-25', 6),
(26, 'Event By A', 'Event By A', 'Event By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By A', 1, 1, 'AM', '<h1><em><font size="4"><font face="Arial, Verdana">Event By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By A</font><font face="Arial, Verdana"><br/></font></font></em><p><font face="Arial, Verdana" size="4"><em>Event By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By AEvent By A</em></font></p></h1>', 500, 1, 1, '2013-03-28', '2013-02-27', 7),
(27, 'Sharif''s Event', 'Sharif''s Event', 'Sharif''s Event Sharif''s Event Sharif''s Event Sharif''s Event', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">Sharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s EventSharif''s Event</font><div><font face="Arial, Verdana" size="2"><br/></font></div><div><font face="Arial, Verdana" size="2">Sharif''s EventSharif''s EventSharif''s EventSharif''s Event</font></div>', 55, 1, 1, '2013-03-27', '2013-03-06', 8),
(30, 'new', 'new', 'new', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">new</font>', 0, 1, 0, '2013-03-31', '2013-03-06', 7),
(31, 'a', 'a', 'a', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">a</font>', 0, 1, 0, '2013-03-31', '2013-03-06', 7),
(32, 'asdfasdf', 'asdf', 'sdfasdf', 1, 1, 'AM', 'asdfasdf', 0, 1, 0, '2013-03-31', '2013-03-06', 8),
(33, 'asdfasdf', 'asdf', 'sdfasdf', 1, 1, 'AM', 'asdfasdf', 0, 1, 0, '2013-03-31', '2013-03-06', 8),
(34, 'asdf', 'asdf', 'asdf', 1, 1, 'AM', 'asd', 0, 1, 0, '2013-03-26', '2013-03-13', 8),
(35, 'iopio', 'iop', 'iop', 1, 1, 'AM', 'iop', 0, 1, 0, '2013-03-31', '2013-03-06', 7),
(36, 'uiokh', 'ghj', 'ghjk', 1, 1, 'AM', 'ghjkh', 0, 1, 1, '2013-03-31', '2013-03-18', 7),
(29, 'New EVent-Sharif', 'New EVent-Sharif', 'New EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-Sharif', 1, 1, 'AM', '<font face="Arial, Verdana" size="2">New EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-SharifNew EVent-Sharif</font>', 101, 1, 0, '2013-03-31', '2013-03-20', 8);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `participant_id` int(11) NOT NULL,
  `feedback` text COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `feedback`
--


-- --------------------------------------------------------

--
-- Table structure for table `invites`
--

CREATE TABLE IF NOT EXISTS `invites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `invites`
--


-- --------------------------------------------------------

--
-- Table structure for table `participants`
--

CREATE TABLE IF NOT EXISTS `participants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=236 ;

--
-- Dumping data for table `participants`
--

INSERT INTO `participants` (`id`, `user_id`, `event_id`) VALUES
(235, 7, 22),
(234, 7, 22);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `participant_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `rating`
--


-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE IF NOT EXISTS `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `participant_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tickets`
--


-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `pass` text COLLATE utf8_unicode_ci NOT NULL,
  `address` text COLLATE utf8_unicode_ci,
  `portrait` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `name`, `email`, `pass`, `address`, `portrait`, `description`) VALUES
(7, '', 'a@a.com', '123', '', '', ''),
(6, '', 'notun@user.com', '123456', '', '', ''),
(8, NULL, 'sharifducse@gmail.com', '123456789', NULL, NULL, NULL);
