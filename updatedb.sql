--CREATE DATABASE SWP_HRMS_GRP6_3
USE SWP_HRMS_GRP6_3
--DROP DATABASE SWP_HRMS_GRP6_3
CREATE TABLE [jobs] (
	job_id INT IDENTITY(1,1) PRIMARY KEY,
	job_title VARCHAR (35) NOT NULL,
	min_salary DECIMAL (8, 2) DEFAULT NULL,
	max_salary DECIMAL (8, 2) DEFAULT NULL
);

CREATE TABLE [departments] (
	department_id INT IDENTITY(1,1) PRIMARY KEY,
	department_name VARCHAR (30) NOT NULL,
);

CREATE TABLE [profile] (
	profile_id CHAR(5) PRIMARY KEY,
	first_name VARCHAR (20) NOT NULL,
	last_name VARCHAR (20) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) NULL,
	hire_date VARCHAR (20) NOT NULL,
	job_id INT NULL,
	department_id INT NULL,	
	salary DECIMAL (8, 2) NOT NULL,
	report_to CHAR(5) NULL,
	FOREIGN KEY (job_id) REFERENCES jobs (job_id),
	FOREIGN KEY (department_id) REFERENCES departments (department_id),
	FOREIGN KEY (report_to) REFERENCES [profile] (profile_id)
);

CREATE TABLE [account] (
    profile_id CHAR(5),
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL, 
	isadmin BIT NOT NULL,
	ismanager BIT NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [salary] (
    profile_id CHAR(5),
	basic_salary DECIMAL (8, 2) NOT NULL,
	HRA DECIMAL (8, 2) DEFAULT NULL,
	conveyance DECIMAL (8, 2) DEFAULT NULL,
	allowance DECIMAL (8, 2) DEFAULT NULL,
	medical_allowance DECIMAL (8, 2) DEFAULT NULL,
	TDS DECIMAL (8, 2) DEFAULT NULL,
	ESI DECIMAL (8, 2) DEFAULT NULL,
	PF DECIMAL (8, 2) DEFAULT NULL,
	leave DECIMAL (8, 2) DEFAULT NULL,
	loan DECIMAL (8, 2) DEFAULT NULL,
	professional_tax DECIMAL (8, 2) DEFAULT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [profileDetail] (
    profile_id CHAR(5),
	dob VARCHAR(20) NOT NULL,
	address VARCHAR(150) NOT NULL,
	gender BIT NOT NULL,
	country VARCHAR(20) NOT NULL,
	religion VARCHAR(20) NOT NULL,
	isMarried BIT NOT NULL,
	children INT NULL,
	bank_name VARCHAR(20) NOT NULL,
	bank_number VARCHAR(20) NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [familyInfo] ( 
    profile_id CHAR(5),
	name VARCHAR(50) NOT NULL,
	relationship VARCHAR(20) NOT NULL,
	dob VARCHAR (20),
	phone VARCHAR(20) NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table [experience]
CREATE TABLE [experience] (
    profile_id CHAR(5),
	role VARCHAR(100) NOT NULL,
	start_date varchar(20) NOT NULL,
	end_date varchar(20) NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table clients
CREATE TABLE [clients] (
    client_id CHAR(5) PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	company VARCHAR(25) NOT NULL,
	FOREIGN KEY (company) REFERENCES [company] (company_id)
);

CREATE TABLE [company] (
    company_id INT IDENTITY(1,1) PRIMARY KEY,
	company_name VARCHAR (25) NOT NULL,
);


CREATE TABLE [attendance] (
    shift_id INT IDENTITY(1,1) PRIMARY KEY,
	date VARCHAR(30) NOT NULL,
    time_in VARCHAR(30) NOT NULL,
	time_out VARCHAR(30) NOT NULL,
	production_time VARCHAR(30) NOT NULL,
	employee_id CHAR(5),
	note VARCHAR(45),
);

CREATE TABLE [shift](
    name VARCHAR(15) PRIMARY KEY NOT NULL,
	start_time VARCHAR(20) NOT NULL,
	end_time VARCHAR(20) NOT NULL,

);

CREATE TABLE [schedule](
    profile_id CHAR(5),
	shift_name VARCHAR(255),
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id),
	FOREIGN KEY (shift_name) REFERENCES [shift] (name),
);

--drop table projects

CREATE TABLE [projects] (
   title VARCHAR (35) PRIMARY KEY,
   client_id CHAR(5),
   period VARCHAR(50),
   rate DECIMAL(8,2),
   manager_id CHAR(5),
   description VARCHAR(255),
   FOREIGN KEY (client_id) REFERENCES [clients] (client_id),
   FOREIGN KEY (manager_id) REFERENCES [profile] (profile_id),
);

CREATE TABLE [task] (
    name VARCHAR(35) PRIMARY KEY,
	priority INT,
	deadline VARCHAR(20),
	status int,
	assigned CHAR(5),
	project VARCHAR(35),
	FOREIGN KEY (assigned) REFERENCES [profile] (profile_id),
	FOREIGN KEY (project) REFERENCES [projects] (title),
);