package cn.edu.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.bean.NewsBean;
import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.util.DBUtil;

public class NewsDao {
	public List<NewsBean> getStores() {
		Connection conn = DBUtil.getConnection();
		String sql= "SELECT * FROM news ORDER BY n_id DESC LIMIT 0,4";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<NewsBean> listapp = new ArrayList<NewsBean>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				NewsBean bean = new NewsBean();
				bean.setN_image(rs.getString("n_image"));
				bean.setN_thing(rs.getString("n_thing"));
				bean.setN_title(rs.getString("n_title"));
				bean.setU_id(rs.getInt("u_id"));
				bean.setN_id(rs.getInt("n_id"));
				bean.setN_time(rs.getString("n_time"));
				listapp.add(bean);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn, pstm, rs);
		}
		return listapp;
	}

	public List<NewsBean> getNews() {
		Connection conn = DBUtil.getConnection();
		String sql= "SELECT * FROM news ORDER BY n_id DESC";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<NewsBean> list = new ArrayList<NewsBean>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				NewsBean bean = new NewsBean();
				bean.setN_image(rs.getString("n_image"));
				bean.setN_thing(rs.getString("n_thing"));
				bean.setN_title(rs.getString("n_title"));
				bean.setU_id(rs.getInt("u_id"));
				bean.setN_id(rs.getInt("n_id"));
				bean.setN_time(rs.getString("n_time"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn, pstm, rs);
		}
		return list;
	}

	public int Register(NewsBean newsbean) {
		Connection conn = DBUtil.getConnection();
		String sql = "DELETE FROM news WHERE n_id =?";
		PreparedStatement pstm = null;
		int rs=0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newsbean.getN_title());
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return rs;
	}

	public int login(NewsBean userbean) {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO news(n_title,n_time,n_thing,n_image,u_id) VALUES(?,?,?,?,?)";
		PreparedStatement pstm = null;
		int rs=0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userbean.getN_title());
			pstm.setString(2, userbean.getN_time());
			pstm.setString(3, userbean.getN_thing());
			pstm.setString(4, userbean.getN_image());
			pstm.setInt(5, userbean.getU_id());
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return rs;
	}

	public int updateAvatarUrl(String n_title, String n_time, String url, int u_id, String n_thing) {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO news(n_title,n_time,n_thing,n_image,u_id) VALUES(?,?,?,?,?)";
		PreparedStatement pstm = null;
		int rs = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, n_title);
			pstm.setString(2, n_time);
			pstm.setString(3, n_thing);
			pstm.setString(4, url);
			pstm.setInt(5, u_id);
			rs = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstm, null);
		}
		return rs;
	}

	public List<NewsBean> ChangeNews(NewsBean newsbean) {
		Connection conn = DBUtil.getConnection();
		String sql= "SELECT * FROM news WHERE n_id =?";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<NewsBean> listapp = new ArrayList<NewsBean>();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, newsbean.getN_title());
			rs = pstm.executeQuery();
			while(rs.next()) {
				NewsBean bean = new NewsBean();
				bean.setN_image(rs.getString("n_image"));
				bean.setN_thing(rs.getString("n_thing"));
				bean.setN_title(rs.getString("n_title"));
				bean.setU_id(rs.getInt("u_id"));
				bean.setN_id(rs.getInt("n_id"));
				bean.setN_time(rs.getString("n_time"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn, pstm, rs);
		}
		return listapp;
	}

	public List<NewsBean> readmore(UserBean userbean) {
		Connection conn = DBUtil.getConnection();
		String sql= "SELECT * FROM news WHERE n_id =?";
		PreparedStatement pstm =null;
		ResultSet rs = null ;
		List<NewsBean> listapp = new ArrayList<NewsBean>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userbean.getUsername());
			rs = pstm.executeQuery();
			while(rs.next()) {
				NewsBean bean = new NewsBean();
				bean.setN_image(rs.getString("n_image"));
				bean.setN_thing(rs.getString("n_thing"));
				bean.setN_title(rs.getString("n_title"));
				bean.setU_id(rs.getInt("u_id"));
				bean.setN_id(rs.getInt("n_id"));
				bean.setN_time(rs.getString("n_time"));
				listapp.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.CloseDB(conn, pstm, rs);
		}
		return listapp;
	}

}
