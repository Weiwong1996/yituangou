package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.goDao;
import com.entity.GoodsAndOrders;
import com.util.JdbcUtils;

public class goDaoImpl implements goDao {

	@Override
	public List<GoodsAndOrders> getAllByUid(int uid) {
		List<GoodsAndOrders> golist = new ArrayList<GoodsAndOrders>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "SELECT o.oid,g.gname,g.gpicpath,o.otime,g.gnowprice,u.urealname,a.aaddress,a.aname,a.aphone FROM goods g,orders o,address a,users u WHERE g.gid=o.gid AND o.aid=a.aid AND o.uid=u.uid AND o.uid=?";
			golist = runner.query(sql,uid,new BeanListHandler<GoodsAndOrders>(GoodsAndOrders.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return golist;
	}

}
