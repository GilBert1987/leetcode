// 数据库 加锁分析 RR 级别 RC 级别
// MYSQL RR 级别和RC 级别的区别
//

-- InnoDB的MVCC是通过在每行记录后面保存两个隐藏的列来实现的。
-- 一个保存了行的事务ID（DB_TRX_ID），一个保存了行的回滚指针（DB_ROLL_PT）
-- 每开始一个新的事务，都会自动递增产 生一个新的事务id。事务开始时刻的会把事务id放到当前事务影响的行事务id中，
-- 当查询时需要用当前事务id和每行记录的事务id进行比较。
-- InnoDB只查找版本早于当前事务版本的数据行（也就是，行的事务编号小于或等于当前事务的事务编号），
-- 这样可以确保事务读取的行，要么是在事务开始前已经存在的，要么是事务自身插入或者修改过的。
-- MVCC只在REPEATABLE READ和READ COMMITIED两个隔离级别下工作


-- InnoDB中通过undo log实现了数据的多版本，而并发控制通过锁来实现。
-- undo log除了实现MVCC外，还用于事务的回滚。
-- binlog，是mysql服务层产生的日志，常用来进行数据恢复、数据库复制，
-- 常见的mysql主从架构，就是采用slave同步master的binlog实现的, 另外通过解析binlog能够实现mysql到其他数据源

--redo log记录了数据操作在物理层面的修改

-- InnoDB行记录中除了刚才提到的rowid外，还有trx_id和db_roll_ptr,
-- trx_id表示最近修改的事务的id,db_roll_ptr指向undo segment中的undo log。


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

-- INNER join // union 简单的sql的例子

b 没有索引
update table t set c=c+1 where b > 3;
-- b 没有索引 全表扫描，锁表
-- RR 级别 b 普通索引 锁住 b> 3的索引项目和Gap 锁 + 对应的主键索引 + Gap 锁
语句改成
update table t set c=c+1 where b > 3 and a > 6;
-- 其中a 唯一索引
-- 锁住a> 6 的所有索引项目 和Gap 锁

CREATE TABLE `t_test` (
            `id` int(10) PRIMARY KEY AUTO_INCREMENT COMMENT '自增ID',
            `a` int(4) NOT NULL COMMENT 'a',
            `b` int(4) NOT NULL COMMENT 'b',
            `c` int(4) NOT NULL COMMENT 'c'
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_test` (
            `id` int(10) PRIMARY KEY AUTO_INCREMENT COMMENT '自增ID',
            `a` int(4) NOT NULL COMMENT 'a',
            `b` int(4) NOT NULL COMMENT 'b',
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

    // 数据库乐观锁的实现


// 数据库的乐观锁保证库存的正确性
//    while(true) {
//        Result result = select * from table where id= #{id};
//        int ret = update table set amount = amount - 1, version = result.version + 1 where version = #result.version;
//        if(ret == 1) { // 更新成功
//            break;
//        }
//    }

    // 数据库的加锁的时机 当前读 加锁

--参考
-- https://zhuanlan.zhihu.com/p/66791480 一文理解Mysql MVCC
-- https://github.com/hedengcheng/tech/tree/master/database/MySQL

