drop table horse_account IF exists;
drop table horse IF exists;
drop table account IF exists;

/*accounts*/
INSERT INTO account (email, password, firstName, lastName, role, phoneNumber)
VALUES ('user@udc.es','demo','User','Demo','ROLE_USER','666666666');

INSERT INTO account (email, password, firstName, lastName, role, phoneNumber)
VALUES ('admin@udc.es','demo','Admin','Demo','ROLE_ADMIN','666666777');

/*horses*/
INSERT INTO horse(nickname, name, breed, birthdate, gender, fur, markings, sire, damnsire, licensenumber, chipnumber)
VALUES ('Cintia','Cintia','Holsteiner',to_date('20/04/2006', 'DD/MM/YYYY'), 'mare', 'darkbay',
        'blaze','Cassini I', 'Grundyman XX', '079909', '123456789');

INSERT INTO horse(nickname, name, breed, birthdate, gender, fur, markings, sire, damnsire, licensenumber, chipnumber)
VALUES ('Chantré','Chantré 34','Mecklenburg',to_date('20/03/2005', 'DD/MM/YYYY'), 'gelding', 'bay',
        'stripe','Chandon', 'Lord Kemn', '030378', '123456790');

/*horse_account*/
INSERT INTO horse_account(horseid, accountid)
VALUES (1,'');

