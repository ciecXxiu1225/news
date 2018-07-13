package cn.edu.imnu.service;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.dao.UserDao;
public class UserService {
	public UserBean LoginValidate(String login_username, String login_password,String login_type) {
		UserBean userbean = new UserBean();
		userbean.setUsername(login_username);
		userbean.setPassword(login_password);
		userbean.setType(login_type);
		UserDao sd = new UserDao();
		UserBean rs = sd.login(userbean);
		return rs;
	}

}
