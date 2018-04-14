/*Tyoe*/
INSERT INTO Type (name)
VALUES ('Maraton');

INSERT INTO Type (name)
VALUES ('Natacion');

INSERT INTO Type (name)
VALUES ('Ciclismo');

INSERT INTO Type (name)
VALUES ('Media Maraton');

INSERT INTO Type (name)
VALUES ('Cross');

INSERT INTO Type (name)
VALUES ('Carrera Popular');

INSERT INTO Type (name)
VALUES ('Trail');

INSERT INTO Type (name)
VALUES ('Triatlon');

/*Category*/
INSERT INTO Category (name)
VALUES ('Absoluto Masculino');

INSERT INTO Category (name)
VALUES ('Absoluto Femenino');

INSERT INTO Category (name)
VALUES ('Junior Masculino');

INSERT INTO Category (name)
VALUES ('Junior Femenino');

INSERT INTO Category (name)
VALUES ('Infantil Masculino');

INSERT INTO Category (name)
VALUES ('Infantil Femenino');

INSERT INTO Category (name)
VALUES ('Absoluto Mixto');

INSERT INTO Category (name)
VALUES ('Junior Mixto');

INSERT INTO Category (name)
VALUES ('Infantil Mixto');

/*Gender*/
INSERT INTO Gender (name)
VALUES ('Hombre');

INSERT INTO Gender (name)
VALUES ('Mujer');

