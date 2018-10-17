# String
> StringBuffer、StringBuilder

## 1. String 
String 代表字符串，是常量不可变  
```
The value is used for character storage. // private final char value[];
// String字符串存放在final修饰的字符数组中  
// String对象改变字符串时是新建一个字符对象，就对象被GC回收=》效率不高

// 常用的api方法： 
 boolean endsWith(String suffix) 以什么结尾   
 boolean startsWith(String prefix)  
 boolean equals(Object other)   
 boolean equalsIgnoreCase(String other)   
 int length()  
 String replace(CharSequence oldString, CharSequence newString) 【连续字符串】  
 String substring(int beginIndex, int endIndex)  
 String substring(int beginIndex)  
 String toLowerCase()、String toUpperCase()  
 String trim()  
```


## 2. StringBuffer
* StringBuffer 是可变字符  
* 默认容量是十六个字符,每次扩容的时候是实际长度*2+2  
* 该类中的方法都是synchronized修饰，线程同步，即是线性安全的  
* 重新构造字符，拷贝字符到新字符对象中，GC回收旧字符=》为了性能一般都会预估大一点的容量  

```
// 常用的api方法：
 StringBuffer() 构造一个控制符  
 int length()  
 StringBuffer append(Char c)  追加字符  
 void setCharAt(int i, char c)  将第下标为i的设置为字符c  
 StringBuffer reverse() 反转  
 String toString()  返回字符串类型字符串  
```
><font color=red size=3 face=“宋体”>注意:  
该类与String没有父子关系，因此不能强制类型转换  
该声明方式与String有一些不同点，必须通过new来实例化，不能通过双引号""
</font>

## 3. StringBuilder  
* StringBuilder 是可变字符串  
* 是非线性安全  
* JDK5.0之后引进的类，前身是StringBuffer Api完全相同  





