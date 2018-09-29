# Spring

> EE开发分成三层结构

* Web层：Spring MVC
* 业务层：Bean管理（IOC）
* 持久层：Spring的JDBC模板 ORM模板用于整合其他的持久层框架 

##### 开发步骤
* 导入Spring包  
* 引入相关配置文件  
* 编写相关的类  
* 完成配置，主要是bean配置  
* 编写调用逻辑  

     IOC：控制反转，将对象的创建权交给Spring
     DI：Dependency Injection 依赖注入，需要有IOC的环境，Spring将类的依赖的属性设置进去

>  Spring中的工厂（容器）

* ApplicationContext  
ClassPathXmlApplicationContext	:加载类路径下Spring的配置文件  
FileSystemXmlApplicationContext	:加载本地磁盘下Spring的配置文件  

* BeanFactory(过时)  

区别：BeanFactory是在getBean的时候才会生成类的实例；ApplicationContext是在加载applicationContext.xml（容器启动）时候就会创建


> Spring的相关配置

##### id属性和name属性标签配置
id：采用ID唯一约束，必须以字母开头  
name：没有唯一约束，如果无id的时候，可以当做id来使用  

##### scope属性
Bean的作用范围  
* singleton	：默认值，单例
* prototype 	：多例的 
* request	：WEB项目中,Spring创建一个Bean的对象,将对象存入到request域中.   
* session	：WEB项目中,Spring创建一个Bean的对象,将对象存入到session域中.   
* globalSession ：WEB项目中,应用在Porlet环境.如果没有Porlet环境那么globalSession相当于session.  

##### Bean的生命周期的配置  
通过<bean>标签上的init-method作为Bean的初始化的时候执行的方法，配置destroy-method作为Bean的销毁的时候执行方法  
销毁方法想要执行，需要是单例创建的Bean而且在工厂关闭的时候，Bean才会销毁  

> Spring的Bean的管理XML的方式 

##### Spring生成Bean的时候三种方式（了解）
【无参方式】  
`<bean id="bean1" calss="***.Bean1"></bean>`
【静态工厂实例化的方式】  

```
//提供一个工厂类
public class Bean2Factory {
	public static Bean2 getBean2() {
		return new Bean2();
	}
}
<bean id="bean2" class="***.Bean2Factory" factory-method="getBean2" />
```
【实例工厂实例化的方式】  

```
// 提供Bean3的实例化工厂
public class Bean3Factory{
	public Bean3 getBean3(){
		return new Bean3();
	}
}
// 方式三：实例工厂实例化Bean
<bean id="bean3Factory" class="***.Bean3Factory"></bean>
<bean id="bean3" factory-bean="bean3Factory" factory-method="getBean3"></bean>
```

##### Spring的Bean的属性注入  

```
// 构造方法的方式注入属性
<bean id="car" class="cn.itcast.spring.demo4.Car">   
	<constructor-arg name="name" value="保时捷"/>   
	<constructor-arg name="price" value="1000000"/> 
</bean>  

// set方法的方式注入属性
<bean id="car2" class="cn.itcast.spring.demo4.Car2">   
	<property name="name" value="奇瑞QQ"/>   
	<property name="price" value="40000"/> 
</bean> 
```

##### Spring的属性注入：对象类型注入  

```
<!-- 注入对象类型的属性 -->  
<bean id="person" class="cn.itcast.spring.demo4.Person">   
	<property name="name" value="会希"/>   
	<!-- ref属性：引用另一个bean的id或name -->   
	<property name="car2" ref="car2"/>  
</bean>  
```

##### 名称空间p的属性注入方式（Spring2.x后提供的方式）

```
第一步:引入p名称空间 
<beans xmlns="http://www.springframework.org/schema/beans"     xmlns:p="http://www.springframework.org/schema/p"     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"     xsi:schemaLocation="         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">  
第二步:使用p名称空间.     
* 普通属性:      p:属性名称=””     
* 对象类型属性: p:属性名称-ref=”” 
 <!-- p名称空间的属性注入的方式 -->  
 <bean id="car2" class="cn.itcast.spring.demo4.Car2" p:name="宝马7" p:price="1200000"/> 
 <bean id="person" class="cn.itcast.spring.demo4.Person" p:name="思聪" p:car2-ref="car2"/> 
```

