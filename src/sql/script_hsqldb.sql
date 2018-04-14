drop table Result IF exists;
drop table Inscription IF exists;
drop table Relationship IF exists;
drop table Tag_event IF exists;
drop table Payment IF exists;
drop table Event IF exists;
drop table Account IF exists;
drop table Type IF exists;
drop table Category IF exists;
drop table Tag IF exists;
drop table Gender IF exists;
drop table EventThirdParties IF exists;


CREATE TABLE Tag(
	tag_Id BIGINT IDENTITY NOT NULL,
	name VARCHAR(30) NOT NULL,
	distance double precision NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Category(
	category_id BIGINT IDENTITY NOT NULL,
	name VARCHAR(30) NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Type(
	type_id BIGINT IDENTITY NOT NULL,
	name VARCHAR(30) NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Account(
	id BIGINT IDENTITY NOT NULL,
	email VARCHAR(60) NOT NULL,
	password VARCHAR(60) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	lastName VARCHAR(60) NOT NULL,
	role VARCHAR(30) NOT NULL,
	public BOOLEAN NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Relationship(
	following_id BIGINT NOT NULL,
	followed_id BIGINT NOT NULL,
);

CREATE TABLE Event(
	event_id BIGINT IDENTITY NOT NULL,
	name VARCHAR(80) NOT NULL,
	description VARCHAR(300),
	location VARCHAR(30) NOT NULL,
	capacity int NOT NULL,
	distance double precision NOT NULL,
	assistents int NOT NULL,
	category_id BIGINT NOT NULL,
	type_id BIGINT NOT NULL,
	price double precision NOT NULL,
	counter int NOT NULL,
	medicalC BOOLEAN NOT NULL,
	license BOOLEAN NOT NULL,
	length double precision NOT NULL,
	date DATE NOT NULL,
	inscriptionDate DATE NOT NULL,
	production BOOLEAN,
	created TIMESTAMP,
);

CREATE TABLE Inscription(
	inscription_id BIGINT IDENTITY NOT NULL,
	dorsal int NOT NULL,
	idChip BIGINT,
	event_id BIGINT NOT NULL,
	id BIGINT NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Tag_event(
	events_event_id BIGINT NOT NULL,
	tags_tag_id BIGINT NOT NULL,
);

CREATE TABLE Result(
	idResult BIGINT IDENTITY NOT NULL,
	time int NOT NULL,
	positionFinal INT NOT NULL,
	event_id BIGINT NOT NULL,
	id BIGINT NOT NULL,
	created TIMESTAMP,
);

CREATE TABLE Payment(
	idPayment BIGINT IDENTITY NOT NULL,
	event_id BIGINT NOT NULL,
	account_id BIGINT NOT NULL,
	userAccountNumber VARCHAR(80),
	eventAccountNumber VARCHAR(80),
	payDate TIMESTAMP,
);

CREATE TABLE Gender(
	gender_id BIGINT IDENTITY NOT NULL,
	name VARCHAR(80) NOT NULL,
);

CREATE TABLE EventThirdParties(
	eventThirdParties_id BIGINT IDENTITY NOT NULL,
	name VARCHAR(80) NOT NULL,
	description VARCHAR(300) NOT NULL,
	location VARCHAR(30) NOT NULL,
	url VARCHAR(200) NOT NULL,
	date DATE NOT NULL,
	created TIMESTAMP,
);
