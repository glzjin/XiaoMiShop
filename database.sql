-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2018-08-04 01:11:33
-- 服务器版本： 5.7.18-log
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xiaomishop`
--

-- --------------------------------------------------------

--
-- 表的结构 `cart_infos`
--

CREATE TABLE `cart_infos` (
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_amount` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `cart_infos`
--

INSERT INTO `cart_infos` (`user_id`, `item_id`, `item_amount`) VALUES
(5, 1, 12),
(5, 2, 11);

-- --------------------------------------------------------

--
-- 表的结构 `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `item_name` varchar(32) NOT NULL,
  `item_price` decimal(64,2) NOT NULL,
  `item_sku` int(11) NOT NULL DEFAULT '0',
  `item_sold` int(11) NOT NULL DEFAULT '0',
  `item_description` longtext NOT NULL,
  `item_img_uri` text NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `item_category_id` int(11) NOT NULL,
  `is_hot` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `items`
--

INSERT INTO `items` (`id`, `item_name`, `item_price`, `item_sku`, `item_sold`, `item_description`, `item_img_uri`, `status`, `item_category_id`, `is_hot`) VALUES
(1, '小米手机1', '0.12', 105, 27, '好用好用哈哈哈', '/assets/public/images/weinituijian/1.jpg', 1, 3, 1),
(2, '小米手机2', '0.11', 91, 41, '好用好用哈哈哈', '/assets/public/images/weinituijian/2.jpg', 1, 3, 1),
(3, '小米空气净化器', '0.12', 113, 11, '我家在用', '/assets/public/images/zhuye/10.jpg', 1, 2, 1),
(4, '小米扫地机器人', '0.07', 122, 0, '我家在用', '/assets/public/images/zhuye/9.jpg', 1, 2, 1),
(21, '小米电视4A 49 寸', '0.11', 87, 13, '很大很大的电视', '/assets/public/images/zhuye/5.png', 1, 1, 1),
(22, '小米电视4 55英寸', '0.11', 120, 0, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/4.jpg', 1, 1, 0),
(23, '米家压力IH电饭煲', '0.09', 120, 0, '智能烹饪,灰铸铁粉体涂层内胆', '/assets/public/images/zhuye/8.jpg', 1, 1, 0),
(24, '小米电视4A 49英寸标准版', '0.07', 120, 0, '2GB+8GB 大储存/全高清HDR', '/assets/public/images/zhuye/4.jpg', 1, 1, 0),
(25, '米家扫地机器人', '0.12', 120, 0, '智能路径规划,扫得干净扫得快', '/assets/public/images/zhuye/9.jpg', 1, 2, 1),
(26, '13.3\"小米笔记本Air', '0.09', 116, 4, 'i5 8G 256G', '/assets/public/images/zhuye/6.jpg', 1, 4, 0),
(27, '小米米家空气净化器', '0.10', 120, 0, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/10.jpg', 1, 1, 1),
(28, '15.6\"小米笔记本Pro', '0.08', 120, 0, 'i7 16G MX1', '/assets/public/images/zhuye/7.jpg', 1, 4, 0),
(29, '小白摄像机', '0.09', 120, 0, '很好用的摄像机', '/assets/public/images/zhuye/11.jpg', 1, 2, 0),
(30, '米家 LED 智能台灯', '0.12', 120, 0, ' 盏灯。一本书。一支笔。一杯茶。一颗心。一个人。就差', '/assets/public/images/zhineng/1.jpg', 1, 2, 1),
(31, 'iHealth体温计', '0.11', 120, 0, '一秒速测LED 屏清晰读数', '/assets/public/images/zhineng/2.jpg', 1, 2, 1),
(32, '九号平衡车 Plus', '0.12', 120, 0, '35km超长续航，一键自动跟随', '/assets/public/images/zhuye/9.jpg', 1, 2, 0),
(33, '米家行车记录仪', '0.10', 120, 0, '晚上能拍清车牌的行车记录仪', '/assets/public/images/zhineng/4.jpg', 1, 2, 0),
(34, '红米5 Plus', '0.07', 119, 1, ' 全网通版 3GB内存', '/assets/public/images/weinituijian/2.jpg', 1, 3, 0),
(35, '红米Note 5A', '0.10', 109, 11, '全网通版 3GB内存', '/assets/public/images/weinituijian/1.jpg', 1, 3, 0),
(36, '小米6', '0.12', 119, 1, '全网通版 6GB内存', '/assets/public/images/zhineng/4.jpg', 1, 3, 0),
(37, '小米电视4 55英寸', '0.09', 120, 0, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/4.jpg', 1, 1, 1),
(38, '米家压力IH电饭煲', '0.10', 120, 0, '智能烹饪,灰铸铁粉体涂层内胆', '/assets/public/images/zhuye/8.jpg', 1, 1, 0),
(39, '小米电视4A 49英寸标准版', '0.08', 120, 0, '2GB+8GB 大储存/全高清HDR', '/assets/public/images/zhuye/4.jpg', 1, 1, 0),
(40, '米家扫地机器人', '0.12', 120, 0, '智能路径规划,扫得干净扫得快', '/assets/public/images/zhuye/9.jpg', 1, 2, 0),
(41, '13.3\"小米笔记本Air', '0.11', 117, 3, 'i5 8G 256G', '/assets/public/images/zhuye/6.jpg', 1, 4, 0),
(42, '小米米家空气净化器', '0.07', 120, 0, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/10.jpg', 1, 1, 0),
(43, '15.6\"小米笔记本Pro', '0.09', 120, 0, 'i7 16G MX1', '/assets/public/images/zhuye/7.jpg', 1, 4, 0),
(44, '小白摄像机', '0.11', 119, 1, '很好用的摄像机', '/assets/public/images/zhuye/11.jpg', 1, 2, 1),
(45, '米家 LED 智能台灯', '0.08', 120, 0, ' 盏灯。一本书。一支笔。一杯茶。一颗心。一个人。就差', '/assets/public/images/zhineng/1.jpg', 1, 2, 0),
(46, 'iHealth体温计', '0.12', 120, 0, '一秒速测LED 屏清晰读数', '/assets/public/images/zhineng/2.jpg', 1, 2, 1),
(47, '九号平衡车 Plus', '0.11', 120, 0, '35km超长续航，一键自动跟随', '/assets/public/images/zhuye/9.jpg', 1, 2, 0),
(48, '米家行车记录仪', '0.09', 120, 0, '晚上能拍清车牌的行车记录仪', '/assets/public/images/zhineng/4.jpg', 1, 2, 0),
(49, '红米5 Plus', '0.10', 120, 0, ' 全网通版 3GB内存', '/assets/public/images/weinituijian/2.jpg', 1, 3, 0),
(50, '红米Note 5A', '0.07', 119, 1, '全网通版 3GB内存', '/assets/public/images/weinituijian/1.jpg', 1, 3, 1),
(51, '小米6', '0.08', 105, 15, '全网通版 6GB内存', '/assets/public/images/zhineng/4.jpg', 1, 3, 0),
(52, '小米电视4 55英寸', '0.09', 112, 8, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/4.jpg', 1, 1, 1),
(53, '米家压力IH电饭煲', '0.07', 120, 0, '智能烹饪,灰铸铁粉体涂层内胆', '/assets/public/images/zhuye/8.jpg', 1, 1, 0),
(54, '小米电视4A 49英寸标准版', '0.10', 120, 0, '2GB+8GB 大储存/全高清HDR', '/assets/public/images/zhuye/4.jpg', 1, 1, 1),
(55, '米家扫地机器人', '0.07', 120, 0, '智能路径规划,扫得干净扫得快', '/assets/public/images/zhuye/9.jpg', 1, 2, 0),
(56, '13.3\"小米笔记本Air', '0.11', 120, 0, 'i5 8G 256G', '/assets/public/images/zhuye/6.jpg', 1, 4, 0),
(57, '小米米家空气净化器', '0.08', 120, 0, '4.9mm 极超薄高端旗舰电视', '/assets/public/images/zhuye/10.jpg', 1, 1, 0),
(58, '15.6\"小米笔记本Pro', '0.09', 120, 0, 'i7 16G MX1', '/assets/public/images/zhuye/7.jpg', 1, 4, 0),
(59, '小白摄像机', '0.09', 120, 0, '很好用的摄像机', '/assets/public/images/zhuye/11.jpg', 1, 2, 0),
(60, '米家 LED 智能台灯', '0.08', 120, 0, ' 盏灯。一本书。一支笔。一杯茶。一颗心。一个人。就差', '/assets/public/images/zhineng/1.jpg', 1, 2, 0),
(61, 'iHealth体温计', '0.10', 120, 0, '一秒速测LED 屏清晰读数', '/assets/public/images/zhineng/2.jpg', 1, 2, 0),
(62, '九号平衡车 Plus', '0.08', 120, 0, '35km超长续航，一键自动跟随', '/assets/public/images/zhuye/9.jpg', 1, 2, 0),
(63, '米家行车记录仪', '0.09', 120, 0, '晚上能拍清车牌的行车记录仪', '/assets/public/images/zhineng/4.jpg', 1, 2, 0),
(64, '红米5 Plus', '0.07', 120, 0, ' 全网通版 3GB内存', '/assets/public/images/weinituijian/2.jpg', 1, 3, 0),
(65, '红米Note 5A', '0.09', 120, 0, '全网通版 3GB内存', '/assets/public/images/weinituijian/1.jpg', 1, 3, 0),
(66, '小米6', '0.12', 120, 0, '全网通版 6GB内存', '/assets/public/images/zhineng/4.jpg', 1, 3, 0);

-- --------------------------------------------------------

--
-- 表的结构 `item_categories`
--

CREATE TABLE `item_categories` (
  `id` int(11) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `sort` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `item_categories`
--

INSERT INTO `item_categories` (`id`, `category_name`, `sort`) VALUES
(1, '家电', 2),
(2, '智能', 1),
(3, '手机', 0),
(4, '笔记本', 0);

-- --------------------------------------------------------

--
-- 表的结构 `item_ranks`
--

CREATE TABLE `item_ranks` (
  `item_id` int(11) NOT NULL,
  `rank_score` tinyint(4) NOT NULL,
  `rank_detail` longtext,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `deliver_company` varchar(32) DEFAULT NULL,
  `deliver_order_id` varchar(32) DEFAULT NULL,
  `price` decimal(64,2) NOT NULL,
  `user_real_name` varchar(10) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `datetime`, `status`, `deliver_company`, `deliver_order_id`, `price`, `user_real_name`, `user_phone`, `user_address`) VALUES
(1, 7, '2018-08-04 09:18:25', 1, NULL, NULL, '0.87', '吴亦凡', '13800138000', '北京联合大学'),
(2, 7, '2018-08-04 09:28:01', 1, NULL, NULL, '0.12', 'test', '13900139000', '啊飒飒啊');

-- --------------------------------------------------------

--
-- 表的结构 `order_items`
--

CREATE TABLE `order_items` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_current_price` decimal(6,2) NOT NULL,
  `item_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `order_items`
--

INSERT INTO `order_items` (`order_id`, `item_id`, `item_current_price`, `item_amount`) VALUES
(1, 3, '0.12', 2),
(1, 35, '0.10', 3),
(1, 41, '0.11', 3),
(2, 1, '0.12', 1);

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `user_role_type` tinyint(4) NOT NULL,
  `is_email_auth` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `email`, `username`, `password`, `user_role_type`, `is_email_auth`) VALUES
(1, 'glzjin@zhaojin97.cn', 'glzjin', 'e10adc3949ba59abbe56e057f20f883e', 2, 1),
(2, 'dlc0313@163.com', 'dlc0313', '1fe4c05046c338ce25d52037c1475318', 2, 1),
(3, '3054879403@qq.com', '3054879403', 'e10adc3949ba59abbe56e057f20f883e', 2, 1),
(4, '123@xmstore.com', '123', 'e10adc3949ba59abbe56e057f20f883e', 2, 0),
(5, '1774824533@qq.com', '123456', 'e10adc3949ba59abbe56e057f20f883e', 2, 1),
(7, 'testmi@zhaoj.in', 'testmi', 'e10adc3949ba59abbe56e057f20f883e', 2, 1);

-- --------------------------------------------------------

--
-- 表的结构 `user_addresses`
--

CREATE TABLE `user_addresses` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_real_name` varchar(10) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user_addresses`
--

INSERT INTO `user_addresses` (`id`, `user_id`, `user_real_name`, `user_phone`, `user_address`) VALUES
(1, 1, 'test', '12346', 'aaaa'),
(16, 1, '测试添加', '13800138000', '中公教育'),
(19, 7, 'test', '13900139000', '啊飒飒啊');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_infos`
--
ALTER TABLE `cart_infos`
  ADD PRIMARY KEY (`user_id`,`item_id`),
  ADD UNIQUE KEY `cart_item_id_user_id` (`item_id`,`user_id`) USING BTREE;

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `items_category_id` (`item_category_id`);

