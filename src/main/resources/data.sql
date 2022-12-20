CREATE TABLE pet_sitters (
    id int not null primary key,
    username varchar not null,
    surname varchar not null,
    birthdate date,
    city varchar not null ,
    email varchar not null,
    pesel varchar not null,
    postcode varchar not null,
    street varchar not null,
    street_number int not null,
    user_description varchar not null,
    home_description varchar not null,
    pet_sitter_photo_id int not null,
    foreign key (pet_sitter_photo_id) references pet_sitter_photos(id)
);

CREATE TABLE pet_owners (
    id int not null primary key,
    username varchar not null,
    surname varchar not null,
    birthdate date,
    city varchar not null ,
    email varchar not null,
    pesel varchar not null,
    postcode varchar not null,
    street varchar not null,
    street_number int not null,
    user_description varchar not null,
    home_description varchar not null,
    pet_description varchar not null,
    pet_owner_photo_id int,
    foreign key (pet_owner_photo_id) references pet_owner_photos(id)
);

CREATE TABLE pet_owner_photos (
    id int not null primary key,
    path varchar(255) not null
);

CREATE TABLE pet_sitter_photos (
    id int not null primary key,
    path varchar(255) not null
);

CREATE TABLE services (
    id int not null primary key,
    name varchar not null,
    category_id int not null,
    foreign key (category_id) references categories(id),
    service_certificate_id int,
    foreign key (service_certificate_id) references service_certificates(id)
);

CREATE TABLE categories (
    id int not null primary key,
    name varchar not null
);

CREATE TABLE service_certificates (
    id int not null primary key,
    path varchar(255) not null
);

CREATE TABLE services_pet_sitters (
    pet_sitter_id int not null,
    foreign key (pet_sitter_id) references pet_sitters(id),
    service_id int not null,
    foreign key (service_id) references services(id)
);

CREATE TABLE order_requests (
    id int not null primary key,
    pet_owner_id int not null,
    foreign key (pet_owner_id) references pet_owners(id),
    pet_sitter_id INT NOT NULL,
    foreign key (pet_sitter_id) references pet_sitters(id),
    is_approved int(1) not null, -- 0 - nie, 1 - tak
    date date not null,
    days int not null,
    cost double not null,
    deal_type varchar not null --contract albo talk
);

CREATE TABLE orders (
    id int not null primary key,
    order_request_id int not null,
    foreign key (order_request_id) references order_requests(id),
    pet_owner_feedback varchar,
    pet_sitter_id_feedback varchar,
    payed int not null -- 0 - nie, 1 - tak
);