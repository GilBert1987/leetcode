package com.gilbert;

public class DbLock {
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
    //

//    反查表
    // 微博社交系统
    // 数据库表
    // 用户基础信息表 按照userId 分库分表
    // 群信息表
    // 群ID 用户ID 群昵称 入群时间

    // 好友表 userId 分表 主要字段
    // id userId friendId isEnable createTime type
    // 建立 userId createTime isEnable 的联合索引
    // 用户ID 群ID
    // 建立 userId friend的联合唯一索引
    // select friendId from friend_table_xx where userId = #{userId} and isEnable = true orderby createTime limit 0,10;
    // 热门人的缓存
    // zset 时间排序 score 是时间 好友 多个 数量很大的话，分布在多台机器上
    // 帖子信息 hset key 文章ID 内容 关联帖子ID 时间 点赞人数.. 发布时间
    // 多级缓存
    // 流量判断 EWMA 加权平均 提升到内存
    // 数据分片 压缩 加密
    // Redis 数据迁移 mi


    // 秒杀
    // 库存 限购 Redis 异常处理 写数据库

    // MQ机制 KAFUKA的机制

    // 大V
    // 缓存一致性  缓存的热点 Key
    // 缓存雪崩 击穿
    // 发号器

    // 线上问题排查
//    1、根据服务名查询出服务的进程ID，例如：ps -ef|grep zhibo-kefu-service
//2、根据进程ID查询出该进程下的所有的线程信息
//
//    ps -mp 31989 -o THREAD,tid,time  使用该命令查看
//    3、根据tid计算出十六进制的值
//
//4、使用jstack根据服务的进程ID和线程的TID的十六进制的值抓取该进程的堆栈信息，nid对应的值就是tid的十六进制的值。根据堆栈信息就可以找到是哪个类的哪个方法导致的cpu占用高。

    // CPU
    // 内存
    // dump 文件
    // JVM 参数

//    用 kafka 做了什么功能？
//    kafka 内部原理？工作流程？
//    Kafka 怎么保证数据可靠性？
//    怎么实现 Exactly-Once？

//    讲一下熔断概念？熔断原理？令牌桶？熔断三个状态关系？
}