/*Event*/
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera de San Mateo 2017', 'Carrera popular celebrada en el día de San Mateo, ven a divertirte en este día tan especial, 
	corre junto a cientos de personas durante 20 maravillosos kilómetros por las mejores vistas de Carballiño','Carballiño', 500, 	
	20, 0, (SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 
	5, 0, false, false, 20, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Trail Mosteiro de Caaveiro', 'Carrera por montaña cerca del Monasteiro de Caaveiro','A Capela', 500, 15, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Trail'), 10, 0, 
	false, false, 20, to_date('19/11/2018', 'DD/MM/YYYY'), to_date('17/11/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('VII Legua solidaria Hipica Malawi', 'Carrera solidaria celebrada en el paseo marítimo de A Coruña','A Coruña', 500, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	false, false, 20, to_date('26/11/2018', 'DD/MM/YYYY'), to_date('18/11/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('6º Media Maraton Solidaria Zona Aberta', 'Media maraton con fines beneficos en Vilagarcia de Arousa','Vilagarcia de Arousa', 
	200, 20, 0, (SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Media Maraton'), 
		10, 0, false, false, 20, to_date('26/11/2018', 'DD/MM/YYYY'), to_date('20/11/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('V Trail do Trega', 'Carrera por montaña por A Guarda','A Guarda', 100, 15, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Trail'), 7, 0, 
	false, false, 20, to_date('26/11/2018', 'DD/MM/YYYY'), to_date('24/11/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('XXI Media Maraton de Vigo', 'Media maraton que transcurre por las calles de Vigo','Vigo', 400, 20, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Media Maraton'), 
	15, 0, false, false, 20, to_date('03/12/2018', 'DD/MM/YYYY'), to_date('02/12/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('X Carrera solidaria do Arenteiro', 'Carrera popular celebrada en Carballiño','Carballiño', 200, 10, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 
	7, 0, false, false, 20, to_date('10/12/2018', 'DD/MM/YYYY'), to_date('07/12/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('XVI Carrera popular Lugo Monumental', 'Carrera popular celebrada En Lugo','Lugo', 500, 10, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 
	5, 0, false, false, 20, to_date('17/12/2018', 'DD/MM/YYYY'), to_date('15/12/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('III Cross Ponte Romana', 'Carrera de campo atraves celebrada en Lugo','Carballiño', 500, 20, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Cross'), 5, 0, 
	false, false, 20, to_date('14/01/2018', 'DD/MM/YYYY'), to_date('10/01/2018', 'DD/MM/YYYY'), true);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('III Trail Costa Doce', 'Carrera por montaña celebrada en Sada','Sada, La Coruña', 100, 15, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Trail'), 5, 0, 
	false, false, 20, to_date('28/01/2018', 'DD/MM/YYYY'), to_date('25/01/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('IV Desafio Boot Camp', '','Carballiño', 500, 20, 0, (SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), 
	(SELECT type_id FROM type WHERE name LIKE 'Cross'), 5, 0, false, false, 20, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera de la mujer 2018', 'Carrera para celebrar el dia de la mujer en A Coruña','A Coruña', 1000, 10, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 
	7, 0, false, false, 20, to_date('17/09/2018', 'DD/MM/YYYY'), to_date('13/09/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('II Cross A Coruña', 'Carrera de campo atraves en las afueras de A Coruña','A Coruña', 200, 13, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Cross'), 6, 0, 
	false, false, 20, to_date('05/02/2018', 'DD/MM/YYYY'), to_date('01/02/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('I Cross O Burgo', 'Carrera de campo atraves en O Burgo','O Burgo', 250, 20, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Cross'), 5, 0, 
	false, false, 20, to_date('02/03/2018', 'DD/MM/YYYY'), to_date('01/03/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Coruña 42', 'Maravilloso maraton por las bonitas calles de Coruña','A Coruña', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Lugo', 'Maravilloso maraton por las bonitas calles de Lugo','Lugo', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Vigo', 'Maravilloso maraton por las bonitas calles de Vigo','Vigo', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);

INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Orense', 'Maravilloso maraton por las bonitas calles de Orense','Orense', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Pontevedra', 'Maravilloso maraton por las bonitas calles de Pontevedra','Pontevedra', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('22/03/2018', 'DD/MM/YYYY'), to_date('20/03/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Maraton Ferrol', 'Maravilloso maraton por las bonitas calles de Ferrol','Ferrol', 500, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	false, false, 42, to_date('21/03/2018', 'DD/MM/YYYY'), to_date('18/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Iron Man Carballiño', 'Exigente Iron Man por las afueras de Carballiño','Carballiño', 700, 226, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Triatlon'), 5, 0, 
	true, false, 226, to_date('20/03/2018', 'DD/MM/YYYY'), to_date('17/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Prueba Circuito Maratones Galicia Masculino', 'Primera prueba del circuito gallego de maratones masculino, prueba celebrada en A Coruña','A Coruña', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/04/2018', 'DD/MM/YYYY'), to_date('25/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Prueba Circuito Maratones Galicia Masculino', 'Segunda prueba del circuito gallego de maratones masculino, prueba celebrada en Vigo','Vigo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/05/2018', 'DD/MM/YYYY'), to_date('25/04/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Prueba Circuito Maratones Galicia Masculino', 'Tercera prueba del circuito gallego de maratones masculino, prueba celebrada en Lugo','Lugo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('25/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Prueba Circuito Maratones Galicia Masculino', 'Cuarta prueba del circuito gallego de maratones masculino, prueba celebrada en Orense','Orense', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/07/2018', 'DD/MM/YYYY'), to_date('25/06/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Master Circuito Maratones Galicia Masculino', 'Prueba final para los corredores con mejor clasificación en las pruebas anteriores del circuito gallego de maratones masculino, prueba celebrada en Santiago de Compostela','Santiago de Compostela', 700, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/08/2018', 'DD/MM/YYYY'), to_date('25/07/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Prueba Circuito Gallego Natacion mar abierto Masculino', 'Primera prueba del circuito gallego de natacion en mar abierto masculino, prueba celebrada en las aguas de A Coruña','A Coruña', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/04/2018', 'DD/MM/YYYY'), to_date('17/04/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Prueba Circuito Gallego Natacion mar abierto Maculino', 'Segunda prueba del circuito gallego de natacion en mar abierto masculino, prueba celebrada en las aguas de Vigo','Vigo', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/05/2018', 'DD/MM/YYYY'), to_date('17/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Prueba Circuito Gallego Natacion mar abierto Masculino', 'Tercera prueba del circuito gallego de natacion en mar abierto masculino, prueba celebrada en las aguas de Lugo','Lugo', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/06/2018', 'DD/MM/YYYY'), to_date('17/06/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Prueba Circuito Gallego Natacion mar abierto Masculino', 'Cuarta prueba del circuito gallego de natacion en mar abierto masculino, prueba celebrada en las aguas de Orense','Orense', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/07/2018', 'DD/MM/YYYY'), to_date('17/07/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Master Prueba Circuito Gallego Natacion mar abierto Masculino', 'Prueba final para los nadadores con mejor clasificación en las pruebas anteriores del circuito gallego de natacion en mar abierto masculino, prueba celebrada en Santiago de Compostela','Orense', 150, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/08/2018', 'DD/MM/YYYY'), to_date('17/08/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Prueba Circuito Maratones Galicia Femenino', 'Primera prueba del circuito gallego de maratones femenino, prueba celebrada en A Coruña','A Coruña', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/04/2018', 'DD/MM/YYYY'), to_date('25/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Prueba Circuito Maratones Galicia Femenino', 'Segunda prueba del circuito gallego de maratones femenino, prueba celebrada en Vigo','Vigo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/05/2018', 'DD/MM/YYYY'), to_date('25/04/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Prueba Circuito Maratones Galicia Femenino', 'Tercera prueba del circuito gallego de maratones femenino, prueba celebrada en Lugo','Lugo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('25/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Prueba Circuito Maratones Galicia Femenino', 'Cuarta prueba del circuito gallego de maratones femenino, prueba celebrada en Orense','Orense', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/07/2018', 'DD/MM/YYYY'), to_date('25/06/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Master Circuito Maratones Galicia Femenino', 'Prueba final para las corredoras con mejor clasificación en las pruebas anteriores del circuito gallego de maratones femenino, prueba celebrada en Santiago de Compostela','Santiago de Compostela', 700, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Maraton'), 5, 0, 
	true, true, 42, to_date('01/08/2018', 'DD/MM/YYYY'), to_date('25/07/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Prueba Circuito Gallego Natacion mar abierto Femenino', 'Primera prueba del circuito gallego de natacion en mar abierto femenino, prueba celebrada en las aguas de A Coruña','A Coruña', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/04/2018', 'DD/MM/YYYY'), to_date('17/04/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Prueba Circuito Gallego Natacion mar abierto Femenino', 'Segunda prueba del circuito gallego de natacion en mar abierto femenino, prueba celebrada en las aguas de Vigo','Vigo', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/05/2018', 'DD/MM/YYYY'), to_date('17/05/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Prueba Circuito Gallego Natacion mar abierto Femenino', 'Tercera prueba del circuito gallego de natacion en mar abierto femenino, prueba celebrada en las aguas de Lugo','Lugo', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/06/2018', 'DD/MM/YYYY'), to_date('17/06/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Prueba Circuito Gallego Natacion mar abierto Femenino', 'Cuarta prueba del circuito gallego de natacion en mar abierto femenino, prueba celebrada en las aguas de Orense','Orense', 700, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/07/2018', 'DD/MM/YYYY'), to_date('17/07/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Master Prueba Circuito Gallego Natacion mar abierto Femenino', 'Prueba final para las nadadoras con mejor clasificación en las pruebas anteriores del circuito gallego de natacion en mar abierto femenino, prueba celebrada en Santiago de Compostela','Orense', 150, 3.8, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Natacion'), 5, 0, 
	true, true, 3.8, to_date('20/08/2018', 'DD/MM/YYYY'), to_date('17/08/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Infantil Gallega Masculino', 'Edicion del campeonato gallego de carreras infantiles celebrado en A Coruña','A Coruña', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Infantil Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	true, true, 7, to_date('25/04/2018', 'DD/MM/YYYY'), to_date('20/04/2018', 'DD/MM/YYYY'), true);	
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Infantil Gallega Femenino', 'Edicion del campeonato gallego de carreras infantiles celebrado en Vigo','Vigo', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Infantil Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	true, true, 7, to_date('28/04/2018', 'DD/MM/YYYY'), to_date('26/04/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Infantil Solidaria', 'Carrera infantil solidaria para obtener dinero para las investigaciones de enfermedades infantiles, celebrado en A Coruña','A Coruña', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Infantil Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	false, false, 7, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('29/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Junior Gallega Masculino', 'Edicion del campeonato gallego de carreras categoria junior, celebrado en A Coruña','A Coruña', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Junior Masculino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	true, true, 7, to_date('25/04/2018', 'DD/MM/YYYY'), to_date('20/04/2018', 'DD/MM/YYYY'), true);	
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Junior Gallega Femenino', 'Edicion del campeonato gallego de carreras categoria junior, celebrado en Vigo','Vigo', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Junior Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	true, true, 7, to_date('28/04/2018', 'DD/MM/YYYY'), to_date('26/04/2018', 'DD/MM/YYYY'), true);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('Carrera Solidaria junior', 'Carrera solidaria para obtener dinero para las investigaciones de enfermedades de transmision sexual, celebrado en A Coruña','A Coruña', 150, 7, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Junior Mixto'), (SELECT type_id FROM type WHERE name LIKE 'Carrera Popular'), 5, 0, 
	false, false, 7, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('29/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Etapa Vuelta a Galicia Femenino', 'Primera etapa de la vuelta a Galicia femenina, prueba celebrada en A Coruña','A Coruña', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/04/2018', 'DD/MM/YYYY'), to_date('25/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Etapa Vuelta a Galicia Femenino', 'Segunda etapa de la vuelta a Galicia femenina, prueba celebrada en Vigo','Vigo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/05/2018', 'DD/MM/YYYY'), to_date('25/04/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Etapa Vuelta a Galicia Femenino', 'Tercera etapa de la vuelta a Galicia femenina, prueba celebrada en Lugo','Lugo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('25/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Etapa Vuelta a Galicia Femenino', 'Cuarta etapa de la vuelta a Galicia femenina, prueba celebrada en Orense','Orense', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/07/2018', 'DD/MM/YYYY'), to_date('25/06/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('1º Etapa Vuelta a Galicia Masculina', 'Primera etapa de la vuelta a Galicia masculina, prueba celebrada en A Coruña','A Coruña', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/04/2018', 'DD/MM/YYYY'), to_date('25/03/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('2º Etapa Vuelta a Galicia Masculina', 'Segunda etapa de la vuelta a Galicia masculina, prueba celebrada en Vigo','Vigo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/05/2018', 'DD/MM/YYYY'), to_date('25/04/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('3º Etapa Vuelta a Galicia Masculina', 'Tercera etapa de la vuelta a Galicia masculina, prueba celebrada en Lugo','Lugo', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/06/2018', 'DD/MM/YYYY'), to_date('25/05/2018', 'DD/MM/YYYY'), false);
	
INSERT INTO Event (name, description, location, capacity, distance, assistents, category_id, type_id, price, counter, medicalC, 
	license, length, date, inscriptionDate, production)
VALUES('4º Etapa Vuelta a Galicia Masculina', 'Cuarta etapa de la vuelta a Galicia masculina, prueba celebrada en Orense','Orense', 2000, 42, 0, 
	(SELECT category_id FROM category WHERE name LIKE 'Absoluto Femenino'), (SELECT type_id FROM type WHERE name LIKE 'Ciclismo'), 30, 0, 
	true, true, 42, to_date('01/07/2018', 'DD/MM/YYYY'), to_date('25/06/2018', 'DD/MM/YYYY'), false);
	
	
INSERT INTO EventThirdParties(name, description, location, url, date)
VALUES('X Carrera de la mujer', 'Decima edicion de la carrera de la mujer A Coruña', 'A Coruña',
'http://www.carreradelamujer.com/coruna', to_date('01/07/2018','DD/MM/YYYY'));

INSERT INTO EventThirdParties(name, description, location, url, date)
VALUES('II Carrera Contra el Cancer', 'Segunda edicion de la carrera de la carrera solidaria contra el Cancer Vigo', 'Vigo',
'http://vigocontraelcancer.es/', to_date('01/02/2018','DD/MM/YYYY'));

INSERT INTO EventThirdParties(name, description, location, url, date)
VALUES('V Cross Extreme', 'Quinta edicion de la carrera Cros Xtreme', 'Lugo',
'http://www.lineadesalida.net/carreras/v-paraiso-xtreme-umu/', to_date('01/06/2018','DD/MM/YYYY'));

INSERT INTO EventThirdParties(name, description, location, url, date)
VALUES('X Carrera Aguas Abiertas', 'Decima edicion de la carrera de aguas abiertas A Coruña', 'A Coruña',
'http://cnliceo.com/carreras/', to_date('01/03/2018','DD/MM/YYYY'));
