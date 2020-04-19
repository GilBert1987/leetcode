// 数据库 加锁分析 RR 级别 RC 级别
// MYSQL RR 级别和RC 级别的区别
//
set session autocommit=0;
show session variables like 'autocommit';

-- 将监控输出到log_error输出中，15秒刷新一次
set global innodb_status_output=ON;
-- 输出的内容包含锁的详细信息
set global innodb_status_output_locks=ON;

-- // innodb_locks记录了所有innodb正在等待的锁，和被等待的锁
select * from information_schema.innodb_locks;
-- // innodb_lock_waits记录了所有innodb锁的持有和等待关系
select * from information_schema.innodb_lock_waits





CREATE TABLE `t_test` (
            `id` int(10) PRIMARY KEY AUTO_INCREMENT COMMENT '自增ID',
            `a` int(4) NOT NULL COMMENT 'a',
            `b` int(4) NOT NULL COMMENT 'b',
            `c` int(4) NOT NULL COMMENT 'c'
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert values(null, 1, 1, 1)
insert values(null, 2, 2, 2)
insert values(null, 3, 3, 3)
insert values(null, 4, 4, 4)

// TX-1
begin;
update a = a + 1 where b =4;
commit;

// Tx-2
begin;
insert values(null, 5, 5, 5)
commit;

-- 2PL 读取每一条记录 加锁 更新 解锁

-- RR + 无索引 级别是否可以插入成功
--否 锁 锁表， 全表扫描 主键行锁 + GAP 锁
-- RC + 无索引 级别是否可以插入成功
-- 可以插入成功只是对b 这一行的主键索引加锁


-- 事务一会锁表 --行锁


-- id，a，b
-- 1，1，1
-- 2，2，2
-- 4，4，4
// id 主键索引
--
-- Tx-A
-- update t set a=a+1 where b=4;
-- b+普通索引
--
-- Tx-B
-- insert(3,3,3)
-- insert(5,5,4)
-- -------------------------
--
-- type: index, ref, range
-- extra: using index, using where 区别
// index
-- const: 针对主键或唯一索引的等值查询扫描, 最多只返回一行数据
-- eq_ref: 此类型通常出现在多表的 join 查询, 表示对于前表的每一个结果, 都只能匹配到后表的一行结果.
-- ref: 此类型通常出现在多表的 join 查询, 针对于非唯一或非主键索引, 或者是使用了 最左前缀 规则索引的查询.
-- range: 表示使用索引范围查询, 通过索引字段范围获取表中部分数据记录. 这个类型通常出现在 =, <>, >, >=, <, <=, IS NULL, <=>, BETWEEN, IN() 操作中.
-- index: 表示全索引扫描(full index scan), 和 ALL 类型类似, 只不过 ALL 类型是全表扫描, 而 index 类型则仅仅扫描所有的索引, 而不扫描数据.

-- ALL: 表示全表扫描, 这个类型的查询是性能最差的查询之一. 通常来说, 我们的查询不应该出现 ALL 类型的查询, 因为这样的查询在数据量大的情况下, 对数据库的性能是巨大的灾难. 如一个查询是 ALL 类型查询, 那么一般来说可以对相应的字段添加索引来避免.

-- Using index：从只使用索引树中的信息而不需要进一步搜索读取实际的行来检索表中的列信息。

--
-- （a, b, c, d）联合索引
--
-- where a=1 and c>3 and b=2 and d=4; abc range

-- where a=1 order by b desc, c;
// a b using file sort 默认是

