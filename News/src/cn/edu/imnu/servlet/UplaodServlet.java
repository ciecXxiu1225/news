package cn.edu.imnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.dao.NewsDao;

@WebServlet("/UplaodServlet")
public class UplaodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UplaodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		UserBean bean=(UserBean) session.getAttribute("user");
		int u_id = bean.getU_id();
		String n_title = request.getParameter("n_title"); 
		String n_time = request.getParameter("n_time"); 
		String n_thing = request.getParameter("n_thing");
		Part p = request.getPart("img_url"); 
		System.out.println(n_title);

		try {
			p.write(request.getServletContext().getRealPath("/upload")+"/"+n_title+".jpg");
			String url = request.getScheme() + "://" + request.getHeader("host") + request.getContextPath() + "/upload/"
					+ n_title + ".jpg";
			NewsDao userdao = new NewsDao();
			int rs = userdao.updateAvatarUrl(n_title,n_time,url,u_id,n_thing);
			if (rs > 0) {
				response.sendRedirect(request.getContextPath() + "/NewsServlet");
			} else {
				response.sendRedirect(request.getContextPath() + "/upload.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}
}
