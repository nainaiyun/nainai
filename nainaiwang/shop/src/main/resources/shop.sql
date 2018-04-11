use nn;

create table if not exists `shop_info` (
  `id` varchar(64)  not null comment  '店铺编号',
  `user_id` int(11) not null unique comment '用户编号',
  `logo` varchar(255) default '' comment '店铺标识',
  `name` varchar(100) not null comment '店铺名称',
  `synopsis` varchar(255) not null comment '店铺简介',
  `main_project` varchar(255) not null comment '主营项目',
  `main_supplies` varchar(255) default '' comment '主要货源',
  `introduce` varchar(1000)  comment '店铺介绍',
  `authentication`int(2) default 1 comment '是否认证',
  `operating_address` varchar(255) not null comment '经营地址',
  `contact_address` varchar(255) not null comment '联系地址',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255)default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺表';

create table if not exists `shop_suthentication` (
  `id` varchar(64)  not null comment '认证编号',
  `shop_id` varchar(64) not null unique comment '店铺编号',
  `user_name` varchar(32) not null comment '用户姓名',
  `mobile_phone` varchar(32) not null comment '手机号码',
  `email` varchar(32) not null comment '邮箱',
  `id_no` varchar(32) not null  comment '身份证号码',
  `qq_no` varchar(32) default '' comment 'QQ号码',
  `positive_id` varchar(255) not null comment '身份证正面',
  `back_id` varchar(255) not null comment '身份证反面',
  `business_license` varchar(255)  not null comment '营业执照',
  `enclosure` varchar(255) default '' comment '其他附件',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default ''  comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺认证信息';


create table if not exists `shop_style` (
  `id` varchar(64)  not null comment '风格编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(32) not null comment '名称',
  `picture` varchar(225) default '' comment '图片',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺装修风格表';


create table if not exists `shop_carousel` (
  `id` varchar(64)  not null comment '轮播图编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `products_id` varchar(64) not null comment '商品编号',
  `offer_id` varchar(64) not null comment '报盘编号',
  `name` varchar(32) default null comment '轮播图名称',
  `picture` varchar(225) default '' comment '图片',
  `picture_path` varchar(225) not null comment '图片路径',
  `link_address` varchar(225) default '' comment '链接地址',
  `is_link` int(2) default 1 comment '是否链接',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺轮播图表';

create table if not exists `shop_navigation` (
  `id` varchar(64)  not null comment '编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `parent_id` varchar(255) default '' comment '父级编号',
  `all_products` varchar(255) default '' comment '所有父级编号',
  `is_products` int(2) default  0 comment '是否父节点',
  `name` varchar(64) not null comment '名称',
  `link_address` varchar(225) default '' comment '链接地址',
  `is_link` int(2) default 1 comment '是否链接',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='导航栏表';

create table if not exists `shop_classify` (
  `id` varchar(64)  not null comment '分类编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(32) not null comment '分类名称',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='商品分类表';

create table if not exists `shop_module` (
  `id` varchar(64)  not null comment '模块编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(64) not null comment '模块名称',
  `picture_path` varchar(225) default '' comment '图片',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='商品模块表';


create table if not exists `shop_service` (
  `id` varchar(64)  not null comment '客服编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `nickname` varchar(64) not null comment '昵称',
  `name` varchar(64) not null comment '姓名',
  `picture_path` varchar(225) default ''  comment '头像',
  `office_phone` varchar(32) default ''  comment '办公电话',
  `mobile_phone` varchar(32) default ''  comment '联系电话',
  `qq_no` varchar(32) default ''  comment 'QQ号码',
  `email` varchar(32) default ''  comment '邮箱',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default ''  comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺客服信息表';


create table if not exists `shop_news` (
  `id` varchar(64)  not null comment '资讯编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(64) not null comment '资讯名称',
  `content` text  comment '资讯内容',
  `picture_path` varchar(225) default '' comment '资讯图片',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1  comment '排序',
  `remarks` varchar(255) default ''  comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺资讯信息表';


create table if not exists `shop_notice` (
  `id` varchar(64)  not null comment '公告编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(64) not null comment '公告名称',
  `content` text  comment '公告内容',
  `head_portrait` varchar(225) default '' comment '公告图片',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1  comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺公告信息表';


create table if not exists `shop_browse` (
  `id` varchar(64)  not null comment '浏览量编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `name` varchar(32) not null comment '名称',
  `total_browsing` int(11) default 0 comment '总浏览量',
  `monthly_browsing` int(11) default 0 comment '本月浏览量',
  `remarks` varchar(255) default ''  comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='浏览量表';

create table if not exists `shop_spread` (
  `id` varchar(64)  not null comment '推广编号',
  `shop_id` varchar(64) not null comment '店铺编号',
  `products_id` varchar(64) not null comment '商品编号',
  `offer_id` varchar(64) not null comment '报盘编号',
  `name` varchar(32) not null comment '推广名称',
  `picture` varchar(225) default '' comment '图片',
  `picture_path` varchar(225) default '' comment '图片路径',
  `link_address` varchar(225) default '' comment '链接地址',
  `is_link` int(2) default 1 comment '是否链接',
  `is_show` int(2) default 1 comment '是否显示',
  `sort` int(11) default 1 comment '排序',
  `remarks` varchar(255) default '' comment '备注',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 collate=utf8mb4_unicode_ci comment='店铺推广表';


ALTER TABLE `nn`.`shop_news`
  CHANGE COLUMN `content` `content` LONGTEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL COMMENT '资讯内容' ;

ALTER TABLE `nn`.`shop_notice`
  CHANGE COLUMN `content` `content` LONGTEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL COMMENT '公告内容' ;


ALTER TABLE `nn`.`shop_spread`
  CHANGE COLUMN `products_id` `products_id` int(11) NOT NULL COMMENT '商品编号' ,
  CHANGE COLUMN `offer_id` `offer_id` int(11) NOT NULL COMMENT '报盘编号' ;


ALTER TABLE `nn`.`shop_carousel`
  CHANGE COLUMN `products_id` `products_id` int(11) NOT NULL COMMENT '商品编号' ,
  CHANGE COLUMN `offer_id` `offer_id` int(11) NOT NULL COMMENT '报盘编号' ;



delete from shop_carousel;
delete from shop_browse;
delete from shop_classify;
delete from shop_info;
delete from shop_module;
delete from shop_navigation;
delete from shop_news;
delete from shop_notice;
delete from shop_service;
delete from shop_spread;
delete from shop_style;
delete from shop_suthentication;
update user set shop_id='' where username='';

