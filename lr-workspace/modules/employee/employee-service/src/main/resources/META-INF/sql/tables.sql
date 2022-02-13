create table lr_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	phoneNo VARCHAR(75) null,
	salary LONG,
	emailAddress VARCHAR(75) null,
	doj DATE null,
	dol DATE null
);