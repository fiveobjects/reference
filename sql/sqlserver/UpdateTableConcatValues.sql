create table customer
(
    firstname varchar(30),
    lastname varchar(30),
    fullname varchar(100)
);
insert into customer
values('e', 'f', 'efg');

insert into customer
    (firstname, lastname)
values('a', 'b');

insert into customer
values('c', 'd', null);

update customer set fullname=concat(firstname, ' ', lastname) where fullname is  null;
select *
from customer;