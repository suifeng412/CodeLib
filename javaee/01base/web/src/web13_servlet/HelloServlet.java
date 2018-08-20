package web13_servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int count = (int) this.getServletContext().getAttribute("count");
		System.out.println(count);
		count++;
		this.getServletContext().setAttribute("count", count);

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println(name + "---" + phone);

		String[] values = request.getParameterValues("values");
		System.out.println(Arrays.toString(values));

		Map<String, String[]> arr = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : arr.entrySet()) {
			System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
		}
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
