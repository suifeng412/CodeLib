package throwableapi;

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
