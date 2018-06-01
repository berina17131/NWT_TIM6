DROP DATABASE IF EXISTS `place_management`;
CREATE DATABASE IF NOT EXISTS `place_management`;
USE `place_management`;


CREATE TABLE `city` (
  `id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30)      NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `address` (
  `id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(50)      NOT NULL,
  `city_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_city_id_idx` (`city_id`),
  CONSTRAINT `fk_address_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `place` (
  `id`          INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50)      NOT NULL,
  `description` VARCHAR(255)              DEFAULT NULL,
  `address_id`  INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_place_address_id_idx` (`address_id`),
  CONSTRAINT `fk_place_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `event` (
  `id`       INT(10) UNSIGNED NOT NULL,
  `name`     VARCHAR(50)      NOT NULL,
  `place_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_event_place_id_idx` (`place_id`),
  CONSTRAINT `fk_event_place_id` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- Inserting values
INSERT INTO city (id, name) VALUES (1, "Sarajevo");
INSERT INTO city (id, name) VALUES (2, "Zenica");
INSERT INTO city (id, name) VALUES (3, "Tuzla");

INSERT INTO address (id, name, city_id) VALUES (1, "Vilsonovo šetalište 8", 1);
INSERT INTO address (id, name, city_id) VALUES (2, "Mehmeda Spahe 20", 1);
INSERT INTO address (id, name, city_id) VALUES (3, "Obala Kulina bana 9", 1);
INSERT INTO address (id, name, city_id) VALUES (4, "Gabelina 16", 1);
INSERT INTO address (id, name, city_id) VALUES (5, "Trg BiH 6", 2);
INSERT INTO address (id, name, city_id) VALUES (6, "Kamberovića čikma 10", 2);
INSERT INTO address (id, name, city_id) VALUES (7, "Trg Alije Izetbegovića 86", 2);
INSERT INTO address (id, name, city_id) VALUES (8, "Bulevar Kulina bana bb", 2);
INSERT INTO address (id, name, city_id) VALUES (9, "Bosne Srebrene bb", 3);

INSERT INTO place (id, name, description, address_id) VALUES
  (1, "MyFace", "Najbolja muzika u gradu je kod nas", 1);
INSERT INTO place (id, name, description, address_id) VALUES
  (2, "Cinemas Sloga", "Klub sa širokim spektrom muzike, kod nas pjevaju samo najbolji", 2);
INSERT INTO place (id, name, description, address_id) VALUES
  (3, "Narodno pozorište Sarajevo",
   "Narodno pozorište u Sarajevu, mjesto brojnih predstava i kulturnoumjetničkih dešavanja", 3);
INSERT INTO place (id, name, description, address_id) VALUES
  (4, "SARTR", "Sarajevski ratni teatar", 4);
INSERT INTO place (id, name, description, address_id) VALUES
  (5, "Velika sala grada Zenice", "Velika sala grada Zenica, u njoj se održavaju sjednice gradskog vijeća i slično", 5);
INSERT INTO place (id, name, description, address_id) VALUES
  (6, "Shopping centar Džananović", "Najveći shopping centar u Zenici, sa velikim brojem svjetskih brendova", 6);
INSERT INTO place (id, name, description, address_id) VALUES
  (7, "Multiplex Ekran", "Najbolje kino u gradu", 7);
INSERT INTO place (id, name, description, address_id) VALUES
  (8, "Stadion Bilino polje", "Dom BH Zmajeva!!!", 8);
INSERT INTO place (id, name, description, address_id) VALUES
  (9, "Dvorana Mejdan", "Poznata tuzlanska dvorana, dom brojnih naših reprezentacija", 9);

INSERT INTO event (id, name, place_id) VALUES (1, "Rada Manojlović u MyFaceu", 1);
INSERT INTO event (id, name, place_id) VALUES (2, "Katarina Grujić u MyFaceu", 1);
INSERT INTO event (id, name, place_id) VALUES (3, "Student night u Slogi", 2);
INSERT INTO event (id, name, place_id) VALUES (4, "Utakmica BiH - Crna Gora", 8);
INSERT INTO event (id, name, place_id) VALUES (5, "Utakmica BiH - Belgija u košarci", 9);
INSERT INTO event (id, name, place_id) VALUES (6, "Utjecaj moderne fizike na život običnog čovjeka", 5);
INSERT INTO event (id, name, place_id) VALUES (7, "Koji fakultet upisati?", 5);
INSERT INTO event (id, name, place_id) VALUES (8, "Opera Labuđe jezero", 3);
INSERT INTO event (id, name, place_id) VALUES (9, "Predstava Hamlet u selu Mrđuša donja", 4);
INSERT INTO event (id, name, place_id) VALUES (10, "SFF otvaranje", 3);
INSERT INTO event (id, name, place_id) VALUES (11, "Igre za najmlađe", 6);
INSERT INTO event (id, name, place_id) VALUES (12, "Premijera filma Fast and Furious 9", 7);
