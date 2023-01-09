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
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('2', 'Quartz (Điện tử)', '0');
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('3', 'Quartz/Pin', '0');
INSERT INTO `watches_store`.`category` (`id`, `name`, `delete_status`) VALUES ('4', 'Quatz ( Máy pin )', '0');

INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('1', 'Patek Philippe', 'Thụy Sĩ ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('2', 'Rolex', 'Anh ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('3', 'Omega', 'Thụy Sĩ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('4', 'Longines', 'Thụy Sĩ', '0');
INSERT INTO `watches_store`.`brand` (`id`, `name`, `origin`, `delete_status`) VALUES ('5', 'Calvin Klein', 'Mỹ', '0');

INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('1', 'Đồng Hồ 1', '28mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam ', 'Bảo hành quốc tế 10 năm', '2022-12-12', 'chưa có ', '22222', '26', '1', '1', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('2', 'Đồng Hồ 2', '32mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Da', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nữ', 'Bảo hành quốc tế 10 năm ư', '2022-11-11', 'chưa có', '33333', '26', '2', '2', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('3', 'Đồng Hồ 3', '40mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam', 'Bảo hành quốc tế 10 năm', '2022-01-01', 'chưa có', '44444', '26', '3', '3', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('4', 'Đồng Hồ 4', '42mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam', 'Bảo hành 10 năm', '2022-09-09', 'chưa có', '55555', '26', '4', '4', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('5', 'Đồng Hồ 5', '28mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam ', 'Bảo hành quốc tế 10 năm', '2022-12-12', 'chưa có ', '22222', '26', '1', '1', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('6', 'Đồng Hồ 6', '32mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Da', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nữ', 'Bảo hành quốc tế 10 năm ư', '2022-11-11', 'chưa có', '33333', '26', '2', '2', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('7', 'Đồng Hồ 7', '40mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam', 'Bảo hành quốc tế 10 năm', '2022-01-01', 'chưa có', '44444', '26', '3', '3', '0');
INSERT INTO `watches_store`.`watch` (`id`, `name`, `face_diameter`, `waterproof`, `face_material`, `strap_size`, `wire_material`, `shell_material`, `designs`, `warranty`, `register_day`, `description`, `price`, `quantity`, `category_id`, `brand_id`, `delete_status`) VALUES ('8', 'Đồng Hồ 8', '42mm', '5 ATM', 'Sapphire', '21 mm', 'Dây Silocon', 'Hợp kim , đính đá swarovsky', 'Đồng Hồ Nam', 'Bảo hành 10 năm', '2022-09-09', 'chưa có', '55555', '26', '4', '4', '0');

INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('1', 'https://www.dangquangwatch.vn/upload/img_big/475468133_dmdweb5.jpg', '1', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('2', 'https://www.dangquangwatch.vn/upload/product/1938900257_Dong-ho-Diamond-D-DM3638L5IG-B.jpg', '2', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('3', 'https://www.dangquangwatch.vn/upload/product/1208396326_donghonuthuysy65.jpg', '3', '0');
INSERT INTO `watches_store`.`img_url_product` (`id`, `url`, `watch_id`, `delete_status`) VALUES ('4', 'https://www.dangquangwatch.vn/upload/img_big/947483881_D%E1%BB%92NG-H%E1%BB%92-CH%C3%8DNH-H%C3%83NG-6.jpg', '4', '0');

INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('1', 'Chưa có', 'Nội Dung ', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('2', 'Chưa có ', 'Nội Dung ', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('3', 'Chưa có ', 'Nội Dung', '0');
INSERT INTO `watches_store`.`guide` (`id`, `title`, `content`, `delete_status`) VALUES ('4', 'Chưa có ', 'Nội Dung', '0');

INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('1', 'Chưa Có ', '1', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('2', 'Chưa có', '2', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('3', 'Chưa có', '3', '0');
INSERT INTO `watches_store`.`img_url_guide` (`id`, `url`, `guide_id`, `delete_status`) VALUES ('4', 'Chưa có', '4', '0');

INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('1', 'Kim Cương ', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('2', 'Bạch Kim ', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('3', 'Vàng', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('4', 'Bạc', '0');
INSERT INTO `watches_store`.`user_type` (`id`, `name`, `delete_status`) VALUES ('5', 'Đông', '0');

INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('1', 'Việt Nam', 'Quảng Nam', 'Duy Xuyên', 'Duy Trung ', 'chi tiết 1', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('2', 'Việt Nam', 'Đà Nẵng', 'HUyện 1', 'Xã 1', 'chi tiết 2', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('3', 'Việt Nam', 'Quãng Ngãi', '.Huyện 2', 'Xã 2', 'chie tiết3', '0');
INSERT INTO `watches_store`.`address` (`id`, `country`, `city`, `district`, `town`, `detail_address`, `delete_status`) VALUES ('4', 'Việt Nam', 'BÌnh Định', 'Huyện 3', 'Xã 3', 'chi tiết4', '0');

INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('1', 'Chưa Có', '1999-12-12', '1@gmail.com', 'Hai', 'Nguyen Thanh', '111111111', '0835262626', '1', '1', '1', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('2', 'Chưa có ', '1999-10-10', '2@gmail.com', 'Son', 'Pham The', '222222222', '09364545454', '2', '2', '2', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('3', 'Chưa có ', '1999-11-11', '3@gmail.com', 'Chau', 'Phạm Thi', '333333333', '0921212122', '3', '3', '3', '0');
INSERT INTO `watches_store`.`user` (`id`, `avatar`, `birthday`, `email`, `firstname`, `lastname`, `id_card`, `phone`, `account_id`, `address_id`, `user_type_id`, `delete_status`) VALUES ('4', 'Chưa có', '1999-09-09', '4@gmail.com', 'Giang', 'Le Bá Hoàng', '444444444', '0932323254', '4', '4', '4', '0');

INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('1', '1', '2022-01-01', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('2', '2', '2022-02-02', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('3', '3', '2022-03-03', '0');
INSERT INTO `watches_store`.`product_order` (`id`, `user_id`, `order_date`, `delete_status`) VALUES ('4', '4', '2022-04-04', '0');

INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('1', '26', '1', '1', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('2', '26', '2', '2', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('3', '26', '3', '3', '0');
INSERT INTO `watches_store`.`product_order_detail` (`id`, `quantity`, `watch_id`, `product_order_id`, `delete_status`) VALUES ('4', '26', '4', '4', '0');

