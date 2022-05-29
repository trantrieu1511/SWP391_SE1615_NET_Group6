select * from departments
select * from [Profile]
select * from jobs

--insert manager

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,department_id,username,[password])
values ('ABCDE', 'Trieu', 'Tran', 'trantrieu@gmail.com', '0123456789', '2022-05-28', 1, 100, 1, 'trantrieu123', 'trantrieu123' )

--insert staff
insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])
values ('ASDFG', 'MR', 'A', 'MRA@gmail.com', '01234xxxxx', '2022-05-28', 1, 100, 'ABCDE', 1, 'mra', 'mra')

insert into [Profile](profile_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,ReportsTo,department_id,username,[password])
values ('ABDFG', 'MR', 'B', 'MRB@gmail.com', '01234xxxxx', '28/05/2022', 1, 100, 'ABCDE', 1, 'mrb', 'mrb')


--remove staff
delete from [Profile]
where profile_id = 'ABCDE'

insert into jobs(job_title) values('Web Developer')

insert into departments([department_name]) values('Web Development')
