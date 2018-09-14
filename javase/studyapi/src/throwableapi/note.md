# 异常处理
>  Throwable是所有异常顶层父类 包含Error类、Execption类
 
  * 错误：Error类代表JVM本身错误，通过代码不能够处理，比较少出现  
  * 异常：Exception类，代表程序运行时发生的各种不期望发生的事件，能够被异常机制捕获处理，是异常处理的核心  

> 针对javac编译来说可以分为两类，检查异常和非检查异常  

 * 检查异常：IOException javac要求强制为这些异常做好预备工作，否则不通过编译。（如SQLException , IOException,ClassNotFoundException 等。）
 * 非检查异常：Error、RuntimeException（java编译器不要求必须进行异常捕获处理或者抛出声明）  
   例如，使用空对象导致的NullPointerException（NullPointerException、IndexOutOfBoundsException）
   
> 异常是在执行函数的时候引发的，而函数是层级调用（入栈）=》形成内存追踪栈  

> 【异常处理的基本语法】  

* 1、try…catch…finally
* 2、在函数签名中使用throws 声明交给函数调用者caller去解决

#### try...catch...finally
* 语句块中的变量数据是局部变量，不可共享
* 在try块中即便有return，break，continue等改变执行流的语句，finally也会执行
* 假设在try、catch、finally中都存在return语句，那么最后finally将会覆盖前面的值返回。因为返回出去就只有一个内存地址
* 每一个catch块用于捕获并处理一个特定的异常，或者这异常类型的子类。Java7中可以将多个异常声明在一个catch中。
* catcha匹配到异常则后面的不再匹配；没匹配到则执行finnally然后跳出函数的外部caller中去匹配异常处理器
* 至少存在一个catcha或者finally块
* finally主要做一些清理工作(资源释放)，如流的关闭，数据库连接的关闭等。

#### throws
throws仅仅是将函数中可能出现的异常向调用者声明，而自己不具体处理。  
throws声明：如果一个方法内部的代码会抛出检查异常（checked exception），而方法自己又没有完全处理掉，则javac保证你必须在方法的签名上使用throws关键字声明这些可能抛出的异常，否则编译不通过。  

```
public void foo() throws ExceptionType1 , ExceptionType2 ,ExceptionTypeN
{ 
     //foo内部可以抛出 ExceptionType1 , ExceptionType2 ,ExceptionTypeN 类的异常，或者他们的子类的异常对象。
}
```
 * throw异常抛出语句必须写在函数中
 * 可以手动显式的抛出异常 后面必须是一个异常对象  eg.`throw exceptionObject`

_异常链化：_  
_以一个异常对象为参数构造新的异常对象。_  
_新的异对象将包含先前异常的信息。_  
_这项技术主要是异常类的一个带Throwable参数的函数来实现的。_    
_这个当做参数的异常，我们叫他根源异常（cause）。_  

#### 自定义异常
 * 扩展Exception，这样子自定义的异常属于检查异常checked exception
 * 扩展RuntimeExecption，则为非检查异常

> 自定义异常包含如下构造函数：  

可参照IOException类源码 
* 无参构造函数
* 带String参数的构造函数，
* 带String参数和Throwable参数构造函数，向上传递
* 带Throwable参数构造函数，向上传递

> 异常的注意事项：  

* 子类重写父类且带有throws声明函数时，其throws声明的异常必须在父类异常的可控范围内（即子类必须符合父类的要求）  
_例如：_  
父类方法throws 的是2个异常，子类就不能throws 3个及以上的异常。
父类throws IOException，子类就必须throws IOException或者IOException的子类。

```
// 错误示例
class Father
{
    public void start() throws IOException
    {
        throw new IOException();
    }
}
 
class Son extends Father
{
    public void start() throws Exception
    {
        throw new SQLException();
    }
}
```
* java是多线程的，每一个线程都是一个独立的执行流，独立的函数调用栈。即线程中的错误不会影响到其他的线程，只会导致该线程的结束 



