package cn.edu.imnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.imnu.bean.UserBean;
import cn.edu.imnu.util.DBUtil;

public class UserDao {

	public UserBean login(UserBean userbean) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean userbrean = null;

		String sql = "select * from user where username=? and password=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userbean.getUsername());
			pstmt.setString(2, userbean.getPassword());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				userbrean = new UserBean();
				userbrean.setUsername(rs.getString("username"));
				userbrean.setType(rs.getString("type"));
				userbrean.setPassword(rs.getString("password"));
				userbrean.setU_id(rs.getInt("u_id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstmt, rs);
		}

		return userbrean;
	}

	public boolean isExitEmail(String userid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from user where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstmt, rs);
		}
		return false;
	}

	public void save(String userid, String email, String userpwd) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into user (username,email,password,type)" + "values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, email);
			pstmt.setString(3, userpwd);
			pstmt.setString(4, "普通用户");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(null, pstmt, null);

		}
	}

	public boolean forgetusername(String forget_username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from user where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, forget_username);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstmt, rs);
		}
		return false;
	}

	public boolean forgetemail(String forget_email) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from user where email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, forget_email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(conn, pstmt, rs);
		}
		return false;
	}

	public void amend(String forget_username, String forget_email, String forget_password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE user SET password = ? WHERE email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, forget_password);
			pstmt.setString(2, forget_email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(null, pstmt, null);

		}
	}

	public void AddUser(String userid, String email, String userpwd) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into user (username,email,password,type)" + "values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, email);
			pstmt.setString(3, userpwd);
			pstmt.setString(4, "超级管理员");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.CloseDB(null, pstmt, null);

		}
	}
}
