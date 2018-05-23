DROP DATABASE IF EXISTS `event_management`;
CREATE DATABASE IF NOT EXISTS `event_management`;
USE `event_management`;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `place`;
CREATE TABLE `place` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` int(10) unsigned NOT NULL,
  `place_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id12_idx` (`category_id`),
  CONSTRAINT `fk_category12_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
    KEY `fk_place_id11_idx` (`category_id`),
  CONSTRAINT `fk_place11_id` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
