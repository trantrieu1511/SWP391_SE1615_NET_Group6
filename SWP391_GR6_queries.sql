select * from departments
select * from [Profile]
select * from jobs
select * from [Profile] where ReportsTo = 'MRAAA'


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

--insert manager

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary)
values ('ABCDE', 'Trieu', 'Tran', 'trantrieu@gmail.com', '0123456789', GETDATE(), 1, 1, 100)
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary)
values ('MRAAA', 'MR', 'A', 'MRA@gmail.com', 'XXX-XXX-XXXX', GETDATE(), 1, 1, 100)


--insert staff
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,department_id,salary,report_to)
values ('ASDFG', 'MR', 'A', 'MRA@gmail.com', '01234xxxxx', '2022-05-28', 1, 1, 100 'ABCDE')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])
values ('ABDFG', 'MR', 'B', 'MRB@gmail.com', '01234xxxxx', '28/05/2022', 1, 100, 'ABCDE', 1, 'mrb', 'mrb')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])
values ('ABDFG', 'MR', 'B', 'MRB@gmail.com', '01234xxxxx', '28/05/2022', 1, 100, 'ABCDE', 1, 'mrb', 'mrb')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])
values ('MRDEL', 'mr', 'delete', 'MRB@gmail.com', 'mrdelete phonenumber', '04/06/2022', 1, 100, 'ABCDE', 1, 'mrdelete', 'mrdelete')

--remove staff
select * from [Profile]
select * from [Profile] where ReportsTo = 'ABCDE';

delete from [Profile]
where profile_id = 'MRAYY'
delete from [Profile]
where profile_id = 'MRSTA'



-- Select 
	select p.profile_id, p.first_name, p.last_name, p.email, p.phone_number, 
	p.hire_date, j.job_title, p.salary, p.ReportsTo, p.isadmin, d.department_name,
	p.username, p.[password]
	from [Profile] p, departments d, jobs j
	where p.job_id = j.job_id and p.department_id = d.department_id
	and ReportsTo is not null

	select * from [Profile] where profile_id = 'ABABA'

-- update
update [Profile] set profile_id = 'ABABA', first_name = 'a', last_name = 'b', email = 'ab@gmail.com', phone_number = '0321656489', hire_date = GETDATE(), job_id = 2,
salary = 0, ReportsTo = 'ABCDE', department_id = 2, username = 'ab', [password] = 'ab', img = '' where profile_id = 'ab'\

--filter
select * from [Profile]
where profile
