DROP DATABASE IF EXISTS `interaction_management`;
CREATE DATABASE IF NOT EXISTS `interaction_management`;
USE `interaction_management`;

CREATE TABLE `user` (
  `id`       INT(10) UNSIGNED NOT NULL,
  `username` VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `event` (
  `id`   INT(10) UNSIGNED NOT NULL,
  `name` VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `comment` (
  `id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment`  VARCHAR(255)              DEFAULT NULL,
  `user_id`  INT(10) UNSIGNED          DEFAULT NULL,
  `event_id` INT(10) UNSIGNED          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user_id_idx` (`user_id`),
  KEY `fk_comment_event_id_idx` (`event_id`),
  CONSTRAINT `fk_comment_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_event_id` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `grade` (
  `id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `grade`    INT(10)                   DEFAULT NULL,
  `user_id`  INT(10) UNSIGNED          DEFAULT NULL,
  `event_id` INT(10) UNSIGNED          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grade_user_id_idx` (`user_id`),
  KEY `fk_grade_event_id_idx` (`event_id`),
  CONSTRAINT `fk_grade_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_grade_event_id` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `status` (
  `id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status`   VARCHAR(255)              DEFAULT NULL,
  `user_id`  INT(10) UNSIGNED          DEFAULT NULL,
  `event_id` INT(10) UNSIGNED          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_status_user_id_idx` (`user_id`),
  KEY `fk_status_event_id_idx` (`event_id`),
  CONSTRAINT `fk_status_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_status_event_id` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
