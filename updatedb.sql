--CREATE DATABASE SWP_HRMS_GRP6_3
--USE SWP_HRMS_GRP6_3
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
	hire_date DATE NOT NULL,
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
	isadmin BIT null,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [profileDetail] (
    profile_id CHAR(5),
	dob DATE NOT NULL,
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
	dob DATE,
	phone VARCHAR(20) NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [experience] (
    profile_id CHAR(5),
	role VARCHAR(20) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

CREATE TABLE [clients] (
    client_id CHAR(5) PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	company VARCHAR(25) NOT NULL,	
);

CREATE TABLE [attendance] (
    shift_id INT IDENTITY(1,1) PRIMARY KEY,
    time_in VARCHAR(30) NOT NULL,
	time_out VARCHAR(30) NOT NULL,
	production_time VARCHAR(30) NOT NULL,
	employee_id CHAR(5),
);

CREATE TABLE [task] (
    name VARCHAR(35),
	priority INT,
	deadline DATE,
	status int,
	assigned CHAR(5),
	FOREIGN KEY (assigned) REFERENCES [profile] (profile_id),
);

CREATE TABLE [projects] (
   title VARCHAR (35),
   client_id CHAR(5),
   start_date DATE,
   end_date DATE,
   rate DECIMAL(8,2),
   manager_id CHAR(5),
   description VARCHAR(255),
   FOREIGN KEY (client_id) REFERENCES [clients] (client_id),
);