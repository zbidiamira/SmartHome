-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 14 Septembre 2015 à 21:23
-- Version du serveur :  5.6.21
-- Version de PHP :  5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `application_tt`
--

-- --------------------------------------------------------

--
-- Structure de la table `centre_rattach`
--

CREATE TABLE IF NOT EXISTS `centre_rattach` (
`idCenRat` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL DEFAULT '-.-',
  `idMetro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `centre_rattach`
--

INSERT INTO `centre_rattach` (`idCenRat`, `nom`, `idMetro`) VALUES
(1, 'eljem', 1),
(2, 'sidi alouane', 2),
(3, 'mahdia1', 3),
(4, 'mahdia2', 4),
(5, 'ouled chamekh', 5),
(6, 'hbira', 6),
(7, 'boumerdes', 7);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE IF NOT EXISTS `entreprise` (
`idEntreprise` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `logo` varchar(15) NOT NULL,
  `adresse` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`idEntreprise`, `nom`, `logo`, `adresse`) VALUES
(1, 'Sotetel', 'logo1', 'avenue habib bourguiba mahda'),
(2, 'Telecome', 'logo2', 'Chebba');

-- --------------------------------------------------------

--
-- Structure de la table `liaison`
--

CREATE TABLE IF NOT EXISTS `liaison` (
`idLaison` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL DEFAULT '-.-',
  `idType` int(11) NOT NULL,
  `idCentRat` int(11) NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  `longueur` int(11) NOT NULL,
  `idReception` int(11) NOT NULL,
  `idPlan` int(11) NOT NULL,
  `dateMES` varchar(20) NOT NULL DEFAULT '-.-',
  `observation` varchar(256) NOT NULL,
  `idMarche` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `liaison`
--

INSERT INTO `liaison` (`idLaison`, `nom`, `idType`, `idCentRat`, `idEntreprise`, `longueur`, `idReception`, `idPlan`, `dateMES`, `observation`, `idMarche`) VALUES
(1, 'El Jem 4', 2, 2, 1, 1, 3, 3, '01-01-2014', 'ok', 1),
(2, 'El Jem Remada', 2, 1, 1, 1, 3, 3, '01-02-2014', 'ok', 1),
(3, 'sidi alouane centre', 1, 2, 1, 10000, 3, 3, '01-05-2014', 'ok', 1),
(4, 'port2', 2, 3, 1, 1, 3, 3, '01-09-2014', 'ok', 4),
(5, 'INBMI Mahdia', 1, 3, 1, 1, 3, 3, '01-12-2014', 'ok', 1),
(6, 'FSEG', 3, 4, 1, 1, 3, 3, '01-01-2014', 'ok', 3),
(7, 'ISSAT Mahdia', 1, 4, 1, 1, 3, 3, '01-12-2014', 'ok', 3),
(8, 'Lycée O.Chamekh', 1, 5, 1, 1, 3, 1, '01-09-2014', 'ok', 1),
(9, 'swap O.Chamekh 7', 1, 5, 1, 1, 1, 3, '13-12-2015', 'ok', 1),
(10, 'Alimentation station total autouroute El Jem', 1, 1, 1, 1, 1, 3, '13-12-2015', 'ok', 1),
(11, 'Lycée Hbira', 1, 6, 1, 1, 1, 1, '01-01-2014', 'ok', 1),
(12, 'Lycée Messedi El Jem', 1, 1, 1, 1, 3, 3, '12-12-2013', 'ok', 2),
(13, 'Axe de transport El Jem-Boumerdes', 4, 7, 1, 1, 3, 1, '01-09-2014', 'ok', 1),
(14, 'ISET Mahdia', 1, 1, 1, 1, 1, 3, '05-12-2013', 'ok', 2);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `lview`
--
CREATE TABLE IF NOT EXISTS `lview` (
`cn` bigint(21)
,`dt` varchar(20)
,`nom` varchar(20)
);
-- --------------------------------------------------------

--
-- Structure de la table `marche`
--

CREATE TABLE IF NOT EXISTS `marche` (
`idMarche` int(11) NOT NULL,
  `datedeb` varchar(20) NOT NULL,
  `datefin` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `marche`
--

INSERT INTO `marche` (`idMarche`, `datedeb`, `datefin`, `nom`) VALUES
(1, '01-01-2013', '01-01-2015', 'FTTX 2012'),
(2, '01-02-2013', '01-02-2015', 'FTTX 2013'),
(3, '01-03-2013', '01-03-2015', 'backhauling 2011'),
(4, '01-04-2013', '01-04-2015', 'backhauling 2012');

-- --------------------------------------------------------

--
-- Structure de la table `metro`
--

CREATE TABLE IF NOT EXISTS `metro` (
`idMetro` int(11) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `metro`
--

INSERT INTO `metro` (`idMetro`, `type`) VALUES
(1, 'eljem'),
(2, 'sidi alouane'),
(3, 'mahdia1'),
(4, 'mahdia2'),
(5, 'ouled chamekh'),
(6, 'hbira'),
(7, 'boumerdes');

-- --------------------------------------------------------

--
-- Structure de la table `plan`
--

CREATE TABLE IF NOT EXISTS `plan` (
`idPlan` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `description` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `plan`
--

INSERT INTO `plan` (`idPlan`, `nom`, `description`) VALUES
(1, 'non fourni', 'plan non fourni'),
(2, 'en-con-valide', 'plan en-con-valide'),
(3, 'valide', 'plan valide'),
(4, 'non valide', 'plan non valide');

-- --------------------------------------------------------

--
-- Structure de la table `reception`
--

CREATE TABLE IF NOT EXISTS `reception` (
`idReception` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `description` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reception`
--

INSERT INTO `reception` (`idReception`, `nom`, `description`) VALUES
(1, 'oui', 'donnée reçus'),
(2, 'non', 'donnée non reçus'),
(3, 'en-cours', 'réception en-cours');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
`idType` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `description` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`idType`, `nom`, `description`) VALUES
(1, 'ClientFTTH', 'liaison FTTh'),
(2, 'NodeB', 'liaison NobeB'),
(3, 'MASN', 'liaison MASN'),
(4, 'Inter centraux', 'liaison Inter');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
`id` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `pwd` varchar(10) NOT NULL,
  `fonction` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `pwd`, `fonction`) VALUES
