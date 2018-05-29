DROP DATABASE IF EXISTS `event_management`;
CREATE DATABASE IF NOT EXISTS `event_management`;
USE `event_management`;

CREATE TABLE `category` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255)     NOT NULL,
  `description` VARCHAR(255),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `place` (
  `id`   INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(50)      NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `event` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50)      NOT NULL,
  `description` VARCHAR(255)              DEFAULT NULL,
  `category_id` INT(10) UNSIGNED NOT NULL,
  `place_id`    INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id12_idx` (`category_id`),
  CONSTRAINT `fk_category12_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  KEY `fk_place_id11_idx` (`place_id`),
  CONSTRAINT `fk_place11_id` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
