package web14_response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 设置状态码
//		 response.setStatus(201);
//		 response.sendError(404, "not found 666666");

		// 设置相应头
		response.addHeader("addHead1", "addHead11");
		response.addHeader("addHead1", "addHead22"); // 追加
		response.addHeader("setHead", "setHead");
		response.setHeader("addHead", "setHeade"); // 重置

		response.addIntHeader("addInt", 123); // 同理
		response.setIntHeader("setInt", 666);

		response.setContentLength(123456); // 设置相应体的大小

		response.setContentType("text/html;charset=UTF-8"); // 设置字符编码
		response.setLocale(null); // 设置本地化信息
		response.setCharacterEncoding(null); // 优先级最高，将会覆盖前两种

		// 【getOutputStream与getWriter方法相互排斥，同时出现则会出错】
		// 发送相应消息体
		// getOutputStream获取的对象为ServletOutputStream类型=》是OutputStream子类
		// 可以直接输出字节数组中的二进制数据
		String data = "this is string";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes());
		// getWriter获取字符输出流对象为PrintWriter类型
		// 可以直接输出字符
//		PrintWriter print = response.getWriter();
//		print.write(data);

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
