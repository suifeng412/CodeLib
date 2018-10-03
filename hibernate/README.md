# Hibernate 
是一个开放源码的ORM框架，对JDBC进行了轻量级的对象封装。  

优势：  
* 对JDBC访问数据库做了轻量级封装，大大简化了数据库访问层的繁琐的重复性代码，并减少内存消耗，加快了运行效率  
* 基于JDBC的主流持久化框架，简化了DAO（Data Access Object）层编码工作  
* 支持很多关系型数据库。从一对一到一对多的各种复杂关系  
* 可扩展性强  


##### 创建实体（持久化类）  
持久化类是应用程序中的业务实体类  
POJO类中包含与数据库表相对的各个属性，这些属性通过getter和setter方法来访问，对外部隐藏了内部实现细节  

##### 实现步骤  
* 建立实体类  
* 建立映射文件  
* 核心配置文件


##### 映射文件 
```
<hibernate-mapping package="hibernate">
// package 内部类所在的包名(可省略)

 <class name="User" table="tb_user">
 	// name:类名（无写包名，则需写全路径）
 	// table:表名
 	// catalog：数据库名称，可以省略
 	
 	
        <id name="id" column="id">
        // id标签:用来建立类中的属性与表中主键的对应

            <generator class="native"/>
            // generator:主键生成策略
            // class取值：
            1、native：自动增长，会根据当前的数据库自动切换
            2、identity：mySQL的自增策略
            3、sequence：Oracle的自增标记
            4、uuid:32位字符串
            5、assigned:自定义字符串
            6、foreign：外键
            7、increment：自己维护自增关系
          
        </id>
   		
        <!-- 复合主键映射 -->
        <!--
        <composite-id name="keys">
            <key-property name="userName" type="string"></key-property>
            <key-property name="address" type="string"></key-property>
        </composite-id>
        -->
        
        // 配置属性对应的字段
        <property name="name" length="16" column="username" type="string"/>
        <property name="pass" length="32"/>  

    </class>

</hibernate-mapping>
```
     

hibernate类型详解：
这里的type类型并不是java本身的类型，也不是sql里本身的类型，而是一个映射关系  
* integer ：	int 或 java.lang.Integer  =》	INTEGER  
* long ：	long 或 java.lang.Long  =》	BIGINT   
* short ：short 或 java.lang.Short  =》	SMALLINT  
* float ：	float 或 java.lang.Float  =》	FLOAT  
* double :	double 或 java.lang.Double  =》	DOUBLE  
* big_decimal ：	java.math.BigDecimal  =》	NUMERIC  
* character ：	java.lang.String  =》	CHAR(1)  
* string ：	java.lang.String  =》	VARCHAR  
* byte ：	byte 或 java.lang.Byte  =》	TINYINT  
* boolean ：	boolean 或 java.lang.Boolean  =》	BIT  
* yes/no ：	boolean 或 java.lang.Boolean	  =》 CHAR(1)('Y' or 'N')  
* true/false ：	boolean 或 java.lang.Boolean  =》	CHAR(1)('T' or 'F')  
* date ： java.util.Date 或 java.sql.Date =》	DATE  
* time ：	java.util.Date 或 java.sql.Time =》	TIME  
* timestamp ： 	java.util.Date 或 java.sql.Timestamp =》	TIMESTAMP  
* calendar  ：	java.util.Calendar =》	TIMESTAMP  
* calendar_date ：	java.util.Calendar =》	DATE  

##### 核心配置文件  
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    
    <session-factory>
        // 数据库驱动类全称
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        // 数据库URL地址
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_db?characterEncoding=UTF-8</property>
        // 用户名
        <property name="hibernate.connection.username">root</property>
        // 密码
        <property name="hibernate.connection.password"></property>
        // 方言 根据配置的方言生成相应的SQL语句
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
        
        // 全局配置信息
        <!--执行DDL的类别：
        create:每次都删除新建
        update:存在就修改，不存在就新建  -->
        <property name="hibernate.hbm2ddl.auto">update</property>
        // hibernate.hbm2ddl.auto 取值
        1、none:不用Hibernate自动生成表
        2、create:每次都会创建一个新表
        3、create-drop:每次都会创建一个新的表，执行程序结束后删除这个表
        4、update:数据库中没表则新建更新
        5、valudate:只会使用原来的表，对映射关系进行校验
        
        // 是否显示SQL语句
        <property name="hibernate.show_sql">true</property>
        // 是否格式化SQL语句
        <property name="hibernate.format_sql">true</property>
        <!-- 启用getCurrentSession，默认未启用 -->
        <property name="hibernate.current_session_context_class">thread</property>
        
        // 加载配置文件 (基于xml的映射文件)
        <mapping resource="User.hbm.xml"></mapping>
        
    </session-factory>
