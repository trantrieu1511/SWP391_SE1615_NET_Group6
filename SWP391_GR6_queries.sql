select * from departments
select * from [profile]
select * from [profileDetail]
select * from [experience]
select * from [familyInfo]
select * from jobs
select * from [profile] where report_to = 'MRAAA'
select * from account where profile_id = 'ABCDE'
select * from attendance
select * from account
select * from projects
select * from clients

select * from [profile] p, account a where
p.profile_id = a.profile_id

--add account
insert into account values ('ABCDE', 'trantrieu123', '12345678',0,1)
insert into account values ('MBEAN', 'mrbean', 'mbean', 0,0)
insert into account values ('ADMIN', 'admin', 'admin',1,0)

--insert jobs
insert into jobs(job_title) values('Web Designer')
insert into jobs(job_title) values('Web Developer')
insert into jobs(job_title) values('UI/UX Developer')
insert into jobs(job_title) values('Software Tester')
insert into jobs(job_title) values('Software Engineer')
insert into jobs(job_title) values('Android Developer')
insert into jobs(job_title) values('Ios Developer')

--insert departments
insert into departments(department_name) values('IT Management')
insert into departments([department_name]) values('Web Development')

--insert admin
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary)
values ('ADMIN', 'mr', 'admin', 'admin@mail.com', '0123456789', GETDATE(), NULL, NULL, 0)

--insert manager

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary)
values ('ABCDE', 'Trieu', 'Tran', 'trantrieu@gmail.com', '0123456789', GETDATE(), 1, 1, 100)
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary)
values ('MRAAA', 'MR', 'A', 'MRA@gmail.com', 'XXX-XXX-XXXX', GETDATE(), 1, 1, 100)


--insert staff
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('ASDFG', 'MR', 'ASDFG', 'MRASDFG@gmail.com', '01234xxxxx', GETDATE(), 1, 1, 100, 'ABCDE')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('AAAAA', 'Christiano', 'Ronaldo', 'christianoronaldo@gmail.com', '123456789', GETDATE(), 3, 2, 1000, 'ABCDE')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('ASDFG', 'MR', 'ASDFG', 'MRASDFG@gmail.com', '01234xxxxx', GETDATE(), 1, 1, 100, 'ABCDE')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('MRDEL', 'mr', 'delete', 'mrdelete@gmail.com', 'mrdelete', GETDATE(), 1, 1, 100, 'ABCDE')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('mr123', 'mr', 'delete', 'mrdelete@gmail.com', 'mrdelete', GETDATE(), 1, 1, 100, 'ABCDE')

-- select account
select * from account

--delete acc
delete from account where profile_id = 'MBEAN'

-- insert account
insert into account values ('ASDFG', 'asdfg', 'asdfg', 0,0)
insert into account values ('AAAAA', 'aaaaa', 'aaaaa', 0,0)
insert into account values ('MRDEL', 'mrdel', 'mrdel', 0,0)
insert into account values ('ABCDE', 'trantrieu123', '12345678', 0,1)



--update acc
update account
set
isadmin = 0 where profile_id = 'ABCDE'

--remove staff
select * from [Profile]
select * from [Profile] where ReportsTo = 'ABCDE';

delete from [Profile]
where profile_id = 'MRAYY'
delete from [Profile]
where profile_id = 'MRSTA'




-- Select all Staff of a manager
		select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, 
		p.hire_date, j.job_title, d.department_name, p.salary, p.report_to,
		a.username, a.[password], a.isadmin
		from [profile] p, departments d, jobs j, account a
		where p.job_id = j.job_id and p.department_id = d.department_id and p.profile_id = a.profile_id
		and report_to = 'ABCDE'

-- Select all profile
	select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, 
	p.hire_date, j.job_title, d.department_name, p.salary, p.report_to,
	a.username, a.[password], a.isadmin
	from [profile] p, departments d, jobs j, account a
	where p.job_id = j.job_id and p.department_id = d.department_id and p.profile_id = a.profile_id
	
	select p.*
	from [profile] p, departments d, jobs j, account a
	where p.job_id = j.job_id and p.department_id = d.department_id and p.profile_id = a.profile_id
	and a.profile_id = p.profile_id
	

	select j.* from jobs j, [profile] p where j.job_id = p.job_id and p.report_to is not null
	select d.* from departments d, [profile] p where d.department_id = p.department_id and p.report_to = 'ABCDE'
 
