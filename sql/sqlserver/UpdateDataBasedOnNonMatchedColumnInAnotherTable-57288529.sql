create table tab1
(
    name varchar(30),
    status int
);
create table tab2
(
    name varchar(30)
);

insert into tab1
values('a', 5);
insert into tab1
values('b', 6);
insert into tab1
values('c', 7);
insert into tab1
values('d', 8);

insert into tab2
values('a');
insert into tab2
values('d');

--update tab1 set status = 1 where name not in (select name from tab2); 
-- update tab1 set status = 1 where not exists (select 1 from tab2 where tab1.name=tab2.name);
update tab1 set status = 1 from tab1 left outer join tab2 on tab1.name = tab2.name where tab2.name is null;

select *
from tab1;