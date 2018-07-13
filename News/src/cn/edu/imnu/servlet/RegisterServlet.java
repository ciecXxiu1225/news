package cn.edu.imnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.dao.UserDao;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("register-username");
		String email = request.getParameter("register-email");
		String userpwd = request.getParameter("register-password");
		
		UserDao dao = new UserDao();
		boolean flag = dao.isExitEmail(userid);

		if(flag){
			response.sendRedirect("Login.html");
			System.out.println("账号已被注册，请重新输入！");	
		}
		else{
			dao.save(userid,email,userpwd);
			response.sendRedirect("Login.html");
			System.out.println("注册成功！");
		}
	}
	}
