package cn.edu.imnu.service;

import java.util.List;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.dao.NewsDao;

public class ChangeService {

	public List<NewsBean> ChangeList(String n_id) {
		NewsDao Newsdao = new NewsDao();
		NewsBean newsbean = new NewsBean();
		newsbean.setN_title(n_id);
		List<NewsBean> listapp = Newsdao.ChangeNews(newsbean);
		return listapp;
	}

}
