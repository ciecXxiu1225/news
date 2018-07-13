package cn.edu.imnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.dao.UserDao;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userid = request.getParameter("form-username");
		String email = request.getParameter("form-email");
		String userpwd = request.getParameter("form-password");

		UserDao dao = new UserDao();
		boolean flag = dao.isExitEmail(userid);

		if (flag) {
			response.sendRedirect("AddUser.jsp");
			System.out.println("账号已被注册，请重新输入！");
		} else {
			dao.AddUser(userid, email, userpwd);
			response.sendRedirect("NewsServlet");
			System.out.println("注册成功！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