-- update
update [Profile] set profile_id = 'ABABA', first_name = 'a', last_name = 'b', email = 'ab@gmail.com', phone_number = '0321656489', hire_date = GETDATE(), job_id = 2,
salary = 0, ReportsTo = 'ABCDE', department_id = 2, username = 'ab', [password] = 'ab', img = '' where profile_id = 'ab'

update [Profile]
set 
--first_name = 'a', 
--last_name = 'b', 
--email = 'ab@gmail.com', 
--phone_number = '0321656489', 
hire_date = '03/07/2022'
--department_id = 1,
--job_id = 1,
--salary = 0, 
--report_to = 'ABCDE'
where profile_id = 'ABCDE'

--search by name
select * from [profile]
where report_to = 'ABCDE'
and first_name + last_name like '%r%'
--search by id
select * from [profile]
where report_to = 'ABCDE'
and profile_id like '%m%'
--search by job
select * from [profile]
where report_to = 'ABCDE'
and job_id = '3'
-- filter staff
--search with job
select * from [profile] where profile_id like '%m%' and job_id = 1	and first_name + last_name like '%a%' and report_to is not null
--search without job
select * from [profile] where profile_id like '%m%' and first_name + last_name like '%a%' and report_to is not null

--select clients
select * from clients cl join projects pj 
on cl.client_id = pj.client_id

-- filter client
--search with company name
select * from [clients] where client_id like '%%' and company_id = ''
--search without company name
select * from [clients] where client_id like '%%' and first_name + last_name like '%%'

--select profileDetail
select * from [profile] where profile_id = 'AAAAA'
select * from [profileDetail] where profile_id = 'AAAAA'

--insert profileDetail

insert into profileDetail
values ('ABCDE', '2002-11-15', 'so nha 16, to 19, phuong Tan Thinh, tp HB, tinh HB', 1, 'Vietnam', 'no', 0, 0, 'BIDV', '03216546879')

insert into [profileDetail]
values ('MRNEW', GETDATE(), 'so nha 16, to 19, phuong Tan Thinh, tp HB, tinh HB', 'true', 'Vietnam', 'no', 'false', 0, 'BIDV', '03216546879')



--select familyInfo
select * from [familyInfo]

--insert familyInfo
insert into [familyInfo]
values ('ABCDE','Nguyen Thi Oanh','mother','1900-01-01','123456789')

--select experience
select * from [experience]

--insert experience
insert into [experience]
values ('ABCDE', 'Web Designer at...','1900-01-01','1900-01-01')
insert into [experience]
values ('MRNEW', 'N/A','1900-01-01','2022-06-18')
insert into [experience]
values ('MBEAN', 'N/A','1900-01-01','2022-06-18')
insert into [experience]
values ('MRAAA', 'N/A','1900-01-01','2022-06-18')
insert into [experience]
values ('MRDEL', 'N/A','1900-01-01','2022-06-18')
insert into [experience]
values ('MRBBB', 'N/A','1900-01-01','2022-06-18')

insert into [experience]
values ('MRDDD', 'N/A','1900-01-01',GETDATE())


-- update profileDetail
update [profileDetail]
set 
dob = '1900-01-01',
address = 'N/A',
gender = 1,
country = 'N/A',
religion = 'N/A',
isMarried = 1,
children = 2,
bank_name = 'N/A',
bank_number = 'N/A'
where profile_id = 'ABCDE'

-- update familyInfo
select * from [familyInfo]
update [familyInfo]
set
[name] = 'N/A',
relationship = 'N/A',
dob = '1973-03-12',
phone = 'N/A'
where 
profile_id = 'ABCDE' 
and [name] = 'N/A'

--update experience
select * from experience
update [experience]
set
[role] = 'mra second biggest role 2',
[start_date] = '2020-06-22',
[end_date] = '2022-06-22'
where profile_id = 'ABCDE'
and [role] = 'mra second biggest role'

--delete profileDetail
delete from [profileDetail]
where profile_id = 'MRNEW'

--delete familyInfo
delete from [familyInfo]
where profile_id = 'ABCDE' and [name] = 'N/A'

