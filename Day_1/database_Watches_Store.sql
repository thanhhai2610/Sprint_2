DROP DATABASE  IF EXISTS watches_store;
create database watches_store;
USE watches_store;
create table `account`(
	id int primary key auto_increment,
    username varchar(60),
    `password` varchar(60),
    delete_status int,
    status_lock int
);

create table `role`(
	id int primary key auto_increment,
    `name` varchar(30),
    delete_status int
);

create table account_role(
	account_id int,
    role_id int,
    foreign key (account_id) references account(id),
    foreign key (role_id) references role(id),
    primary key (account_id, role_id),
    delete_status int
);

create table category (
	id int primary key auto_increment,
    `name` varchar(90),
    delete_status int
);

create table brand(
	id int primary key auto_increment,
    `name` varchar(90),
    origin varchar(90),
    brand_img_url varchar (130),
    delete_status int
);

create table product(
	id int primary key auto_increment,
    register_day varchar(90),
    `description` longtext,
    price double,
    quantity int,
    category_id int,
    brand_id int,
    delete_status int,
    foreign key (category_id) references category(id),
    foreign key (brand_id) references brand(id)
);

create table watch (
	id int primary key auto_increment,
    `name` varchar(360),
    face_diameter varchar(90),
	waterproof varchar(90),
    face_material varchar (90),
    energy_used varchar(90),
    strap_size varchar(90),
    wire_material varchar(90),
    shell_material varchar(90),
    designs varchar(90),
    origin varchar(90),
	warranty varchar(90),
    product_id int,
    delete_status int,
    foreign key (product_id) references product(id)
);

create table img_url_product(
	id int primary key auto_increment,
    url varchar(360),
    product_id int,
    delete_status int,
    foreign key (product_id) references product(id)
);

create table guide(
	id int primary key auto_increment,
    title varchar(90),
    content longtext,
    delete_status int
);

create table img_url_guide(
	id int primary key auto_increment,
    url varchar(360),
    guide_id int,
    delete_status int,
    foreign key (guide_id) references guide(id)
);

create table user_type(
	id int primary key auto_increment,
    `name` varchar(130),
    delete_status int
);

create table address(
	id int primary key auto_increment,
    country varchar(90),
    city varchar(90),
    district varchar(90),
    town varchar(90),
    detail_address varchar(360),
    delete_status int
);

create table `user`(
	id int primary key auto_increment,
    avatar varchar(360),
    birthday varchar(90),
    email varchar(90),
    firstname varchar(90),
    lastname varchar(90),
    id_card varchar(90),
    phone varchar(90),
    account_id int,
    address_id int,
    user_type_id int,
    delete_status int,
    foreign key (account_id) references account(id),
    foreign key (address_id) references address(id),
    foreign key (user_type_id) references user_type(id)
);


create table product_order(
	id int primary key auto_increment,
    user_id int,
    order_date varchar(90),
    delete_status int,
    foreign key (user_id) references user(id)
);

create table product_order_detail(
	id int primary key auto_increment,
    quantity int,
    product_id int,
    product_order_id int,
    delete_status int,
    foreign key (product_id) references product(id),
    foreign key (product_order_id) references product_order(id)
);











