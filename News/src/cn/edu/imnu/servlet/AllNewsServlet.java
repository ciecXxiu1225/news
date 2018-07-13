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
import cn.edu.imnu.service.NewsService;

@WebServlet("/AllNewsServlet")
public class AllNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AllNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session1 = request.getSession();
		NewsBean bean=(NewsBean) session1.getAttribute("idbean");
		String n_id = bean.getN_title();
		NewsService newsservice = new NewsService();
		List<NewsBean> readmore = newsservice.ReadmoreList(n_id);
		request.setAttribute("list", readmore);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
