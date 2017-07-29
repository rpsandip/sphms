create table SPHMS_Client (
	clientId LONG not null primary key,
	clientName VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	contactPersonName VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	contactPersonPhoneNo VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG
);

create table SPHMS_Hording (
	hordingId LONG not null primary key,
	title VARCHAR(75) null,
	location VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	hordingType VARCHAR(75) null,
	size_ VARCHAR(75) null,
	pricePerMonth DOUBLE,
	normalImageId LONG,
	shortImageId LONG,
	longImageId LONG,
	landLordId LONG,
	ownerType INTEGER,
	upinNo VARCHAR(75) null,
	mncTax DOUBLE,
	otherExpYear DOUBLE,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table SPHMS_LandLord (
	landLordId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	location VARCHAR(75) null,
	city VARCHAR(75) null,
	status INTEGER,
	phoneNo VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG
);

create table SPHMS_LandLordPayment (
	landLordPaymentId LONG not null primary key,
	landLoadId LONG,
	hordingId LONG,
	amount DOUBLE,
	paymentDate DATE null,
	createDate DATE null,
	createdBy LONG
);