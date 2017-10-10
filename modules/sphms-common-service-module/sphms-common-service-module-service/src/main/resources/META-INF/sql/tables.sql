create table SPHMS_Billing (
	billingId LONG not null primary key,
	billNo VARCHAR(75) null,
	bookingId LONG,
	clientId LONG,
	billFileEntryId LONG,
	clientPANNo VARCHAR(75) null,
	clientPONumber VARCHAR(75) null,
	clientGSTNumber VARCHAR(75) null,
	display VARCHAR(75) null,
	accessAmount DOUBLE,
	pendingAmount DOUBLE,
	financialYear VARCHAR(75) null,
	creditNoteAmount DOUBLE,
	creditNoteTax DOUBLE,
	status INTEGER,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table SPHMS_Billing_Hording (
	billingId LONG not null,
	hordingId LONG not null,
	totalMountingCharge DOUBLE,
	totalPrintingCharge DOUBLE,
	units INTEGER,
	totalHordingCharge DOUBLE,
	hsnNo VARCHAR(75) null,
	primary key (billingId, hordingId)
);

create table SPHMS_Booking (
	bookingId LONG not null primary key,
	campaignTitle VARCHAR(100) null,
	client LONG,
	billId LONG,
	startDate DATE null,
	endDate DATE null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table SPHMS_Booking_Hording (
	bookingId LONG not null,
	hordingId LONG not null,
	mountingCharge DOUBLE,
	printingCharge DOUBLE,
	units INTEGER,
	primary key (bookingId, hordingId)
);

create table SPHMS_Client (
	clientId LONG not null primary key,
	clientName VARCHAR(100) null,
	address1 VARCHAR(100) null,
	address2 VARCHAR(100) null,
	city VARCHAR(50) null,
	state_ VARCHAR(75) null,
	contactPersonName VARCHAR(50) null,
	contactPersonEmail VARCHAR(50) null,
	contactPersonPhoneNo VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG
);

create table SPHMS_Hording (
	hordingId LONG not null primary key,
	title VARCHAR(100) null,
	location VARCHAR(75) null,
	city VARCHAR(75) null,
	district VARCHAR(75) null,
	state_ VARCHAR(75) null,
	hordingType VARCHAR(10) null,
	mediaVehicle VARCHAR(30) null,
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
	firstName VARCHAR(100) null,
	lastName VARCHAR(100) null,
	location VARCHAR(100) null,
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

create table SPHMS_Payment (
	paymentId LONG not null primary key,
	billingId LONG,
	clientId LONG,
	amount DOUBLE,
	chequeNo VARCHAR(75) null,
	tds DOUBLE,
	deduction DOUBLE,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table SPHMS_Proposal (
	proposalId LONG not null primary key,
	campaignTitle VARCHAR(200) null,
	client LONG,
	pptFileId LONG,
	xlsxFileId LONG,
	startDate DATE null,
	endDate DATE null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table SPHMS_Proposal_Hording (
	proposalId LONG not null,
	hordingId LONG not null,
	mountingCharge DOUBLE,
	printingCharge DOUBLE,
	units INTEGER,
	primary key (proposalId, hordingId)
);