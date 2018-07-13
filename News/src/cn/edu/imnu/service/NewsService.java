package cn.edu.imnu.service;

import java.util.List;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.dao.NewsDao;

public class NewsService {

		public List<NewsBean> getStoresList() {
			NewsDao messagedao = new NewsDao();
			List<NewsBean> listapp = messagedao.getStores();
			return listapp;
		}

		public List<NewsBean> getnewsList() {
			NewsDao messagedao = new NewsDao();
			List<NewsBean> list = messagedao.getNews();
			return list;
		}


		public List<NewsBean> ReadmoreList(String n_id) {
			UserBean userbean = new UserBean();
			userbean.setUsername(n_id);
			NewsDao messagedao = new NewsDao();
			List<NewsBean> listapp = messagedao.readmore(userbean);
			return listapp;
		}

}
