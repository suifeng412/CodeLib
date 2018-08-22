package throwableapi;

import java.io.IOException;

/*
 * 
 * 自定义异常
 * 扩展Exception，这样子自定义的异常属于检查异常checked exception
 * 扩展RuntimeExecption，则为非检查异常
 * 
 * 自定义异常包含如下构造函数：
 * 1、无参构造函数
 * 2、带String参数的构造函数，
 * 3、带String参数和Throwable参数构造函数，向上传递
 * 4、带Throwable参数构造函数，向上传递
 * 可参照IOException类源码
 * 
 * 异常的注意事项：
 * 1、子类重写父类且带有throws声明函数时，其throws声明的异常必须在父类异常的可控范围内（即子类必须符合父类的要求）
 * 例如：
 * 父类方法throws 的是2个异常，子类就不能throws 3个及以上的异常。
 * 父类throws IOException，子类就必须throws IOException或者IOException的子类。
 * 2、java是多线程的，每一个线程都是一个独立的执行流，独立的函数调用栈。即线程中的错误不会影响到其他的线程，只会导致该线程的结束
 * 
 * 
 * 
 * 
 * 
 * 
 * */

public class UserDefinedExceptionTest {
	public static void main(String args[]) {

	}

	/*
	 * public class IOException extends Exception { static final long
	 * serialVersionUID = 7818375828146090155L;
	 * 
	 * public IOException() { super(); }
	 * 
	 * public IOException(String message) { super(message); }
	 * 
	 * public IOException(String message, Throwable cause) { super(message, cause);
	 * }
	 * 
	 * public IOException(Throwable cause) { super(cause); } }
	 */
}


/*
 错误示例代码：
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
*/
