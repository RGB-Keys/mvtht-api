CREATE SEQUENCE IF NOT EXISTS id_auditorium_seq
     INCREMENT 1
     MINVALUE 1
     MAXVALUE 99999999999
     START 1
     CACHE 1;

CREATE TABLE auditoriums (
    id_auditorium               INTEGER         NOT NULL    DEFAULT NEXTVAL('id_auditorium_seq') PRIMARY KEY,
    number                      VARCHAR(100)    NOT NULL,
    capacity                    INTEGER         NOT NULL,
    auditorium_type             VARCHAR(50)     NOT NULL,
    id_movie_theater            INTEGER         NOT NULL,
    FOREIGN KEY (id_movie_theater) REFERENCES movie_theaters(id_movie_theater)
)