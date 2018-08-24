package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.OrdersDao;
import com.entity.Goods;
import com.entity.GoodsAndOrders;
import com.entity.Orders;
import com.util.JdbcUtils;

/**
 * 订单接口实现
 * @author Administrator
 *
 */
public class OrdersDaoImpl implements OrdersDao{

	public List<Orders> getAll() {
		List<Orders> olist = new ArrayList<Orders>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from Orders";
			olist = runner.query(sql, new BeanListHandler<Orders>(Orders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}

	public boolean deleteOrder(int oid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "delete from orders where oid=?";
			runner.update(sql, oid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<GoodsAndOrders> getAllOrders() {
		List<GoodsAndOrders> golist = new ArrayList<GoodsAndOrders>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "SELECT o.oid,g.gname,g.gpicpath,o.otime,g.gnowprice,u.urealname,a.aaddress FROM goods g,orders o,address a,users u WHERE g.gid=o.gid AND o.aid=a.aid AND o.uid=u.uid";
			golist = runner.query(sql, new BeanListHandler<GoodsAndOrders>(GoodsAndOrders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return golist;
	}

	@Override
	public List<Orders> getByUname(String uname) {
		
		List<Orders> olist = new ArrayList<Orders>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from Orders where uname=?";
			olist = runner.query(sql,uname, new BeanListHandler<Orders>(Orders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}

	@Override
	public boolean addOrder(GoodsAndOrders gAndO,int uid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "insert into orders(oid,otime,gid,aid,uid) values(oid,?,?,?,?)";
			Object[] params = {gAndO.getOtime(),gAndO.getGid(),gAndO.getAid(),uid};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
