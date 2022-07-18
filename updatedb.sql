--CREATE DATABASE SWP_HRMS_GRP6_3
USE SWP_HRMS_GRP6_3
--DROP DATABASE SWP_HRMS_GRP6_3
CREATE TABLE [jobs] (
	job_id INT IDENTITY(1,1) PRIMARY KEY,
	job_title VARCHAR (35) NOT NULL,
	min_salary DECIMAL (8, 2) DEFAULT NULL,
	max_salary DECIMAL (8, 2) DEFAULT NULL
);

--drop table [departments]
CREATE TABLE [departments] (
	department_id INT IDENTITY(1,1) PRIMARY KEY,
	department_name VARCHAR (30) NOT NULL,
);

--drop table [profile]
CREATE TABLE [profile] (
	id INT identity,
    profile_id AS (UPPER(LEFT(first_name,1) + LEFT(last_name,1))
    + REPLICATE('0', 3-LEN(Id)) + CAST(Id AS VARCHAR)) PERSISTED PRIMARY KEY,
	first_name VARCHAR (20) NOT NULL,
	last_name VARCHAR (20) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) NULL,
	hire_date VARCHAR (20) NOT NULL,
	job_id INT NULL,
	department_id INT NULL,
	report_to VARCHAR(8000),
	FOREIGN KEY (job_id) REFERENCES jobs (job_id),
	FOREIGN KEY (department_id) REFERENCES departments (department_id),
	FOREIGN KEY (report_to) REFERENCES [profile] (profile_id)
);

CREATE TABLE [account] (
    profile_id VARCHAR(8000),
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL, 
	isadmin BIT NOT NULL,
	ismanager BIT NOT NULL,
	status BIT DEFAULT 1 NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table salary
CREATE TABLE [salary] (
	payslip_number INT IDENTITY(1,1) PRIMARY KEY,
    profile_id VARCHAR(8000),
	basic_salary DECIMAL (8, 2) NOT NULL,
	DA DECIMAL (8, 2) DEFAULT NULL,
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
	create_date varchar(20) NOT NULL
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table [leaveType]
CREATE TABLE [leaveType] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(35),
);

--drop table [leave]
CREATE TABLE [leave] (
    id INT IDENTITY(1,1) PRIMARY KEY,
	profile_id VARCHAR(8000),
	leave_type INT NOT NULL,
    [from] VARCHAR(35) NOT NULL,
	[to] VARCHAR(35) NOT NULL,
	number_of_days VARCHAR(35) NOT NULL,
	reason VARCHAR(100) DEFAULT NULL,
	[status] int DEFAULT 1 NOT NULL, --1:Pending; 2:Approved; 3:Declined 
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id),
	FOREIGN KEY (leave_type) REFERENCES [leaveType] (id),
);

CREATE TABLE [profileDetail] (
    profile_id VARCHAR(8000),
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
    profile_id VARCHAR(8000),
	name VARCHAR(50) NOT NULL,
	relationship VARCHAR(20) NOT NULL,
	dob VARCHAR (20),
	phone VARCHAR(20) NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table [experience]
CREATE TABLE [experience] (
    profile_id VARCHAR(8000),
	role VARCHAR(100) NOT NULL,
	start_date varchar(20) NOT NULL,
	end_date varchar(20) NULL,
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table [company]
CREATE TABLE [company] (
    company_id INT IDENTITY(1,1) PRIMARY KEY,
	company_name VARCHAR (25) NOT NULL,
);

--drop table clients
CREATE TABLE [clients] (
	id INT IDENTITY,
    client_id AS (UPPER(LEFT(first_name,1) + LEFT(last_name,1))
    + REPLICATE('0', 3-LEN(Id)) + CAST(Id AS VARCHAR)) PERSISTED PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	company_id INT NOT NULL,
	FOREIGN KEY (company_id) REFERENCES [company] (company_id)
);

CREATE TABLE [attendance] (
    shift_id INT IDENTITY(1,1) PRIMARY KEY,
	date VARCHAR(30) NOT NULL,
    time_in VARCHAR(30) NOT NULL,
	time_out VARCHAR(30) NOT NULL,
	production_time VARCHAR(30) NOT NULL,
	employee_id VARCHAR(8000),
	note VARCHAR(45),
);

CREATE TABLE [shift](
    name VARCHAR(255) PRIMARY KEY NOT NULL,
	start_time VARCHAR(20) NOT NULL,
	end_time VARCHAR(20) NOT NULL,
);

CREATE TABLE [schedule](
    profile_id VARCHAR(8000),
	shift_name VARCHAR(255),
	FOREIGN KEY (profile_id) REFERENCES [profile] (profile_id)
);

--drop table projects
CREATE TABLE [projects] (
   title VARCHAR (35) PRIMARY KEY,
   client_id VARCHAR(8000),
   period VARCHAR(50),
   rate DECIMAL(8,2),
   manager_id VARCHAR(8000),
   description VARCHAR(255),
   status INT,
   FOREIGN KEY (client_id) REFERENCES [clients] (client_id),
   FOREIGN KEY (manager_id) REFERENCES [profile] (profile_id),
);

-- drop table task
CREATE TABLE [task] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(35),
	priority INT,
	deadline VARCHAR(20),
	status int,
	assigned VARCHAR(8000),
	project VARCHAR(35),
	FOREIGN KEY (assigned) REFERENCES [profile] (profile_id),
	FOREIGN KEY (project) REFERENCES [projects] (title),
);