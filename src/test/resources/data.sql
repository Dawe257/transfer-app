CREATE TABLE IF NOT EXISTS transaction (ID INTEGER AUTO_INCREMENT NOT NULL, card_fromcvv CHAR(25), card_from_number CHAR(25),
card_from_valid_till CHAR(25), card_to_number CHAR(25), confirmed BOOLEAN, amount_id INTEGER, PRIMARY KEY(ID));

CREATE TABLE IF NOT EXISTS amount (ID INTEGER AUTO_INCREMENT NOT NULL, currency CHAR(25), "value" INTEGER, PRIMARY KEY(ID));
ALTER TABLE transaction ADD FOREIGN KEY (amount_id) REFERENCES amount(ID);


INSERT INTO amount (currency, "value") VALUES ('RUR', 10000);
INSERT INTO amount (currency, "value") VALUES ('USD', 3000);
INSERT INTO amount (currency, "value") VALUES ('RUR', 750000);
INSERT INTO transaction (card_fromcvv, card_from_number, card_from_valid_till, card_to_number, confirmed, amount_id)
VALUES ('123', '45612316', '12/23', '5235412523', false, 1);
INSERT INTO transaction (card_fromcvv, card_from_number, card_from_valid_till, card_to_number, confirmed, amount_id)
VALUES ('456', '3156165', '12/23', '16151635165', false, 2);
INSERT INTO transaction (card_fromcvv, card_from_number, card_from_valid_till, card_to_number, confirmed, amount_id)
VALUES ('789', '3211656', '12/26', '64654165', false, 3);