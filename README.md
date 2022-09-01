# jpademo


# mysql 分区
   mysql分区相对于mysql分库分表便利很多,可以对现有的mysql大表添加分区,也可以对已有分区的表扩充分区


# 一、Mysql分区类型
1、RANGE 分区：基于属于一个给定连续区间的列值，把多行分配给分区。

2、HASH分区：基于用户定义的表达式的返回值来进行选择的分区，该表达式使用将要插入到表中的这些行的列值进行计算。这个函数可以包含MySQL中有效的、产生非负整数值的任何表达式。

3、KEY分区：类似于按HASH分区，区别在于KEY分区只支持计算一列或多列，且MySQL服务器提供其自身的哈希函数。必须有一列或多列包含整数值。

4、复合分区：基于RANGE/LIST 类型的分区表中每个分区的再次分割。子分区可以是 HASH/KEY 等类型。  



## 1.创建Range分区（主键）
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `event_time` bigint(20) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
PARTITION BY RANGE (id) PARTITIONS 3 (
PARTITION part0 VALUES LESS THAN (5), 
PARTITION part1 VALUES LESS THAN (10), 
PARTITION part1 VALUES LESS THAN (15), 
PARTITION part2 VALUES LESS THAN MAXVALUE);


## 插入数据测试
```
insert into `user`(`name`,email,event_time,update_time) values('lihm1','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm2','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm3','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm4','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm5','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm6','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
insert into `user`(`name`,email,event_time,update_time) values('lihm7','lihm1@qq.com',REPLACE(unix_timestamp(current_timestamp(3)),'.',''),now());
```

## 2.查看分区
SELECT
partition_name part,
partition_expression expr,
partition_description descr,
table_rows
FROM information_schema.partitions WHERE
table_schema = SCHEMA()
AND table_name='user';

## show create table user;
```
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `email` varchar(255) DEFAULT NULL,
  `event_time` bigint(20) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
/*!50100 PARTITION BY RANGE (id)
(PARTITION part0 VALUES LESS THAN (5) ENGINE = InnoDB,
 PARTITION part1 VALUES LESS THAN (10) ENGINE = InnoDB,
 PARTITION part2 VALUES LESS THAN (15) ENGINE = InnoDB,
 PARTITION partm VALUES LESS THAN MAXVALUE ENGINE = InnoDB) */;


/*!...*/ 是一种特殊的注释，其他的数据库产品当然不会执行。mysql特殊处理，会选择性的执行
。可以认为是：预编译中的条件编译。特别注意 50100，它表示5.01.00 版本或者更高的版本，才执行
```

。


## 3.查询分区，各区表数据量
```
SELECT TABLE_SCHEMA,TABLE_NAME,PARTITION_NAME,PARTITION_METHOD,TABLE_ROWS,TABLESPACE_NAME
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE  table_schema = SCHEMA() and TABLE_NAME = 'user';
select *  FROM information_schema.partitions where table_schema = SCHEMA();
desc information_schema.partitions;
```
