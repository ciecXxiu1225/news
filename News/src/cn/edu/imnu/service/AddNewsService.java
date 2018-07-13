package cn.edu.imnu.service;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.dao.NewsDao;

public class AddNewsService {

	public int LoginValidate(String n_title, String n_time, String url, int u_id, String n_thing) {
		NewsBean userbean = new NewsBean();
		userbean.setU_id(u_id);
		userbean.setN_image(url);
		userbean.setN_thing(n_thing);
		userbean.setN_title(n_title);
		userbean.setN_time(n_time);
		NewsDao sd = new NewsDao();
		int rs = sd.login(userbean);
		return rs;
	}

}
