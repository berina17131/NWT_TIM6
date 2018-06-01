DROP DATABASE IF EXISTS `user_management`;
CREATE DATABASE IF NOT EXISTS `user_management`;
USE `user_management`;


CREATE TABLE `role` (
  `id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

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

-- Inserting values
INSERT INTO role (id, role) VALUES (1, "ROLE_ADMIN");
INSERT INTO role (id, role) VALUES (2, "ROLE_USER");

INSERT INTO user (id, username, password, email, ime, prezime, role_id) VALUES
  (1, "emir", "$2a$10$Bu.YiMq3oEfBacnDzmQTXuCOp1pbdrLKfANDCl0HSxhP18k1sFIBW", "emir@etf.unsa.ba", "Emir", "Baručija",
   2);
INSERT INTO user (id, username, password, email, ime, prezime, role_id) VALUES
  (2, "amra", "$2a$10$xAAg86.kvnnViZSJk12dSuE11eA2tSvI3RfH1sHxVxokH3LCe6H8S", "amra@etf.unsa.ba", "Amra", "Mujčinović",
   1);
INSERT INTO user (id, username, password, email, ime, prezime, role_id) VALUES
  (3, "berina", "$2a$10$GGn8m1qsJqqu2skTJQ5Nt.varlE1kKInQ/nz2oUStoqlrdvkECBtq", "berina@etf.unsa.ba", "Berina",
   "Muhović", 2);
