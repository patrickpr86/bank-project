create table address (id int8 generated by default as identity, city varchar(255), complement varchar(255), district varchar(255), state varchar(255), street varchar(255), zipcode varchar(255), customer_id int8, primary key (id));
create table customer (id int8 generated by default as identity, birthdate timestamp, cpf varchar(255), email varchar(255), lastname varchar(255), name varchar(255), primary key (id));
alter table if exists address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer;
create table address (id int8 generated by default as identity, city varchar(255), complement varchar(255), district varchar(255), state varchar(255), street varchar(255), zipcode varchar(255), customer_id int8, primary key (id));
create table customer (id int8 generated by default as identity, birthdate timestamp, cpf varchar(255), email varchar(255), lastname varchar(255), name varchar(255), primary key (id));
alter table if exists address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer;
