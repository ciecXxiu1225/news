package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.service.NewsService;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		UserBean bean=(UserBean) session.getAttribute("user");
		String type = bean.getType();
		String str = "普通用户";
		NewsService newsservice = new NewsService();
		List<NewsBean> listapp = newsservice.getStoresList();
		request.setAttribute("list", listapp);
		NewsService news = new NewsService();
		List<NewsBean> list = news.getnewsList();
		request.setAttribute("listapp", list);
		if(type.equals(str)) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("ManageIndex.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
