package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.JdbcUtils;

/**
 * 用户接口实现
 * @author Administrator
 *
 */
public class UsersDaoImpl implements UsersDao{

	public boolean addUsers(Users users) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "insert into users(uid,uname,upwd,urealname,uidentify,uphone) values(uid,?,?,?,?,?)";
			Object[] params = {users.getUname(),users.getUpwd(),users.getUrealName(),users.getUidentify(),users.getUphone()};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		}

	public boolean editUsers(Users users) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "update users set upwd=?,uphone=? where uid=?";
			Object[] params = {users.getUpwd(),users.getUphone(),users.getUid()};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUsers(int uid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "delete from users where uid=?";
			runner.update(sql, uid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Users> getAll() {
		List<Users> ulist = new ArrayList<Users>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from Users";
			ulist = runner.query(sql, new BeanListHandler<Users>(Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}

	public Users getUserByUid(int uid) {
		Users users = null;
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from users where uid=?";
			users = runner.query(sql, uid, new BeanHandler<Users>(Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean doLogin(String uname, String upwd) {
		Users users = null;
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from users where uname=? AND upwd=?";
			Object[] params = {uname,upwd};
			users = runner.query(sql, params, new BeanHandler<Users>(Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (users!=null)?true:false;		
	}

	public Users GetUidByUname(String uname) {
		Users users = null;
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from users where uname=?";
			users = runner.query(sql, uname, new BeanHandler<Users>(Users.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	


}
