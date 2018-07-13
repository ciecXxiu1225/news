package cn.edu.imnu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.service.DeleteService;
import net.sf.json.JSONObject;

@WebServlet("/DeleteServlte")
public class DeleteServlte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlte() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n_id = request.getParameter("id"); 
		System.out.println(n_id);
		
		DeleteService userservice = new DeleteService();
//		int rs=
		userservice.LoginValidate(n_id);
		Map<String,String> map = new HashMap<String,String>();
		JSONObject json=JSONObject.fromObject(map);
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