--delete experience
delete from [experience]
where profile_id = 'ABCDE' and [role] = 'N/A'


-- select all info of a staff profile
select * from [profile] p, profileDetail pd, familyInfo f, experience e, account a
where p.profile_id = pd.profile_id and p.profile_id = f.profile_id and
p.profile_id = e.profile_id and p.profile_id = a.profile_id

select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, p.hire_date, p.job_id,
p.department_id, p.salary, p.report_to, a.username, a.[password], a.isadmin, a.ismanager
from [profile] p, [account] a 
where p.profile_id = a.profile_id 
and p.report_to = 'ABCDE'


-- clients
select client_id, first_name, last_name, email,
phone_number, company_id, company_name from clients join 
company on clients.company = company.company_id

select * from clients
insert into clients 
values('CL002', 'mr', 'client2', 'mrclient2@mail.com', '0123456789','C-Company')

delete from clients where client_id = '1'

insert into clients 
values('1', 'mr', 'client', 'mrclient@mail.com', '0123456789','C-Company')
select * from projects

-- edit client
select * from clients
update [clients]
set
--first_name = 'mra',
--last_name = 'mra',
--email = 'mra',
--phone_number = '0123456789',
company_id = 4
where client_id = 'CL004'

--insert company
select * from [company]
insert into [company](company_name) values('Global Technology')
insert into [company](company_name) values('Delta Infotech')
insert into [company](company_name) values('Carlson Tech')
insert into [company](company_name) values('Cream Inc')
insert into [company](company_name) values('International Software')
insert into [company](company_name) values('Mercury Software Inc')
insert into [company](company_name) values('Mustang Technologies')
insert into [company](company_name) values('Wellware Company')

--edit company
update [company] set company_name = 'C Company' where company_id = 3

--select all profile
select * from account
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin != 1

--select salary
select * from salary

select s.*, ((basic_salary+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary from salary s
where profile_id = 'ABCDE'

select s.*, ((basic_salary+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary from salary s 
where profile_id = 'ABCDE'

--add salary
select * from [profile]
insert into salary 
values('MRTTT', 100000, 100, 0, 0, 0, 100, 20, 0, 0, 10, 0, 10, '01/07/2022')
select * from salary
--edit salary
update salary
set
basic_salary = 3000,
DA = 15,
HRA = 20,
conveyance = 50,
allowance = 25,
medical_allowance = 35,
TDS = 100,
ESI = 10,
PF = 2,
leave = 5,
loan = 16,
professional_tax = 30
--create_date = '02/07/2022'
where profile_id = 'SSSSS'

--delete salary
delete from salary where profile_id = 'AAAAA' and basic_salary = 250

select * from account

--filter salary
-- search with ename erole from to
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin = 0
and a.ismanager = 'true'
and p.first_name + p.last_name like '%t%'
and s.create_date BETWEEN '02/07/2022' and '05/07/2022'

-- search with date created (from)
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin = 0
--and a.ismanager = 'false'
--and p.first_name + p.last_name like '%true%'
--and s.create_date >= '02/07/2022'

-- search with date created only
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin = 0
and p.first_name + p.last_name like '%%'
and s.create_date BETWEEN '02/07/2022' and '05/07/2022'

--search without create-date
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin = 0
and a.ismanager = 1
and p.first_name + p.last_name like '%t%'


--search without ename and create date
select p.*, s.basic_salary, s.DA, s.HRA, s.conveyance, s.allowance, s.medical_allowance,
s.TDS, s.ESI, s.PF, s.leave, s.loan, s.professional_tax, ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary,
s.create_date
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin != 1
and a.ismanager = 'false'

--query for choose staff option in add Salary
select p.profile_id, p.first_name, p.last_name, s.basic_salary
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin = 0 
and s.basic_salary is null

--get Staff net Salary only
select ((basic_salary+DA+HRA+conveyance+allowance+medical_allowance)-(TDS+ESI+PF+leave+loan+professional_tax)) as net_salary
from [profile] p full outer join [account] a 
on p.profile_id = a.profile_id 
full outer join [salary] s
on p.profile_id = s.profile_id
where a.isadmin != 1
and report_to = 'ABCDE'
order by p.profile_id asc

--projects
select * from projects