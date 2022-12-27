INSERT INTO pet_sitters (id, username, surname, city, email, pesel, postcode,
                         street, street_number, user_description, home_description)
VALUES (1, 'Nik', 'Kuhta', 'Warszawa', 'nikita@nikita.pl', 123456789101,
        03357, 'Kotsisa', 2, 'blablabla', 'blablabla');
INSERT INTO pet_sitters (id, username, surname, city, email, pesel, postcode,
                         street, street_number, user_description, home_description)
VALUES (2, 'Ola', 'Sabajska', 'Krakow', 'ola@nikita.pl', 123456789101,
        03877, 'Kotsisa', 4, 'blablabla', 'blablabla');

-- INSERT INTO services (id, category_id, name)
-- VALUES (1,1, 'Spacer');
--
-- INSERT INTO services (id, category_id, name)
-- VALUES (2,1, 'Nocleg');
--
-- INSERT INTO services_pet_sitters (pet_sitter_id, service_id)
-- VALUES (1,1);
--
-- INSERT INTO services_pet_sitters (pet_sitter_id, service_id)
-- VALUES (2,2);

INSERT INTO pet_owners (id, username, surname, city, email, pesel, postcode,
                        street, street_number, user_description, home_description, pet_description)
VALUES (1, 'Nik', 'Kuhta', 'Warszawa', 'nikita@nikita.pl', '1234567891',
        '03323', 'Kotsisa', 4, 'blablaa;okf;slkf;lskad;lkabla', 'blablabla;lskd;aks;ldaa', 'ajkshdjkasd;jaskldjaldka');