</hibernate-configuration>
```

##### Configuration 配置对象
Configuration主要用于Hibernate框架加载核心配置文件，启动、加载、管理Hibernate的配置文件信息  
步骤：Configuration确定配置文件位置，读取相关配置，最后创建一个SessionFactory实例   
Configuration主要存在于初始化阶段，创建Session实例后就完成自己的使命。
`Configuration config = new Configuration().config();`  
主要：  
* 配置文件（hibernate.cfg.xml，可以使用properties配置）默认src目录下， 可以在config()方法加路径参数    
* 当使用properties配置文件时，则需要使用Configuration额外配置映射文件  `configuration.addResource("***");`

##### SessionFactory 对象
负责Hibernate初始化，和Session建立，在整个流查询程中起到了缓冲区的作用，Hibernate可以将生成的SQL、映射数据、以及其他可重复利用的数据存储到该缓冲区中。同时还保存着数据库配置的所有映射关系，维护着当前的二级缓存。

```
SessionFactory sessionFactory = cfg.buildSessionFactory();
```
特点：  线程安全、重量级，不能随机创建和销毁实例
一般情况下，个项目中只需保存一个SessionFactory实例就可以了（多个数据源除外）。   
Hibernate内部维护一个线程池，可以配置使用其他（例如：C3P0）。   

##### Session 对象  
Session是应用程序和数据库交互数据的一个单线程对象，是Hibernate运作中心，主要功能是为持久化对象实现创建、读取、删除。  
获取Session的两种方式：  
* `Session session = sessionFactory.openSession();` 需要手动clost()
* `Session session = sessionFactory.getCurrentSession()` 绑定到当前形成，会自动close
注意：  
* Seesion是线程不安全的，避免多个线程使用同一个Session；  
* 轻量级，创建销毁损耗资源不大  
提供的方法：  
* save()、update()、saveOrUpdate()
* delete()
* get()、load()根据主键查询
* createQuery()、createSQLQuery()用于数据库操作对象
* createCriteria()用于条件查询

##### Transaction
主要用于管理事务  

```
Transaction tx = session.beginTransaction();
tx.commit();
tx.rollback();
```

##### 持久化类的编写  
* 提供无参构造方法
* 私有化属性、公有化set|get方法
* 有唯一标识OID与主键对应
* 最好不使用final

##### 主键生成策略
主键类型：1、有业务意义的，例如：name；2、无业务意义的，例如：id  
生成策略：  
* increment	适用于int、long、short，不能在集群环境中使用
* identity	需数据库支持唯一自增
* sequence	根据底层数据库序列生成标示符
* native	自动根据数据选择适合的自增类型
* uuid		32位十六进制字符串
* assigned	有代码负责生成

##### 持久话对象的三种状态  
瞬时态：刚new出来的对象，不存在OID，尚未与Session关联，一句话就是此时数据库无该记录  
持久态：存在OID，关联了Session，在数据库有相应的记录  
托管态：持久态实例与Session失去关联，就成了拖管态。此时仍然有OID，数据库有相应的数据  

##### Hibernate一级缓存
Hibernate一级缓存指的是Session缓存。Session缓存是一块内存空间缓存，里面保存在java对象。  
Session接口中实现一系列的java集合，这些集合构成了Session缓存，只要Session没有结束生命周期，缓存数据也会一直存在。  
特点：  
* Session调用save()、update()、saveOrUpdate()时，如果缓存中不存在该OID对象，则会将数据库里面对应的数据取出加入缓存中。
* 调用Session中的load()、get()，Query中的list()、iterator()方法时，先查看缓存是否存在数据；在去数据库中查；最后添加到缓存中
* 调用Session的close()时，缓存被清空

##### 事务控制  
四个特征：原子性、一致性、隔离性、持久性  
事务的并发问题：  
在多个事务共同使用相同的数据时，会存在并发问题  
1、脏读：一个事务读取到另一个事务未提交的数据    
2、不可重复读：一个事务读取到另一个事务已经提交的update()数据，导致在同一个事务中的多次查询不一致  
3、虚读|幻读：一个事务读取到另一个事务已经提交的insert()数据，导致同一个事务中多次查询不一致。  

事务隔离级别：  
* 1|READ_UNCOMMIT 允许读取未提交改变了的数据，可能导致脏读、幻读、不可重复的
* 2|READ_COMMIT	允许在并发事务已经提交后读。可防止脏读（Oracle默认）
* 4|REPEATABLE_READ	对相同字段读取是一致的。可防止脏读、不可重复读（Mysql默认）
* 8|SERIALIZABLE	完全ACID，通过所锁表实现  
Hibernate中的事务管理：   
1、设置事务隔离配置 hibernate.cfg.xml 
`<property name="hibernate.connection.isolation">4</property>`  
2、事务中保证使用同一Session  
在业务层中获取Session传入DAO；将业务层获取的Session绑定到ThreadLocal  
管理Session的三种方法：  
* 与本地线程绑定
* 与JTA绑定
* 委托程序管理Session对象
在hibernate.cfg.xml中配置：  
`<property name="hibernate.current_session_context_class">thread</property>`

##### Hibetnate其他API
Query:  
代表面向对象的一个Hibernate查询。通常使用session.createQuery()方法接收一个HQL语句，然后调用Query中的list()方法或uniqueResult()执行查询。  
步骤：  
1、获取Session对象  
2、编写HQL语句  
3、调用createQuery()创建查询对象  
4、调用Query的set**()设置参数  
5、调用Query()中的list()或者uniqueResult()  

Criteria:(hibernate已经不推荐使用)    
步骤：  
1、获取Session对象  
2、通过Session获取Criteria对象  
3、使用Restrictions的静态方法创建Criteria条件对象，返回Criteria对象  
4、向Criteria对象中添加查询条件，add()方法  
5、执行Criteria方法的list()或者uniqueResult()方法  

SQLQuery:  
接收原生sql语句执行






































































