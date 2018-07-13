package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.imnu.bean.NewsBean;
import net.sf.json.JSONObject;

@WebServlet("/ReadmorServlet")
public class ReadmorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadmorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String n_id = request.getParameter("id");
		NewsBean idbean = new NewsBean();
		idbean.setN_title(n_id);
		HttpSession session1=request.getSession(true);  
		session1.setAttribute("idbean", idbean);
		Map<String,String> map = new HashMap<String,String>();
		JSONObject json=JSONObject.fromObject(map);
		response.getWriter().print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
