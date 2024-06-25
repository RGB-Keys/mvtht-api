CREATE SEQUENCE IF NOT EXISTS id_order_seq
     INCREMENT 1
     MINVALUE 1
     MAXVALUE 99999999999
     START 1
     CACHE 1;

CREATE TABLE orders (
    id_order                    INTEGER         NOT NULL    DEFAULT NEXTVAL('id_order_seq') PRIMARY KEY,
    order_status                VARCHAR(100)    NOT NULL,
    order_date                  TIMESTAMP       NOT NULL,
    id_customer                 INTEGER         NOT NULL,
    id_ticket                   INTEGER         NOT NULL,
    ticket_amount               INTEGER         NOT NULL,
    price_total                 INTEGER         NOT NULL,
    CONSTRAINT fk_customer  FOREIGN KEY (id_customer) REFERENCES customers(id_customer)
)