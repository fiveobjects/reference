create table emp(emp_id varchar(30), act_status varchar(30), user_name varchar(30));
insert into emp values('a', 'Active', 'u1');
insert into emp values('a', 'Inactive', 'u1');
insert into emp values('b', 'Active', 'u2');
insert into emp values('c', 'Inactive', 'u3');
insert into emp values('a', 'Something', 'u3');
delete from emp where rowid not in 
(select max(rowid) FROM emp group by emp_id);
select * from emp;