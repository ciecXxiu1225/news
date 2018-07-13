package cn.edu.imnu.service;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.dao.NewsDao;

public class DeleteService {

	public int LoginValidate(String n_id) {
		NewsBean newsbean = new NewsBean();
		newsbean.setN_title(n_id);
		NewsDao sd = new NewsDao();
		int rs = sd.Register(newsbean);
		return rs;
	}

}
