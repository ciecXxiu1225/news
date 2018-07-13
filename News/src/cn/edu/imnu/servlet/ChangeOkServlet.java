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
import cn.edu.imnu.service.ChangeService;

@WebServlet("/ChangeOkServlet")
public class ChangeOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeOkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session2 = request.getSession();
		NewsBean bean1=(NewsBean) session2.getAttribute("idbean2");
		String n_id = bean1.getN_title();
		System.out.println(n_id);
		ChangeService changeservice = new ChangeService();
		List<NewsBean> change = changeservice.ChangeList(n_id);
		request.setAttribute("change", change);
		request.getRequestDispatcher("change.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
