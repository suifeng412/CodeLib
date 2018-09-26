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



> Struts2常量配置

Struts2常量配置有三种方式：
1、在struts.xml文件中使用<constant>元素配置  
2、在struts.properties文件中配置
3、在web.xml文件中通<init-param>元素配置

```
//1
<constant name="struts.il8n.encoding" value="UTF-8" />
<constant name="struts.devMode" value="true" />
//2
struts.il8n.encoding=UTF-8
struts.devMode=true	
//3
 <filter>
  	<filter-name>struts2</filter-name>
  	<filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
  	<init-param>
  		<param-name>struts.il8n.encoding</param-name>
  		</param-value?URF-8</param-value>
  	</init-param>
  </filter>
```


> 分模块开发  

  `<include file="struts2/struts-shop.xml" />`


> Action编写方式

##### Action是一个POJO类  
不继承实现任何特殊类  
默认一个无参public构造函数
无参返回字符串的execute()方法

```
public class StrutsDemo1 {
	/**
	 * 提供一个默认的执行方法：execute
	 * return 返回的是一个视图名称
	 * @return
	 */
	public String execute() {
		System.out.println("这是Struts2Demo中的exexute。。。。");
		return "success";
	}
}
```
##### Action类实现一个Actio接口  
Struts2提供一个action接口

```
public calss ActionDemo2 implements Action{
	@Override
	public String execute() throws Exception{
		System.out.println("dfafafa");
		return null;
	}
}
```
定义了5个常量：
SUCCESS  
NONE		代表页面不跳转  
ERROR  
INPUT	数据校验的时候跳转的路径  
LOGIN  

##### Action类继承ActionSupport类  
ActionSupport类本身实现了Action接口，是Struts2中默认的Action接口实现类  
该类还实现了Validateable、ValidationAware、TextProvider、LocaleProvider、Serializable等接口  

```
public class ActionDemo3 extends ActionSupport{
	public Strubg execute() throws Exception{
		System.out.println("ddada");
		return NONE;
	}
}
```
通配符配置：  
``<global-allowed-methods>regex:.*</global-allowed-methods> // 2.5新添加的``



> Struts2访问Servlet的API  
##### 通过ActionContext类访问  

ActionContext是Action执行的上下文对象，在ActionContext中保存了Action执行所需要的所有对象，包括parameters、reqyest、session、application  
* void put(String key, Object value)		将key-value键值放入到该对象中（模拟Servlet API中的HttpServletRequest的setAttribute()方法）  
* Object get(String key)  
* Map<String, Object> getApplication		返回一个Application级的Map对象  
* static ActionContext getContext()		获取当前线程的ActionContext对象  
* Map<String, Object> getParameters()	返回一个包含有所有的HttpServletRequest参数信息的Map对象
* Map<String, Object> getSession() 		
* void setApplication(Map<String, Object> application)  
* void setSession(Map<String, Object> session)  
  
##### 通过特定接口访问   
ServletRequestAware  
ServletResponseAware  
SessionAware  
ServletContextAware  

```
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
}

public String execute() throws Exception {
	System.out.println("测试看有没有访问");
	request.setAttribute("message", "request.....");
	return SUCCESS;
}
```

##### 通过ServletActionContext访问  
为了直接访问Servlet API Struts2框架提供了ServletActionContext类，该类包含了几个常用的静态方法： 
static HttpServletRequest getRequest()
static HttpServletResponse getResponse()
static ServletContext getServletContext()  
static PageContext getPageContext()    


> 结果页面的配置  

##### 全局结果页面配置
只在同一个包下面配置的Action中返回的相同的字符串都可以跳转到该页面

```
<global-results>
	<result name="success">/success.jsp</result>
</global-results>

```
##### 局部结果页面配置
只对action有效

##### ResultType  
type总的类型  
* chain			用来处理Action链，被跳转的Action中仍能获取上个页面的值，如request
* dispatcher		用来转向页面，通常处理jsp，【默认】  
* freemarker		用来整合FreeMarker模板结果类型  
* httpheader		用来处理特殊的HTTP行为结果类型  
* redirect		重定向一个URL，丢失页面信息  
* redirectAction		重定向到一个action，丢失页面信息  
* stream			向浏览器发送InputStream对象，通常用来处理文件下载  
* velocity		整合Velocity模板结果类型  
* xslt			XML/XSLT结果类型  
* plainText		原始文件  
* postback		使得当前请求参数以表单的形式提交  


> Struts的数据封装  

##### 属性驱动  
提供属性的set方法的方式：

```
// 为每一个属性建一个set方法
// 缺点，属性多的时候雷同的方法过多
public void setName(String name) {
		this.name = name;
	}
```

页面提供表达式方法  

```
// 必须提供该get方法
	public User getUser() {
		return user;
	}
```

##### 模型驱动  
通过实现ModelDriven接口来接收请求参数，action类必须实现ModelDriven接口，并且重写getModel方法  

```
private User user = new User();
	
public User getModel() {
	return user;
}
```






















