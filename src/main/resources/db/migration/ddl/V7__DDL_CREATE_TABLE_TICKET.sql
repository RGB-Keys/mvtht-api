CREATE SEQUENCE IF NOT EXISTS id_ticket_seq
     INCREMENT 1
     MINVALUE 1
     MAXVALUE 99999999999
     START 1
     CACHE 1;

CREATE TABLE tickets (
    id_ticket                   INTEGER         NOT NULL    DEFAULT NEXTVAL('id_ticket_seq') PRIMARY KEY,
    ticket_type                 VARCHAR(100)    NOT NULL,
    ticket_price                NUMERIC(10,2)   NOT NULL,
    id_order                    INTEGER         NOT NULL,
    id_showtime                 INTEGER         NOT NULL,
    CONSTRAINT fk_order    FOREIGN KEY (id_order) REFERENCES orders(id_order),
    CONSTRAINT fk_showtime FOREIGN KEY (id_showtime) REFERENCES showtimes(id_showtime)
)