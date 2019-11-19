CREATE TABLE IF NOT exists cart (id SERIAL primary key  not null,
title VARCHAR (128) not null, description varchar(255) not  null,
board_id serial not null, foreign key (board_id) references board(id))