CREATE SEQUENCE IF NOT EXISTS id_showtime_seq
     INCREMENT 1
     MINVALUE 1
     MAXVALUE 99999999999
     START 1
     CACHE 1;

CREATE TABLE showtimes (
    id_showtime                 INTEGER         NOT NULL    DEFAULT NEXTVAL('id_showtime_seq') PRIMARY KEY,
    hour_showtime               VARCHAR(100)    NOT NULL,
    showtime_date               TIMESTAMP       NOT NULL,
    showtime_seat               TEXT[]          NOT NULL,
    id_auditorium               INTEGER         NOT NULL,
    FOREIGN KEY (id_auditorium) REFERENCES auditoriums(id_auditorium)
)