(1, 'root', 'root', 'Admin'),
(2, 'ahmed', 'nabil', 'Simple User'),
(3, 'ahmed', 'hsouna', 'Admin');

-- --------------------------------------------------------

--
-- Structure de la vue `lview`
--
DROP TABLE IF EXISTS `lview`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lview` AS select count(`l`.`idType`) AS `cn`,`l`.`dateMES` AS `dt`,`t`.`nom` AS `nom` from (`liaison` `l` join `type` `t`) where (`l`.`idType` = `t`.`idType`) group by `l`.`dateMES`,`t`.`nom`;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `centre_rattach`
--
ALTER TABLE `centre_rattach`
 ADD PRIMARY KEY (`idCenRat`), ADD KEY `idMetro` (`idMetro`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
 ADD PRIMARY KEY (`idEntreprise`);

--
-- Index pour la table `liaison`
--
ALTER TABLE `liaison`
 ADD PRIMARY KEY (`idLaison`), ADD KEY `idCentRat` (`idCentRat`,`idEntreprise`), ADD KEY `idEntreprise` (`idEntreprise`), ADD KEY `idType` (`idType`), ADD KEY `idPlan` (`idPlan`), ADD KEY `idReception` (`idReception`), ADD KEY `idMarche` (`idMarche`);

--
-- Index pour la table `marche`
--
ALTER TABLE `marche`
 ADD PRIMARY KEY (`idMarche`);

--
-- Index pour la table `metro`
--
ALTER TABLE `metro`
 ADD PRIMARY KEY (`idMetro`);

--
-- Index pour la table `plan`
--
ALTER TABLE `plan`
 ADD PRIMARY KEY (`idPlan`);

--
-- Index pour la table `reception`
--
ALTER TABLE `reception`
 ADD PRIMARY KEY (`idReception`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
 ADD PRIMARY KEY (`idType`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `centre_rattach`
--
ALTER TABLE `centre_rattach`
MODIFY `idCenRat` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
MODIFY `idEntreprise` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `liaison`
--
ALTER TABLE `liaison`
MODIFY `idLaison` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `marche`
--
ALTER TABLE `marche`
MODIFY `idMarche` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `metro`
--
ALTER TABLE `metro`
MODIFY `idMetro` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `plan`
--
ALTER TABLE `plan`
MODIFY `idPlan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `reception`
--
ALTER TABLE `reception`
MODIFY `idReception` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
MODIFY `idType` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `centre_rattach`
--
ALTER TABLE `centre_rattach`
ADD CONSTRAINT `centre_rattach_ibfk_1` FOREIGN KEY (`idMetro`) REFERENCES `metro` (`idMetro`);

--
-- Contraintes pour la table `liaison`
--
ALTER TABLE `liaison`
ADD CONSTRAINT `liaison_ibfk_1` FOREIGN KEY (`idCentRat`) REFERENCES `centre_rattach` (`idCenRat`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `liaison_ibfk_3` FOREIGN KEY (`idType`) REFERENCES `type` (`idType`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `liaison_ibfk_4` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`idEntreprise`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
