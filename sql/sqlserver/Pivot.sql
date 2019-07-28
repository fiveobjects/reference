create table hr
(
    name varchar(50),
    ponumber int,
    jan int,
    feb int,
    mar int,
    apr int,
    may int,
    jun int,
    jul int,
    aug int,
    sep int,
    oct int,
    nov int,
    dec int
);

create table invoice
(
    ponumber int,
    year int,
    month int,
    amount int
);

insert into hr
values('Mark', 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
insert into hr
values('Adam', 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

insert into invoice
values(1000, 2019, 20190124, 10);
insert into invoice
values(1000, 2019, 20190224, 10);
insert into invoice
values(1000, 2019, 20190324, 20);

insert into invoice
values(2000, 2019, 20190124, 20);
insert into invoice
values(2000, 2019, 20190224, 20);
insert into invoice
values(2000, 2019, 20190324, 20);
insert into invoice
values(2000, 2019, 20190424, 30);

select *
from hr;

select *
from invoice;

select ponumber, [20190124] as jan, [20190224] as feb, [20190324] mar, [20190424] as apr,
    [20190524] as may, [20190624] as jun, [20190724] as jul, [20190824] as aug,
    [20190924] as sep, [20191024] as oct, [20191124] as nov, [20191224] as dec
from (
  select ponumber, [month], amount
    from invoice
) as d
   pivot(
   max(amount)
   for [month] in ([20190124], [20190224], [20190324], [20190424], [20190524], [20190624],
                 [20190724], [20190824], [20190924], [20191024], [20191124], [20191224])
 )as pvt;