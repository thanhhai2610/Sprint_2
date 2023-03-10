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

create table watch (
	id int primary key auto_increment,
    `name` varchar(360),
    face_diameter varchar(90),
	waterproof varchar(90),
    face_material varchar (90),
    strap_size varchar(90),
    wire_material varchar(90),
    shell_material varchar(90),
    designs varchar(90),
	warranty varchar(90),
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

create table img_url_product(
	id int primary key auto_increment,
    url varchar(360),
    watch_id int,
    delete_status int,
    foreign key (watch_id) references watch(id)
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
    watch_id int,
    product_order_id int,
    delete_status int,
    foreign key (watch_id) references watch(id),
    foreign key (product_order_id) references product_order(id)
);

INSERT INTO `watches_store`.`account` (`id`, `username`, `password`, `delete_status`, `status_lock`) VALUES ('1', 'haint', '123', '0', '0');
INSERT INTO `watches_store`.`account` (`id`, `username`, `password`, `delete_status`, `status_lock`) VALUES ('2', 'sonpt', '123', '0', '0');
INSERT INTO `watches_store`.`account` (`id`, `username`, `password`, `delete_status`, `status_lock`) VALUES ('3', 'quangnn', '123', '0', '0');
INSERT INTO `watches_store`.`account` (`id`, `username`, `password`, `delete_status`, `status_lock`) VALUES ('4', 'giangn', '123', '0', '0');


INSERT INTO `watches_store`.`role` (`id`) VALUES ('1');
INSERT INTO `watches_store`.`role` (`id`) VALUES ('2');

INSERT INTO `watches_store`.`account_role` (`account_id`, `role_id`, `delete_status`) VALUES ('1', '1', '0');
INSERT INTO `watches_store`.`account_role` (`account_id`, `role_id`, `delete_status`) VALUES ('2', '2', '0');
INSERT INTO `watches_store`.`account_role` (`account_id`, `role_id`, `delete_status`) VALUES ('3', '2', '0');


INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('1', 'Automatic', '0');
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('2', 'Quartz (??i???n t???)', '0');
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('3', 'Quartz/Pin', '0');
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('4', 'Quatz ( M??y pin )', '0');

INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('1', 'Patek Philippe', 'Th???y S?? ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('2', 'Rolex', 'Anh ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('3', 'Omega', 'Th???y S??', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('4', 'Longines', 'Th???y S??', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('5', 'Calvin Klein', 'M???', '0');

INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('1', '?????ng H??? 1', '28mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam ', 'B???o h??nh qu???c t??? 10 n??m', '2022-12-12', 'ch??a c?? ', '22222', '26', '1', '1', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('2', '?????ng H??? 2', '32mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Da', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? N???', 'B???o h??nh qu???c t??? 10 n??m ??', '2022-11-11', 'ch??a c??', '33333', '26', '2', '2', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('3', '?????ng H??? 3', '40mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam', 'B???o h??nh qu???c t??? 10 n??m', '2022-01-01', 'ch??a c??', '44444', '26', '3', '3', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('4', '?????ng H??? 4', '42mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam', 'B???o h??nh 10 n??m', '2022-09-09', 'ch??a c??', '55555', '26', '4', '4', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('5', '?????ng H??? 5', '28mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam ', 'B???o h??nh qu???c t??? 10 n??m', '2022-12-12', 'ch??a c?? ', '22222', '26', '1', '1', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('6', '?????ng H??? 6', '32mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Da', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? N???', 'B???o h??nh qu???c t??? 10 n??m ??', '2022-11-11', 'ch??a c??', '33333', '26', '2', '2', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('7', '?????ng H??? 7', '40mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam', 'B???o h??nh qu???c t??? 10 n??m', '2022-01-01', 'ch??a c??', '44444', '26', '3', '3', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('8', '?????ng H??? 8', '42mm', '5 ATM', 'Sapphire', '21 mm', 'D??y Silocon', 'H???p kim , ????nh ???? swarovsky', '?????ng H??? Nam', 'B???o h??nh 10 n??m', '2022-09-09', 'ch??a c??', '55555', '26', '4', '4', '0');

INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('1', 'https://www.dangquangwatch.vn/upload/img_big/475468133_dmdweb5.jpg', '1', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('2', 'https://www.dangquangwatch.vn/upload/product/1938900257_Dong-ho-Diamond-D-DM3638L5IG-B.jpg', '2', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('3', 'https://www.dangquangwatch.vn/upload/product/1208396326_donghonuthuysy65.jpg', '3', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('4', 'https://www.dangquangwatch.vn/upload/img_big/947483881_D%E1%BB%92NG-H%E1%BB%92-CH%C3%8DNH-H%C3%83NG-6.jpg', '4', '0');

INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('1', 'Ch??a c??', 'N???i Dung ', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('2', 'Ch??a c?? ', 'N???i Dung ', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('3', 'Ch??a c?? ', 'N???i Dung', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('4', 'Ch??a c?? ', 'N???i Dung', '0');

INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('1', 'Ch??a C?? ', '1', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('2', 'Ch??a c??', '2', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('3', 'Ch??a c??', '3', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('4', 'Ch??a c??', '4', '0');

INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('1', 'Kim C????ng ', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('2', 'B???ch Kim ', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('3', 'V??ng', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('4', 'B???c', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('5', '????ng', '0');

INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('1', 'Vi???t Nam', 'Qu???ng Nam', 'Duy Xuy??n', 'Duy Trung ', 'chi ti???t 1', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('2', 'Vi???t Nam', '???? N???ng', 'HUy???n 1', 'X?? 1', 'chi ti???t 2', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('3', 'Vi???t Nam', 'Qu??ng Ng??i', '.Huy???n 2', 'X?? 2', 'chie ti???t3', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('4', 'Vi???t Nam', 'B??nh ?????nh', 'Huy???n 3', 'X?? 3', 'chi ti???t4', '0');

INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('1', 'Ch??a C??', '1999-12-12', '1@gmail.com', 'Hai', 'Nguyen Thanh', '111111111', '0835262626', '1', '1', '1', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('2', 'Ch??a c?? ', '1999-10-10', '2@gmail.com', 'Son', 'Pham The', '222222222', '09364545454', '2', '2', '2', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('3', 'Ch??a c?? ', '1999-11-11', '3@gmail.com', 'Chau', 'Ph???m Thi', '333333333', '0921212122', '3', '3', '3', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('4', 'Ch??a c??', '1999-09-09', '4@gmail.com', 'Giang', 'Le B?? Ho??ng', '444444444', '0932323254', '4', '4', '4', '0');

INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('1', '1', '2022-01-01', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('2', '2', '2022-02-02', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('3', '3', '2022-03-03', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('4', '4', '2022-04-04', '0');

INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('1', '26', '1', '1', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('2', '26', '2', '2', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('3', '26', '3', '3', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('4', '26', '4', '4', '0');

