package web15_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String method = request.getMethod();
		System.out.println(method);
		
		String contextpaht = request.getContextPath();
		System.out.println(contextpaht);
		
		String remoteaddr = request.getRemoteAddr();
		System.out.println(remoteaddr);
		
		// 获取请求头相关方法
		String h = request.getHeader("host");  //getHeaders
		System.out.println(h);
		
		PrintWriter print = response.getWriter();
		Enumeration<String> hs = request.getHeaderNames();
		while(hs.hasMoreElements()) {
			String headerName = (String) hs.nextElement();
			print.println(headerName+":"+request.getHeader(headerName)+"<br/>");
		}
		
		
		// int i = request.getIntHeader("ddd");
//		Long date = getDateHeader();
		
//		String contenttype = request.getContentType();
//		int conentlength = request.getContentLength();
//		String character = request.getCharacterEncoding();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
