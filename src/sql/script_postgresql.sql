drop table IF exists Payment CASCADE;
drop table IF exists Result CASCADE;
drop table IF exists Inscription CASCADE;
drop table IF exists Relationship CASCADE;
drop table IF exists Tag_event CASCADE;
drop table IF exists Event CASCADE;
drop table IF exists Account CASCADE;
drop table IF exists Type CASCADE;
drop table IF exists Category CASCADE;
drop table IF exists Tag CASCADE;
drop table IF exists Gender CASCADE;
drop table IF exists EventThirdParties CASCADE;

CREATE TABLE Tag(
	tag_Id bigserial NOT NULL,
	name VARCHAR(30) NOT NULL,
	distance double precision NOT NULL,
	created TIMESTAMP,
	CONSTRAINT tag_PK PRIMARY KEY (tag_Id)
);

CREATE TABLE Category(
	category_id bigserial NOT NULL,
	name VARCHAR(30) NOT NULL,
	created TIMESTAMP,
	CONSTRAINT category_PK PRIMARY KEY (category_id)
);

CREATE TABLE Type(
	type_id bigserial,
	name VARCHAR(30),
	created TIMESTAMP,
	CONSTRAINT type_PK PRIMARY KEY (type_id)
);

CREATE TABLE Account(
	id bigserial NOT NULL,
	email VARCHAR(60) NOT NULL,
	password VARCHAR(60) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(60) NOT NULL,
	role VARCHAR(30) NOT NULL,
	public bool NOT NULL,
	created TIMESTAMP,
	CONSTRAINT account_PK PRIMARY KEY (id)
);

CREATE TABLE Relationship(
	following_id BIGINT NOT NULL,
	followed_id BIGINT NOT NULL,
	CONSTRAINT relationship_PK PRIMARY KEY (following_id, followed_id)
);

CREATE TABLE Event(
	event_id bigserial NOT NULL,
	name VARCHAR(80) NOT NULL,
	description VARCHAR(300),
	location VARCHAR(30) NOT NULL,
	capacity int NOT NULL,
	distance double precision NOT NULL,
	assistents int NOT NULL,
	category_id BIGINT NOT NULL,
	type_id BIGINT,
	price double precision NOT NULL,
	counter int NOT NULL,
	medicalC bool NOT NULL,
	license bool NOT NULL,
	length double precision NOT NULL,
	date DATE NOT NULL,
	inscriptionDate DATE NOT NULL,
	production bool,
	created TIMESTAMP,
	CONSTRAINT event_PK PRIMARY KEY (event_Id),
	CONSTRAINT eventCategoryId FOREIGN KEY (category_id)
		REFERENCES category (category_id),
	CONSTRAINT eventTypeId FOREIGN KEY (type_id)
		REFERENCES type (type_id)
);

CREATE TABLE Inscription(
	inscription_id bigserial NOT NULL,
	dorsal int NOT NULL,
	idChip BIGINT,
	event_id BIGINT NOT NULL,
	id BIGINT NOT NULL,
	created TIMESTAMP,
	CONSTRAINT inscription_PK PRIMARY KEY (inscription_id),
	CONSTRAINT inscriptionAccountId FOREIGN KEY (id)
		REFERENCES account (id),
	CONSTRAINT inscriptionEventId FOREIGN KEY (event_id)
		REFERENCES event (event_id)
);

CREATE TABLE Tag_event(
	events_event_id BIGINT NOT NULL,
	tags_tag_id BIGINT NOT NULL,
	CONSTRAINT tag_event_PK PRIMARY KEY (events_event_id, tags_tag_id)
);

CREATE TABLE Result(
	idResult bigserial NOT NULL,
	time INT NOT NULL,
	positionFinal INT NOT NULL,
	event_id BIGINT NOT NULL,
	id BIGINT NOT NULL,
	created TIMESTAMP,
	CONSTRAINT result_PK PRIMARY KEY (idResult),
	CONSTRAINT resultAccountId FOREIGN KEY (id)
		REFERENCES account (id),
	CONSTRAINT resultEventId FOREIGN KEY (event_id)
		REFERENCES event (event_id)
);

CREATE TABLE Payment(
	idPayment bigserial NOT NULL,
	event_id BIGINT NOT NULL,
	account_id BIGINT NOT NULL,
	userAccountNumber VARCHAR(80),
	eventAccountNumber VARCHAR(80),
	payDate DATE,
	CONSTRAINT payment_PK PRIMARY KEY (idPayment),
	CONSTRAINT paymentAccountId FOREIGN KEY (account_id)
		REFERENCES account (id),
	CONSTRAINT paymentEventId FOREIGN KEY (event_id)
		REFERENCES event (event_id)
);

CREATE TABLE EventThirdParties(
	eventThirdParties_id bigserial NOT NULL,
	name VARCHAR(80) NOT NULL,
	description VARCHAR(300) NOT NULL,
	location VARCHAR(30) NOT NULL,
	url VARCHAR(200) NOT NULL,
	date DATE NOT NULL,
	created TIMESTAMP,
	CONSTRAINT eventThirdParties_PK PRIMARY KEY (eventThirdParties_id)
);

CREATE TABLE Gender(
	gender_id bigserial NOT NULL,
	name VARCHAR(80) NOT NULL,
	CONSTRAINT gender_PK PRIMARY KEY (gender_id)
);
