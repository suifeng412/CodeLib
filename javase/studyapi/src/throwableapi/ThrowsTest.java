package throwableapi;

/*
 * throws仅仅是将函数中可能出现的异常向调用者声明，而自己不具体处理。
 * throws声明：如果一个方法内部的代码会抛出检查异常（checked exception），而方法自己又没有完全处理掉，
 * 则javac保证你必须在方法的签名上使用throws关键字声明这些可能抛出的异常，否则编译不通过。
 * 
 * 
 * public void foo() throws ExceptionType1 , ExceptionType2 ,ExceptionTypeN
 *{ 
 *    //foo内部可以抛出 ExceptionType1 , ExceptionType2 ,ExceptionTypeN 类的异常，或者他们的子类的异常对象。
 *}
 * 
 * throw异常抛出语句
 * 必须写在函数中
 * 可以手动显式的抛出异常 后面必须是一个异常对象
 * throw exceptionObject
 * 
 * 异常链化:
 * 以一个异常对象为参数构造新的异常对象。
 * 新的异对象将包含先前异常的信息。
 * 这项技术主要是异常类的一个带Throwable参数的函数来实现的。
 * 这个当做参数的异常，我们叫他根源异常（cause）。
 * 
 * */
public class ThrowsTest {
	public static void main(String args[]) {
		
	}
}
