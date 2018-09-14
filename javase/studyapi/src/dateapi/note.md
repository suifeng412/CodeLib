# Date类
> JDK1.1前Date类完成日期表示、转换、设定修改三个功能、后来拆分为三个类

> * Date 负责时间的表示
> * Calendar 是一个时间工具类，负责对Date类进行修改等操作  
> * DateFormat 负责日期的转换（读特定格式的时间字符串装维Date对象、或将对象转换为字符串）


  
#### Date
 * Date() 
 * Date(long date)
 * before，after，compareTo
 * getMillisOf()
 
 
 
#### Calendar 
该类本身不存储对象，在内部有一个变量记录一个毫秒数，他不是操作外部date对象，而是操作自己内部毫秒数  
Calendar本身是一个抽象类，不能直接实例化，它提供一个工厂方法getInstance()方法来创建一个实例  
 * setTime()  设定一个Calendar内部的毫秒数
 * set()  设置时间
 * get()  获取时间
 
> 国际化与时区问题：

 * TimeZone.getAvailableIDs() 获取所有时区id
 * TimeZone.getDefault() 查看默认时区

#### DateFormat类
本身是一个抽象类，一般都是使用它的子类SimpleDateFormat
 * parse() 字符串转换为对象
 * format() 对象转换为字符串  

>设置style和locale参数

style就是长度、locale为格式化时间的地区
 * DateFormat format = DateFormat.getDateInstance(DateFormat.LONG, Locale.SIMPLIFIED_CHINESE);
 * format.format(new Date()))


 * SimpleDateFormat [常用的时间格式化类，可以自由搭配]
 * 当使用parse时，只有你的字符串和SimpleDateFormat的pattern完全匹配才能识别，否则报错。