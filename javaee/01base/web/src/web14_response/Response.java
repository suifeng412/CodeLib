package web14_response;

import java.io.IOException;
import java.io.OutputStream;


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
		// ����״̬��
//		 response.setStatus(201);
//		 response.sendError(404, "not found 666666");

		// ������Ӧͷ
		response.addHeader("addHead1", "addHead11");
		response.addHeader("addHead1", "addHead22"); // ׷��
		response.addHeader("setHead", "setHead");
		response.setHeader("addHead", "setHeade"); // ����

		response.addIntHeader("addInt", 123); // ͬ��
		response.setIntHeader("setInt", 666);

		response.setContentLength(123456); // ������Ӧ��Ĵ�С

		response.setContentType("text/html;charset=UTF-8"); // �����ַ�����
		response.setLocale(null); // ���ñ��ػ���Ϣ
		response.setCharacterEncoding(null); // ���ȼ���ߣ����Ḳ��ǰ����

		// ��getOutputStream��getWriter�����໥�ų⣬ͬʱ����������
		// ������Ӧ��Ϣ��
		// getOutputStream��ȡ�Ķ���ΪServletOutputStream����=����OutputStream����
		// ����ֱ������ֽ������еĶ���������
		String data = "this is string";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes());
		// getWriter��ȡ�ַ����������ΪPrintWriter����
		// ����ֱ������ַ�
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