--
-- Indexes for table `item_categories`
--
ALTER TABLE `item_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_ranks`
--
ALTER TABLE `item_ranks`
  ADD PRIMARY KEY (`item_id`,`order_id`),
  ADD UNIQUE KEY `UK_1hel8ky1pml5klbgqs8wjp9po` (`order_id`,`item_id`) USING BTREE;

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_user_id` (`user_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD KEY `order_item_item_id` (`item_id`),
  ADD KEY `order_item_order_id` (`order_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_addresses`
--
ALTER TABLE `user_addresses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address_user_id` (`user_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- 使用表AUTO_INCREMENT `item_categories`
--
ALTER TABLE `item_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 使用表AUTO_INCREMENT `user_addresses`
--
ALTER TABLE `user_addresses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- 限制导出的表
--

--
-- 限制表 `cart_infos`
--
ALTER TABLE `cart_infos`
  ADD CONSTRAINT `cart_item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cart_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_category_id` FOREIGN KEY (`item_category_id`) REFERENCES `item_categories` (`id`);

--
-- 限制表 `item_ranks`
--
ALTER TABLE `item_ranks`
  ADD CONSTRAINT `rank_item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `rank_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- 限制表 `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `order_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- 限制表 `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_item_item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `order_item_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- 限制表 `user_addresses`
--
ALTER TABLE `user_addresses`
  ADD CONSTRAINT `address_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
