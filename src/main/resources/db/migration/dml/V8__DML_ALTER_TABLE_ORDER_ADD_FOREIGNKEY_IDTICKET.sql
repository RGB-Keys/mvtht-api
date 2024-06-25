ALTER TABLE orders
ADD CONSTRAINT fk_ticket
FOREIGN KEY (id_ticket)
REFERENCES tickets(id_ticket);