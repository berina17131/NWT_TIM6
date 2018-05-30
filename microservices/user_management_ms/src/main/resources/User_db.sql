DROP DATABASE IF EXISTS `user_management`;
CREATE DATABASE IF NOT EXISTS `user_management`;
USE `user_management`;

--
-- Table structure for table `role`
--
CREATE TABLE `role` (
  `id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

--
-- Table structure for table `user`
--
CREATE TABLE `user` (
  `id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255)              DEFAULT NULL,
  `password` VARCHAR(255)              DEFAULT NULL,
  `email`    VARCHAR(255)              DEFAULT NULL,
  `ime`      VARCHAR(255)              DEFAULT NULL,
  `prezime`  VARCHAR(255)              DEFAULT NULL,
  `role_id`  INT(10) UNSIGNED          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_id_idx` (`role_id`),
  CONSTRAINT `fk_book_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
