create table channel(
  channel_number int primary key,
  name text,
  price double precision,
  channel_group text
);

create sequence channel_number_seq cycle
  increment 1
  start 101
  minvalue 1
  maxvalue 9999999999;
   
insert into channel (channel_number, name, price, channel_group)
values (100, 'Star Movies', 10.00, 'Star');