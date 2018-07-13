package cn.edu.imnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String Login_username = request.getParameter("login-username");
		String Login_password = request.getParameter("login-password");
		String login_type = null;
		String checkcode = request.getParameter("validateCode");
		HttpSession session=request.getSession(true);  

		UserService userservice = new UserService();
		UserBean user = userservice.LoginValidate(Login_username, Login_password, login_type);
		session.setAttribute("user", user);
		
		if (checkcode.equalsIgnoreCase((String) session.getAttribute("randCheckCode")) && checkcode != "") {
			if (user != null) {
					response.sendRedirect("NewsServlet");
			} else {
				System.out.println("用户名或密码错误！");
				response.sendRedirect("Login.html");
			}
		} else {
			System.out.println("验证码错误！");
			response.sendRedirect("Login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
