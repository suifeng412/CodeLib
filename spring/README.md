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




















