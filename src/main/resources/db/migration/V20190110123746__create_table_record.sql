CREATE TABLE IF NOT exists record(id serial primary key not null, title varchar(128) not  null,
description varchar(255), comment varchar (255), deadline timestamp,
cart_id serial not null, foreign key (cart_id) references cart(id))