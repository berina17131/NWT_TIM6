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

-- Inserting values
INSERT INTO user (id, username) VALUES (1, "emir");
INSERT INTO user (id, username) VALUES (2, "amra");
INSERT INTO user (id, username) VALUES (3, "berina");

INSERT INTO event (id, name) VALUES (1, "Rada Manojlović u MyFaceu");
INSERT INTO event (id, name) VALUES (2, "Katarina Grujić u MyFaceu");
INSERT INTO event (id, name) VALUES (3, "Student night u Slogi");
INSERT INTO event (id, name) VALUES (4, "Utakmica BiH - Crna Gora");
INSERT INTO event (id, name) VALUES (5, "Utakmica BiH - Belgija u košarci");
INSERT INTO event (id, name) VALUES (6, "Utjecaj moderne fizike na život običnog čovjeka");
INSERT INTO event (id, name) VALUES (7, "Koji fakultet upisati?");
INSERT INTO event (id, name) VALUES (8, "Opera Labuđe jezero");
INSERT INTO event (id, name) VALUES (9, "Predstava Hamlet u selu Mrđuša donja");
INSERT INTO event (id, name) VALUES (10, "SFF otvaranje");
INSERT INTO event (id, name) VALUES (11, "Igre za najmlađe");
INSERT INTO event (id, name) VALUES (12, "Premijera filma Fast and Furious 9");

INSERT INTO status (id, status, user_id, event_id) VALUES (1, "idem", 1, 1);
INSERT INTO status (id, status, user_id, event_id) VALUES (2, "idem", 1, 2);
INSERT INTO status (id, status, user_id, event_id) VALUES (3, "možda", 3, 10);
INSERT INTO status (id, status, user_id, event_id) VALUES (4, "možda", 1, 9);
INSERT INTO status (id, status, user_id, event_id) VALUES (5, "idem", 3, 2);
INSERT INTO status (id, status, user_id, event_id) VALUES (6, "idem", 3, 8);
INSERT INTO status (id, status, user_id, event_id) VALUES (7, "idem", 1, 6);

INSERT INTO comment (id, comment, user_id, event_id) VALUES (1, "Odličnoo ekstra provod", 1, 1);
INSERT INTO comment (id, comment, user_id, event_id) VALUES (2, "Kaćaa ekstra vrh hvalaa MyFace", 1, 2);
INSERT INTO comment (id, comment, user_id, event_id) VALUES (3, "Super provod", 3, 2);
INSERT INTO comment (id, comment, user_id, event_id) VALUES (4, "Super je što je opera došla i u Sarajevo", 3, 8);
INSERT INTO comment (id, comment, user_id, event_id) VALUES (5, "Odlično predavanje", 1, 6);

INSERT INTO grade (id, grade, user_id, event_id) VALUES (1, 5, 1, 1);
INSERT INTO grade (id, grade, user_id, event_id) VALUES (2, 5, 1, 2);
INSERT INTO grade (id, grade, user_id, event_id) VALUES (3, 5, 3, 2);
INSERT INTO grade (id, grade, user_id, event_id) VALUES (4, 4, 3, 8);
INSERT INTO grade (id, grade, user_id, event_id) VALUES (5, 5, 1, 6);
