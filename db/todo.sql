drop database if exists todo;
create database todo;

use todo;

create table todo(
num int primary key auto_increment,
date Date not null,
text varchar(100) not null,
`order` int not null
);
insert todo(date, text, `order`) 
select "2026-01-30", "등원", ifnull(max(`order`), 0) + 1 from todo
where date = "2026-01-30";
