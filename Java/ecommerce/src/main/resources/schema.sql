create table if not exists product(

    id int auto_increment primary key,
    name varchar(50) not null,
    price numeric(20,2) not null

);