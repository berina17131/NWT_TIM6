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
  `description` TEXT                      DEFAULT NULL,
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

-- Inserting values
INSERT INTO category (id, name, description) VALUES (1, "Muzika", "Svi muzički eventi");
INSERT INTO category (id, name, description) VALUES (2, "Sport", "Svi sportski eventi");
INSERT INTO category (id, name, description) VALUES (3, "Nauka", "Svi naučni eventi");
INSERT INTO category (id, name, description) VALUES (4, "Kultura", "Svi kulturni eventi");
INSERT INTO category (id, name, description) VALUES (5, "Zabava", "Svi zabavni eventi");

INSERT INTO place (id, name) VALUES (1, "MyFace");
INSERT INTO place (id, name) VALUES (2, "Cinemas Sloga");
INSERT INTO place (id, name) VALUES (3, "Narodno pozorište");
INSERT INTO place (id, name) VALUES (4, "SARTR");
INSERT INTO place (id, name) VALUES (5, "Velika sala grada Zenice");
INSERT INTO place (id, name) VALUES (6, "Shopping centar Džananović");
INSERT INTO place (id, name) VALUES (7, "Multiplex Ekran");
INSERT INTO place (id, name) VALUES (8, "Stadion Bilino polje");
INSERT INTO place (id, name) VALUES (9, "Dvorana Mejdan");

INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (1, "Rada Manojlović u MyFaceu",
   "Samo za vas, 04.05.2018. dovodimo u Sarajevo jednu od najvećih pjevačica Balkana u MyFace", 1, 1);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (2, "Katarina Grujić u MyFaceu",
   "U klub MyFace, u petak,  11.05.2018. dolazi Katarina Grujić. Dođite na Kaću da ludujemoo", 1, 1);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (3, "Student night u Slogi",
   "U četvrtak, 10.05.2018. Cinemas club Sloga organizuje student night. Studenti, dođite na najbolji provod u gradu!",
   1, 2);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (4, "Utakmica BiH - Crna Gora",
   "Na stadionu Bilino polje će, u ponedjeljak, 28.05.2018. snage odmjeriti reprezentacije BiH i Crne Gore. Ovaj utakmica će takođe biti oproštaj naših reprezentativaca Emira Spahića, Vedada Ibiševića, te Zvjezdana Misimovića od reprezentativnog dresa.",
   2, 8);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (5, "Utakmica BiH - Belgija u košarci",
   "U dvorani Mejdan, naša reprezentacija dočekuje reprezentaciju Belgije. Dođite i podržite naše reprezentativce u borbi za svjetsko prvenstvo.",
   2, 9);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (6, "Utjecaj moderne fizike na život običnog čovjeka",
   "Imamo priliku da slušamo poznatog BH fizičara Emira Baručiju, koji će nam govoriti o tome kako moderna fizika utiče na život običnog čovjeka",
   3, 5);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (7, "Koji fakultet upisati?",
   "Amra Mujčinović, uspješna studentica Elektrotehničkog fakulteta u Sarajevu, će 12.05.2018. godine u Velikoj sali Grada Zenica održati predavanje na temu: Koji fakultet upisati? Predavanje je posvećeno maturantima srednjih škola, te ih pozivamo da dođu u što većem broju.",
   3, 5);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (8, "Opera Labuđe jezero",
   "U narodnom pozorištu Sarajevo će se 10.04.2018. održati opera Labuđe jezero Pjotra Iljiča Čajkovskog.", 4, 3);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (9, "Predstava Hamlet u selu Mrđuša donja",
   "U Sartru će se 05.06.2018. godine održati predstava Hamlet u selu Mrđuša donja, spisatelja Ive Brešana", 4, 4);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (10, "SFF otvaranje", "Prva noć otvaranja SFF-a, ispred Narodnog pozorišta.", 4, 3);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (11, "Igre za najmlađe",
   "Dođite 12.05.2018. u Shopping centar Džananović, jer priređujemo puno igara i zabave za vaše najmlađe", 5, 6);
INSERT INTO event (id, name, description, category_id, place_id) VALUES
  (12, "Premijera filma Fast and Furious 9",
   "Premijerno u Multiplexu Ekran predstavljamo najnoviji nastavak franšize Fast and Furoius, dođite da zajedno gledamo Vin Diesela u akciji!!!",
   5, 7);
