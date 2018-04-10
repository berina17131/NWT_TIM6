DROP DATABASE IF EXISTS `place_management_database`;
CREATE DATABASE  IF NOT EXISTS `place_management_database`;
USE `place_management_database`;

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_city_id_idx` (`city_id`),
  CONSTRAINT `fk_address_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `address_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_place_address_id_idx` (`address_id`),
  CONSTRAINT `fk_place_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `place_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_event_place_id_idx` (`place_id`),
  CONSTRAINT `fk_event_place_id` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;