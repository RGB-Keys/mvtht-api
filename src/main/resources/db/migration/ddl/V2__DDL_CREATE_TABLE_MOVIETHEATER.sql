CREATE SEQUENCE IF NOT EXISTS id_movie_theater_seq
     INCREMENT 1
     MINVALUE 1
     MAXVALUE 99999999999
     START 1
     CACHE 1;

CREATE TABLE movie_theaters (
    id_movie_theater            INTEGER         NOT NULL    DEFAULT NEXTVAL('id_movie_theater_seq') PRIMARY KEY,
    name                        VARCHAR(255)    NOT NULL,
    email                       VARCHAR(100)    NOT NULL    UNIQUE,
    phone                       VARCHAR(14)     NOT NULL,
    cnpj                        VARCHAR(17)     NOT NULL    UNIQUE,
    zip_code                    VARCHAR(8)      NOT NULL,
    country                     VARCHAR(50)     NOT NULL,
    state                       VARCHAR(50)     NOT NULL,
    city                        VARCHAR(50)     NOT NULL,
    street                      VARCHAR(50)     NOT NULL,
    neighborhood                VARCHAR(50)     NOT NULL,
    number                      VARCHAR(5)      NOT NULL
)