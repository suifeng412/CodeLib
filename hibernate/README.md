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










































