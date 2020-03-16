package com.base.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.base.web.bean.Uppwad;
import com.base.web.bean.User;
import com.base.web.bean.Deluser;
import com.base.web.bean.UpRole;

public class UserDao {
	// 添加
	public static boolean insert(User ub) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			con = DBUtils.getConnection();
			stm = con.createStatement();
			String sql = "insert into user(username,password,urole) values('" + ub.getUsername() + "','" + ub.getPassword()
					+ "',"+0+")";
			int num = stm.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return false;
	}

	// 查询
	public static User FindOne(String username) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();
			stm = con.createStatement();
			String sql = "select * from user where username='" + username + "'";
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				User ub = new User();
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				return ub;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return null;
	}

	//修改密码
	public static boolean uppwad(Uppwad up) {
		boolean checker = false;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql="update user set password='"+up.getNewpassword()+"' where username='"+up.getUsername()+"'";
		try {
			con = DBUtils.getConnection();
			stm = con.createStatement();
			int c = stm.executeUpdate(sql);
			if(c!=0) {
				checker=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return checker;
	}
	//修改角色
		public static boolean setRole(UpRole up) {
			boolean checker = false;
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			String sql="update user set urole='"+up.getRole()+"' where username='"+up.getUsername()+"'";
			try {
				con = DBUtils.getConnection();
				stm = con.createStatement();
				int c = stm.executeUpdate(sql);
				if(c!=0) {
					checker=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.release(rs, stm, con);
			}
			return checker;
		}
	//删除
	public static boolean del(Deluser de) {
		boolean checker = false;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql="delete from user  where username='"+de.getUsername()+"'";
		try {
			con = DBUtils.getConnection();
			stm = con.createStatement();
			int c = stm.executeUpdate(sql);
			if(c!=0) {
				checker=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return checker;
	}
	// 登录验证
	public static boolean check(String username, String password,String role) {
		boolean checker = false;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "select * from user where username='" + username + "'and password='" + password + "'and urole='"+role+"'";
		try {
			con = DBUtils.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				checker = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return checker;
	}
}
