-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u2
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 28 Mars 2016 à 20:06
-- Version du serveur: 5.5.46
-- Version de PHP: 5.4.45-0+deb7u2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `pihome`
--

-- --------------------------------------------------------

--
-- Structure de la table `pi_admin`
--

CREATE TABLE IF NOT EXISTS `pi_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `pass` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `name` varchar(155) COLLATE latin1_german1_ci NOT NULL,
  `admin` varchar(1) COLLATE latin1_german1_ci NOT NULL DEFAULT '0',
  `color` varchar(7) COLLATE latin1_german1_ci NOT NULL,
  `apikey` varchar(32) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=3 ;

--
-- Contenu de la table `pi_admin`
--

INSERT INTO `pi_admin` (`id`, `user`, `pass`, `name`, `admin`, `color`, `apikey`) VALUES
(1, 'admin', 'pihome', 'Ksouri Wissem', '1', '#187ac1', 's9XcHG3xISfcNc7THYgaWdyjqdsaiLPN'),
(2, '', '', 'Amira Zbidi', '0', '#0f9b00', 'CtX3qo2BCKccCKB0m00NNImXcKPgXicQ');

-- --------------------------------------------------------

--
-- Structure de la table `pi_devices`
--

CREATE TABLE IF NOT EXISTS `pi_devices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `device` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  `letter` varchar(55) COLLATE latin1_german1_ci NOT NULL,
  `code` varchar(55) COLLATE latin1_german1_ci NOT NULL DEFAULT '00000',
  `status` varchar(55) COLLATE latin1_german1_ci NOT NULL DEFAULT '0',
  `sort` varchar(55) COLLATE latin1_german1_ci NOT NULL DEFAULT '0',
  `sunset` varchar(1) COLLATE latin1_german1_ci NOT NULL DEFAULT '0',
  `aktiv` varchar(55) COLLATE latin1_german1_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `pi_devices`
--

INSERT INTO `pi_devices` (`id`, `room_id`, `device`, `letter`, `code`, `status`, `sort`, `sunset`, `aktiv`) VALUES
(1, '1', 'Lamp One', 'A', '00000', '0', '0', '0', '1'),
(2, '2', 'Lamp Two', 'B', '00000', '0', '0', '0', '1'),
(3, '3', 'Lamp Three', 'C', '00000', '0', '0', '0', '1'),
(4, '4', 'Lamp Four', 'D', '00000', '0', '0', '0', '1');

-- --------------------------------------------------------

--
-- Structure de la table `pi_rooms`
--

CREATE TABLE IF NOT EXISTS `pi_rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room` varchar(255) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `pi_rooms`
--

INSERT INTO `pi_rooms` (`id`, `room`) VALUES
(1, 'office'),
(2, 'living room'),
(3, 'kitchen'),
(4, 'bathroom');

-- --------------------------------------------------------

--
-- Structure de la table `pi_settings`
--

CREATE TABLE IF NOT EXISTS `pi_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(155) COLLATE latin1_german1_ci NOT NULL,
  `value` varchar(155) COLLATE latin1_german1_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci AUTO_INCREMENT=21 ;

--
-- Contenu de la table `pi_settings`
--

INSERT INTO `pi_settings` (`id`, `name`, `value`) VALUES
(5, 'city', 'Berlin'),
(6, 'timezone', 'Africa/Tunis'),
(7, 'weather', 'true'),
(8, 'sunrise', 'false'),
(10, 'country_code', 'TN'),
(11, 'weather_option', 'c_kms'),
(13, 'gcal_ical_activ', 'false'),
(14, 'gcal_ical', ''),
(17, 'oc_ical', 'false'),
(18, 'oc_user', ''),
(19, 'oc_pass', ''),
(20, 'oc_ical_url', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
