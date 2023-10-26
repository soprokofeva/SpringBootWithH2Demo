DROP TABLE IF EXISTS student;
DROP SEQUENCE IF EXISTS student_seq;

DROP TABLE IF EXISTS instructor_detail;
DROP SEQUENCE IF EXISTS instructor_detail_seq;
DROP TABLE IF EXISTS instructor;
DROP SEQUENCE IF EXISTS instructor_seq;


DROP SCHEMA IF EXISTS student_tracker;

SET MODE LEGACY
CREATE SCHEMA IF NOT EXISTS student_tracker;
USE student_tracker;

CREATE SEQUENCE student_seq NO CACHE NO CYCLE INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS student (
    id INT NOT NULL DEFAULT student_seq.nextval,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);

-- ALTER SEQUENCE STUDENT_TRACKER.STUDENT_SEQ RESTART WITH 1000
-- truncate table STUDENT_TRACKER.STUDENT

SELECT * FROM STUDENT;

CREATE SEQUENCE instructor_detail_seq NO CACHE NO CYCLE INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS instructor_detail (
    id INT NOT NULL DEFAULT instructor_detail_seq.nextval,
    youtube_channel VARCHAR(255) DEFAULT NULL,
    hobby VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);


CREATE SEQUENCE instructor_seq NO CACHE NO CYCLE INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS instructor (
    id INT NOT NULL DEFAULT instructor_seq.nextval,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    instructor_detail_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(instructor_detail_id) REFERENCES instructor_detail(id)
);
