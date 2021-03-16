create table air_company
(
  id      integer not null auto_increment,
  founded date,
  name    varchar(255),
  type    varchar(255),
  primary key (id)
);

create table air_plane
(
  id                    integer not null auto_increment,
  created_at            date,
  factory_serial_number varchar(255),
  flight_distance       integer,
  fuel_capacity         integer,
  name                  varchar(255),
  number_of_flights     integer,
  type                  varchar(255),
  air_company_id     integer,
  primary key (id)
);

create table flight
(
  id                    integer not null auto_increment,
  created_at            date,
  delay_started_at      date,
  departure_country     varchar(255),
  destination_country   varchar(255),
  distance              integer,
  ended_at              date,
  estimated_flight_time integer,
  flight_status         varchar(255),
  air_company_id     integer,
  airplane_id        integer,
  primary key (id)
);

alter table air_plane
  add constraint FKaf2vxkf05amn06hedcegu81sy foreign key (air_company_id) references air_company (id);

alter table flight
  add constraint FK2044j9vnal1opf3nll4ur6r41 foreign key (air_company_id) references air_company (id);

alter table flight
  add constraint FK43wer384fwaxtecj9opd8t6gb foreign key (airplane_id) references air_plane (id);