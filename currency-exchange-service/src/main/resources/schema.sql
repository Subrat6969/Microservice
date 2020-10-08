create table Currency_Exchange
(
  id integer not null,
  Currency_From varchar(250) not null,
  Currency_to varchar(250),
  Multiply_Value integer,
  created timestamp,
  primary key(id)
);