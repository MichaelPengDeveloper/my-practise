## my-practise自己平时练习的各种代码，会提交到这个仓库中。并且也会记录一些在平时学习遇到的问题和知识点
### 读《Java核心技术》知识点总结
    * Java基本数据类型 char一种用于表示Unicode编码的字符单元的字符类型。<br>
    * Sting、StringBuilder、StringBuffer三者的不同：StringBuilder速度最快，String最慢，之所以StringBuilder快是因为不用每次新建String对象。 <br>StringBuffer是线程安全的，StringBuilder是非线程安全的。<br>
    * 数组是一种数据结构，用来存储同一类型值的集合。<br>
    * Arrays.sort()该方法在jdk1.7之前和jdk1.7实现有所不同，1.7对其优化了。该方法底层是调用了DualPivotQuicksort.sort()方法。<br>
      * 代码块{}、静态块static{}、构造器三个最先加载的是静态块其实是代码块，最后是构造器。
### 平时积累的知识点
      * 覆盖索引：如果一个索引，（如：组合索引）中包含所有要查询字段的值，那么就称之为覆盖索引。<br>
      * 一个介绍Mysql索引比较好的博客，记录下来:http://blog.csdn.net/garfielder007/article/details/54295577。<br>
      * Mysql 'explain'显示了MySQL如何使用索引来处理select语句以及连接表。可以帮助选择更好的索引和写出更优化的查询语句。
      * transient关键字是用来禁止该变量进行序列化的<br>
      * 记录一个小的Mysql知识点union all 关键字可以将两个表合成一个表
      * @SuppressWarnings该注解是jdk提供的，意思是被批注的代码元素内部的某些警告保持静默。 
      * 记录jdk1.8时间操作新的API--LocalDate(表示没有时区的日期, LocalDate是不可变并且线程安全的)、LocalTime（表示没有时区的时间, LocalTime是不可变并且线程安全的）、LocalDateTime（表示没有时区的日期时间, LocalDateTime是不可变并且线程安全的）<br>
      Clock( 用于访问当前时刻、日期、时间，用到时区)、Duration（用秒和纳秒表示时间的数量）<br>
      * [读ArrayList源码] 看到grow(int minCapacity)扩容ArrayList大小的算法，读了好大一会儿才看明白，不明白为什么jdk一直想用minCapacity这个参数来进行扩容的大小，看到注释才明白，<br>这个参数通常接近ArrayList的大小。<br>
      * [读ArrayList源码] 发现底层经常调用Array.copy和System.arraycopy这两个方法,有时间读一下
      * [读ArrayList源码] 发现一个jdk1.7更新的类--Objects。jdk api解释：这个类包含用于操作对象的静态实用方法。这些实用工具包括用于计算对象哈希代码、返回对象的字符串以及比较两个对象的null安全或零容忍方法。学习一波<br>
      * [读ArrayList源码] 了解到ArrayList底层是用了快速失败机制，意指是在ArrryList父类AbstractArrayList中有个modCount，当两个线程同时操作一个ArrayList对象的时候会拿内部类Itr中的expectedModCount做对比，在遍历该对象的<br>
      会调用checkForComodification()该方法，如果两个值不相等就会报出ConcurrentModificationException异常，在ArrayList中像add(),remove(),clear()等都会对modCount进行重新赋值，以此实现了快速失败机制。一个可以解决快速失败<br>
      机制的方法是用和ArrayList数据结构一样的类并发包下的CopyOnWriteArrayList类。该类是基于安全失败机制。<br>
      * [读ArrayList源码]  了解到ArrayList类有个内部Itr类该类实现Itertor接口，了解到Iterator中定义了四个方法，分别是hashNext、next、remove、forEachRemaining（1.8之后加上的函数式接口）<br>
      机制的方法是用和ArrayList数据结构一样的类并发包下的CopyOnWriteArrayList类。该类是基于安全失败机制。
      * [读ArrayList源码] ArrayList类有几个内部类Itr私有类实现了Itreator接口、ListItr私有类实现了ListIterator接口继承了Itr、SubList私有类继承了AbstractList实现了RandomAccess接口、ArrayListSpliterator静态final类实现了<br>
      Spliterator接口。
      * 日常工作，看到同事写的代码，发现在秒杀商品兑换的时候可以使用redis进行加锁来避免超兑并发的问题。
      * DAU（Daily Actice User 日活跃用户量）
      * 可以使用JSR 303 - Bean Validation对数据进行校验
      * 三款主流的Java虚拟机：HotSpot VM、J9 VM、Zing VM https://www.zhihu.com/question/29265430?sort=created
      * TPS 系统吐吞量及事物处理数
      * PV 即界面浏览量
      * 原子性：如果把一个事务可看作是一个程序,它要么完整的被执行,要么完全不执行。这种特性就叫原子性。也就是指事务的一个完整性操作。
      * redis错误记录：stop-writes-on-bgsave-error 在默认情况下，如果RDB快照持久化操作被激活（至少一个条件被激活）并且持久化操作失败，Redis则会停止接受更新操作
      * （2017年 3月29号）在读代码的时候 遇到一个Java修饰关键字（Volatile）记录下来，百度了一下，贴上链接http://www.cnblogs.com/zhengbin/p/5654805.html#_label1
      * git cherry-pick 可以选择某一个分支中的一个或几个commit(s)来进行操作。
      * git reflog 可以查看所有分支的所有操作记录
      * git reset --hard 撤销所有未提交的
      * git push -f origin master 强制push 慎用！
      * Mybatis 中Example Criteria有个andCondition()方法可以根据自己的需求写特定的sql。
### 学习MessageQueue记录
    * 消息总线（MessageQueue），是一种跨进程的通信机制，用于上下游传递消息，在互联网架构中,MQ是一种常见的上下游“逻辑解耦+物理解耦”的消息通信服务。调用方实时依赖执行结果的业务场景，请使用实时调用，而不是MQ<br>         
      * 适用MQ的场景：数据驱动的任务依赖、上游不关心多下游执行结果、异步返回执行时间长。--削峰填谷，异步解耦。
 

 
 
