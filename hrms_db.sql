--Create Database SWP_HRMS_GRP6_2
USE SWP_HRMS_GRP6_2
--drop database SWP_HRMS_GRP6_2
CREATE TABLE regions (
	region_id INT IDENTITY(1,1) PRIMARY KEY,
	region_name VARCHAR (25) DEFAULT NULL
);

CREATE TABLE countries (
	country_id CHAR (2) PRIMARY KEY,
	country_name VARCHAR (40) DEFAULT NULL,
	region_id INT NOT NULL,
	FOREIGN KEY (region_id) REFERENCES regions (region_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE locations (
	location_id INT IDENTITY(1,1) PRIMARY KEY,
	street_address VARCHAR (40) DEFAULT NULL,
	postal_code VARCHAR (12) DEFAULT NULL,
	city VARCHAR (30) NOT NULL,
	state_province VARCHAR (25) DEFAULT NULL,
	country_id CHAR (2) NOT NULL,
	FOREIGN KEY (country_id) REFERENCES countries (country_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE jobs (
	job_id INT IDENTITY(1,1) PRIMARY KEY,
	job_title VARCHAR (35) NOT NULL,
	min_salary DECIMAL (8, 2) DEFAULT NULL,
	max_salary DECIMAL (8, 2) DEFAULT NULL
);

CREATE TABLE departments (
	department_id INT IDENTITY(1,1) PRIMARY KEY,
	department_name VARCHAR (30) NOT NULL,
	location_id INT DEFAULT NULL,
	FOREIGN KEY (location_id) REFERENCES locations (location_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- note: những profile mà không cần phải ReportsTo thì được coi là manager
-- cột isadmin = 1 thì là admin, = 0 thì là 2 loại profile còn lại (Manager or Staff tùy vào ReportsTo)
CREATE TABLE [profile] (
	profile_id CHAR(5) PRIMARY KEY,
	first_name VARCHAR (20) NOT NULL,
	last_name VARCHAR (25) NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	hire_date DATE NOT NULL,
	job_id INT NULL,
	salary DECIMAL (8, 2) NOT NULL,
	ReportsTo CHAR(5) DEFAULT NULL,
	isadmin bit null,
	department_id INT DEFAULT NULL,	
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL, 
	FOREIGN KEY (job_id) REFERENCES jobs (job_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (department_id) REFERENCES departments (department_id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (ReportsTo) REFERENCES [profile] (profile_id)
);

CREATE TABLE clients (
    client_id CHAR(5) PRIMARY KEY,
	first_name VARCHAR (20) DEFAULT NULL,
	last_name VARCHAR (25) NOT NULL,
	email VARCHAR (100) NOT NULL,
	phone_number VARCHAR (20) DEFAULT NULL,
	company VARCHAR(25) NOT NULL,	
);

--drop table attendance
CREATE TABLE attendance (
    shift_id INT IDENTITY(1,1) PRIMARY KEY,
    time_in VARCHAR(30) NOT NULL,
	time_out VARCHAR(30) NOT NULL,
	production_time VARCHAR(30) NOT NULL,
	employee_id CHAR(5),
);

CREATE TABLE shift (
    start_time VARCHAR(20),
	end_time VARCHAR(20)
);

CREATE TABLE task (
    name VARCHAR(35),
	priority INT,
	deadline DATE,
	status int,
	assigned CHAR(5),
	FOREIGN KEY (assigned) REFERENCES [profile] (profile_id)
);

CREATE TABLE projects (
   title VARCHAR (35),
   client_id CHAR(5),
   start_date DATE,
   end_date DATE,
   rate DECIMAL(8,2),
   manager_id CHAR(5),
   description VARCHAR(255),
   FOREIGN KEY (client_id) REFERENCES [clients] (client_id),
);
