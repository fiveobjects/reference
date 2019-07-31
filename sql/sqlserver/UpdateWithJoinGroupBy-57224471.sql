-- fiddle: https://dbfiddle.uk/?rdbms=sqlserver_2017&fiddle=88d26c1814168079d555e6bc2e214daa
create table appt
(
    target int,
    target_cumulative int,
    unique_id int,
    resource_id int,
    start_date datetime
);
create table inserted
(
    unique_id int,
    value int
);

insert into appt
values(10, 0, 1, 1, '2019-07-26 08:00:00');
insert into appt
values(20, 0, 2, 2, '2019-07-26 07:00:00');
insert into appt
values(30, 0, 3, 1, '2019-07-26 10:00:00');
insert into appt
values(10, 0, 4, 1, '2019-07-26 11:00:00');
insert into appt
values(20, 0, 5, 2, '2019-07-26 09:00:00');

insert into inserted
values(1, 10);
insert into inserted
values(2, 10);
insert into inserted
values(3, 10);
insert into inserted
values(4, 10);
insert into inserted
values(5, 10);

update appt set target_cumulative=xtarget
from (select t1.resource_id, sum(t1.target)as xtarget
    from appt t1
        inner join inserted as i on t1.unique_id=i.unique_id
    group by convert(date, t1.start_date), t1.resource_id) t2
where appt.resource_id=t2.resource_id;
