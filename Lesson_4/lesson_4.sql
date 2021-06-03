CREATE SCHEMA `cinema` ;

CREATE TABLE `cinema`.`film` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `duration` TIME NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cinema`.`hall` (
  `id_hall` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_hall`));

CREATE TABLE `cinema`.`schedule` (
  `id_schedule` INT NOT NULL AUTO_INCREMENT,
  `film_id` INT NOT NULL,
  `hall_id` INT NOT NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id_schedule`),
  INDEX `fk_film_id_idx` (`film_id` ASC) VISIBLE,
  INDEX `fk_hall_id_idx` (`hall_id` ASC) VISIBLE,
  CONSTRAINT `fk_film_id`
    FOREIGN KEY (`film_id`)
    REFERENCES `cinema`.`film` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_hall_id`
    FOREIGN KEY (`hall_id`)
    REFERENCES `cinema`.`hall` (`id_hall`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO `cinema`.`film` (`name`, `duration`, `price`) VALUES ('Godzilla', '2:10', '200');
INSERT INTO `cinema`.`film` (`name`, `duration`, `price`) VALUES ('Avengers: Endgame', '3:01', '400');
INSERT INTO `cinema`.`film` (`name`, `duration`, `price`) VALUES ('A Quiet Place', '1:30', '150');
INSERT INTO `cinema`.`film` (`name`, `duration`, `price`) VALUES ('Man of Steel', '2:23', '350');
INSERT INTO `cinema`.`film` (`name`, `duration`, `price`) VALUES ('Intouchables', '1:52', '250');

INSERT INTO `cinema`.`hall` (`name`) VALUES ('Hall_1');
INSERT INTO `cinema`.`hall` (`name`) VALUES ('Hall_2');
INSERT INTO `cinema`.`hall` (`name`) VALUES ('Hall_3');

INSERT INTO `cinema`.`schedule` (`film_id`, `hall_id`, `time`) VALUES ('1', '1', '2021-06-02 0:00:');
INSERT INTO `cinema`.`schedule` (`film_id`, `hall_id`, `time`) VALUES ('2', '2', '2021-06-02 0:30');
INSERT INTO `cinema`.`schedule` (`film_id`, `hall_id`, `time`) VALUES ('3', '3', '2021-06-02 1:30');
INSERT INTO `cinema`.`schedule` (`film_id`, `hall_id`, `time`) VALUES ('4', '1', '2021-06-02 2:00');
INSERT INTO `cinema`.`schedule` (`film_id`, `hall_id`, `time`) VALUES ('5', '1', '2021-06-02 5:00');

CREATE VIEW film_schedule AS
SELECT F.id
        ,F.name
        ,F.duration
        ,S.time AS FilmStart
        ,(SELECT (ADDTIME(S.time, F.duration))) AS FilmEnd
        ,S.hall_id
FROM cinema.schedule AS S 
JOIN cinema.film AS F
ON S.film_id = F.id;
 
SELECT  C.id AS Film_1_Id ,C.name AS Film_1_Name ,C.FilmStart AS Film_1_Start ,C.duration AS Film_1_Duration
        ,C1.id AS Film_2_Id ,C1.name AS Film_2_Name ,C1.FilmStart AS Film_2_Start ,C1.duration AS Film_2_Duration
FROM film_schedule AS C
LEFT JOIN film_schedule AS C1 ON C1.FilmStart BETWEEN C.FilmStart AND C.FilmEnd
                    AND C.Id <> C1.Id AND C.hall_id = C1.hall_id
WHERE C1.Id IS NOT NULL
ORDER BY Film_1_Start;
