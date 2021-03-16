insert into air_company (name, type, founded)
values ('Air Company - 1', 'Company type', '2000-01-01'),
       ('Air Company - 2', 'Company type', '2000-01-01'),
       ('Air Company - 3', 'Company type', '2000-01-01'),
       ('Air Company - 4', 'Company type', '2000-01-01');

insert into air_plane (name, factory_serial_number, air_company_id, number_of_flights, flight_distance,
                       fuel_capacity, type, created_at)
values ('Air Plane - 1', 'Serial Number', 1, 10, 1000, 10000, 'Type', '2000-01-01'),
       ('Air Plane - 2', 'Serial Number', 1, 10, 1000, 10000, 'Type', '2000-01-01'),
       ('Air Plane - 3', 'Serial Number', 1, 10, 1000, 10000, 'Type', '2000-01-01'),
       ('Air Plane - 4', 'Serial Number', 2, 10, 1000, 10000, 'Type', '2000-01-01'),
       ('Air Plane - 5', 'Serial Number', 2, 10, 1000, 10000, 'Type', '2000-01-01'),
       ('Air Plane - 6', 'Serial Number', 3, 10, 1000, 10000, 'Type', '2000-01-01');

insert into flight (flight_status, air_company_id, airplane_id, departure_country, destination_country,
                    distance, estimated_flight_time, ended_at, delay_started_at, created_at)
values ('ACTIVE', 1, 1, 'Argentina', 'India', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('COMPLETED', 1, 1, 'Argentina', 'Italia', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('DELAYED', 1, 1, 'Argentina', 'America', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('PENDING', 1, 1, 'Argentina', 'Moldova', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),

       ('ACTIVE', 2, 2, 'Ukraine', 'Moldova', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('COMPLETED', 2, 2, 'Ukraine', 'India', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('DELAYED', 2, 2, 'Ukraine', 'Turkie', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),

       ('ACTIVE', 3, 3, 'Turkie', 'China', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01'),
       ('COMPLETED', 3, 3, 'Turkie', 'China', 1000, 11111, '2000-01-01', '2000-01-01', '2000-01-01');