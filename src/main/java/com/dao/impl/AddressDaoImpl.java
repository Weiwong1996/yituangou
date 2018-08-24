package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.AddressDao;
import com.entity.Address;
import com.entity.GoodsAndOrders;
import com.util.JdbcUtils;

/**
 * 地址接口实现
 * @author Administrator
 *
 */
public class AddressDaoImpl implements AddressDao{

	public boolean addAddress(Address address) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "insert into address(aid,aaddress,aname,aphone,aidentify,amail,uid) values(aid,?,?,?,?,?,?)";
			Object[] params = {address.getAaddress(),address.getAname(),address.getAphone(),address.getAidentify(),address.getAmail(),address.getUid()};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean aditAddress(Address address) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "update address set aaddress=?,aname=?,aphone=?,aidentity=?,amail=? where aid=?";
			Object[] params = {address.getAaddress(),address.getAname(),address.getAphone(),address.getAidentify(),address.getAmail(),address.getAid()};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Address> getAll() {
		List<Address> alist = new ArrayList<Address>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from address";
			alist = runner.query(sql, new BeanListHandler<Address>(Address.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alist;
	}

	public boolean deleteAddress(int aid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "delete from address where aid=?";
			runner.update(sql, aid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Address> getAddressByUid(int uid) {
		List<Address> alist = new ArrayList<Address>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "SELECT a.aid,a.aidentify,a.amail,a.aname,a.aphone,u.uid,a.aaddress FROM address a,users u WHERE a.uid=u.uid and a.uid=?";
			alist = runner.query(sql,uid,new BeanListHandler<Address>(Address.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alist;

}
}