##### SpEL的方式的属性注入（Spring3.x版本后提供的方式）

```
语法：#{SpEL}
 <!-- SpEL的注入的方式 -->  
 <bean id="car2" class="cn.itcast.spring.demo4.Car2">   
 	<property name="name" value="#{'奔驰'}"/>   
 	<property name="price" value="#{800000}"/>  
 </bean>      
 <bean id="person" class="cn.itcast.spring.demo4.Person">      
 	<property name="name" value="#{'冠希'}"/>      
 	<property name="car2" value="#{car2}"/>     
 </bean>   
 <bean id="carInfo" class="cn.itcast.spring.demo4.CarInfo"></bean>     
 
 引用了另一个类的属性  
 <bean id="car2" class="cn.itcast.spring.demo4.Car2"> 
 <!--   <property name="name" value="#{'奔驰'}"/> -->   
 <property name="name" value="#{carInfo.carName}"/>   
 <property name="price" value="#{carInfo.calculatePrice()}"/>  
 
 </bean>
```

##### 注入复杂类型 

```
<!-- Spring的复杂类型的注入===================== -->  
<bean id="collectionBean" class="cn.itcast.spring.demo5.CollectionBean">   
	    
	<!-- 数组类型的属性 -->  
	<property name="arrs">     
		<list>     
			<value>会希</value>     
			<value>冠希</value>     
			<value>天一</value>    
		</list> 
  	</property>      
  	
  	<!-- 注入List集合的数据 -->   
  	<property name="list">    
  		<list>    
  			 <value>芙蓉</value>     
  			 <value>如花</value>     
  			 <value>凤姐</value>    
  		</list>   
  	</property>      
  	
  	<!-- 注入Map集合 -->   
  	<property name="map">    
  		<map>     
  			<entry key="aaa" value="111"/>    
  			<entry key="bbb" value="222"/>     
  			<entry key="ccc" value="333"/>    
  		</map>   
  	</property>      
  	
  	<!-- Properties的注入 -->   
  	<property name="properties">    
  		<props>     
  			<prop key="username">root</prop>     
  			<prop key="password">123</prop>    
  		</props>  
  	</property> 
</bean> 
```

##### Spring的分配文件的开发  

```
一种:创建工厂的时候加载多个配置文件: 
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");    
二种:在一个配置文件中包含另一个配置文件： 
<import resource="applicationContext2.xml"></import> 
```



> Spring的Bean的管理注入的方式

##### 步骤
* 引入约束，与xml约束不一样！！！  
* 编写相关的类  
* 配置文件--配置注释扫描配置（具体到包名即可、xml具体到类名）  
* 在相关的类中添加注解  


##### Spring的Bean管理中常用的注释  
Spring中提供@Component的三个衍生注释：  
目前功能是一样的，采用不同的字符，可以使标注类本身的用途更清晰  
* @Controller	：WEB层  
* @Service		：业务层
* @Repository	：持久层  

##### 属性注入的注解
使用注解注入的方式，可以不用提供set方法  
* @value		：用于注入普通类型  
* @Autowried		：自动装配  
	默认按类型进行装配  
	按名称注入
* @Qualifier	：强制使用名称注入
* @Resource	：相当于@Autowried和@Qualifier一起使用

##### Bean的作用范围的注解  
@Scope：singleton单例、prototype多例  

##### Bean的生命周期的配置  
@PostConstruct :相当于init-method   
@PreDestroy  :相当于destroy-method

##### Spring的Bean管理的方式比较  
定义方式	：	<bean id="**" class="**"/>；@Component.....  
名称		：	通过id或者name；@Component("person")  
注入		：	<property>或p命名空间；@AutoWried按类型注入、@Qualifier按名称注入  
生命过程、Bean作用范围	：	init-method、destroy-method、范围scope属性；@PostConstruct、@PreDestroy、@Scope  
适用场景	：	Bean来自第三方；Bean实现类由自己开发  


























