#  Object
> Object 是java对象的基类，定义了13个方法，没有属性

> * 1.类构造器public Object();  

> * 2.private static native void registerNatives();  
  	native关键字修饰的函数，是在C/C++实现的，并编译成dll文件，由java调用  
  	该方法的作用将C/C++中的方法映射到Java中的native方法，实现方法命名的解耦。  

> * 3.protected native Object clone() throws CloneNotSupportedException;
    clone采用的是值传递方式，全新的一个对象
    
> * 4.public final native Class<?> getClass();
     getClass()也是一个native方法，返回的是此Object对象的类对象/运行时类对象Class<?>。效果与Object.class相同。
     
>* 5.public boolean equals(Object obj);  
   “==”表示的是变量值完成相同（对于基础类型，地址中存储的是值，引用类型则存储指向实际对象的地址）  
   equals表示的是对象的内容完全相同，此处的内容多指对象的特征/属性。  
   Object类中定义该方法实现为==，一般需要重写再用  
   [重写equals()方法必须重写hasCode()方法。]  
  
>* 6.public native int hashCode();  
   hashCode()方法返回一个整形数值，表示该对象的哈希码值。  
   首先、同一次执行是多次调用的该方法返回的哈希码相同，期间equals方法没改  
   其次、equals相等，那么哈希值必须相同  
   最后、反过来，哈希值相同，两个对象不一定相等   
   =》主要作是用于集合中的判断，用有序的哈希表值进行判断，性更更高
 
>* 7.public String toString();  
   toString()方法返回该对象的字符串表示  
   内部实现：return getClass().getName() + "@" + Integer.toHexString(hashCode());  
   返回类型+哈希值的十六进制数  
   =》即不同对象的toString可能相同  
 
>* 8~12  
   wait();  
   调用此方法所在的当前线程等待，直到在其他线程上调用该方法的主调 notify()、notifyAll()
   wait(long timeout)/wait(long timeout, int nanos);  
   调用此方法所在的当前线程等待，直到在其他线程上调用该方法的主调 notisfy()/notisfyAll()方法，或超过指定的超时时间量  
   notify()/notifyAll();  
   唤醒在此对象监视器上等待的单个线程/所有线程
    
> * 13. protected void finalize();  
   finalize方法主要与Java垃圾回收机制有关  
   其具体调用时机在：JVM准备对此对形象所占用的内存空间进行垃圾回收前，将被调用。

