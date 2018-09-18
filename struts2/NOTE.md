# 笔记
>Struts2 执行流程

1、客户端发送请求  
2、前端控制器（核心过滤器StrutsPrepareAndExecuteFilter）过滤执行拦截  
3、执行目标的Action  
4、在Action中返回一个结果视图，根据Result的配置进行页面跳转  

> Struts2的配置文件的加载顺序  

StrutsPrepareAndExecuteFilter有两个功能，预处理和执行
预处理是用来加载配置文件=》过滤器中的init方法
执行是用来执行一组拦截器完成部分功能=》doFilter方法

```
init_DefaultProperties()  // 用来加载Struts2的配置文件
init_TraditionalXmlConfigurations()  // 加载org.apache.struts.default.Properties配置的是
init_LegacyStrutsProperties()	 // 加载struts-default.xml、struts-plugin.xml、struts.xml
init_CustomConfigurationProviders()   // 加载与欧诺个户自定义struts.properties
init_FilterInitParameters()	// 加载用户配置的提供对象
init_AliasStandardObjexts()	// 加载web.xml
```
配置文件加载顺序：  
1、default.properties（内部）  
2、struts-default.xml（内部）  
3、struts-plugin.xml（内部）  
4、struts.xml  
5、struts.properties  
6、web.xml  

> Action配置

Struct2框架的核心配置文件是struct.xml文件，该文件主要用来配置Action和请求的对应关系  
使用包来管理Action和拦截器，每个包就是多个Action、多个拦截器、多个拦截器引用的集合  
package元素用于定于包配置。  
package元素的常用属性：
* name		【必填】包名字，被其他包引用的key
* namespace	【选填】命名空间	namespace属性与action中的name共同决定了访问路径
* extends	【选填】继承其他包 通常为struts-default
* abstract	【选填】是否抽象包

namespace有三种配置：  
1、默认名称空间	''  
2、跟名称空间		/  
3、带名称的名称空间	'/demo1'  

##### Action  
Action映射就是将一个请求的url映射到一个Action类
Action元素的常用属性：  
* name		【必填】 标识Action，指定了Action所处理的URL
* class 		【可选】 指定Action对应的Action类（全路径）
* method		【可选】 指定请求的Action师调用的方法
* converter	【可选】 指定类型转换器的类













