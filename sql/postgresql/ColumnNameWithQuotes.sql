create table tab1
(
    data varchar(30)
);

alter table tab1 ADD “Name1” varchar
(50);
alter table tab1 ADD "Name2" varchar(50);

select *
from tab1;
select table_name, column_name
from information_schema.columns
where table_name='tab1';

alter table tab1 drop column “Name1”;
alter table tab1 drop column "Name2";