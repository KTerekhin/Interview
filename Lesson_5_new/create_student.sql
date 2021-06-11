DROP TABLE IF EXISTS student;

CREATE TABLE student (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	mark INT NOT NULL,
 PRIMARY KEY (id));

INSERT INTO student (name, mark) VALUES ('Student_1', '80');
INSERT INTO student (name, mark) VALUES ('Student_2', '75');
INSERT INTO student (name, mark) VALUES ('Student_3', '90');
