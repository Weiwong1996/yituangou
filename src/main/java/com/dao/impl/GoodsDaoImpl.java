package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.GoodsDao;
import com.entity.Goods;
import com.util.JdbcUtils;

/**
 * 商品接口实现
 * @author Administrator
 *
 */
public class GoodsDaoImpl implements GoodsDao{

	public List<Goods> getAll() {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods";
			glist = runner.query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}

	public List<Goods> getByGname(String gname) {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods where gname=?";
			glist = runner.query(sql,gname, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}

	public List<Goods> getByGbrand(String gbrand) {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods where gbrand=?";
			glist = runner.query(sql,gbrand, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}

	public List<Goods> getByGtype(String gtype) {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods where gtype=?";
			glist = runner.query(sql,gtype, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}

	public boolean addGoods(Goods goods) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "insert into goods(gid,gname,gbrand,gtype,gpicpath,gtime,goriprice,gnowprice,gdiscount,gattention) values(gid,?,?,?,?,?,?,?,?,?)";
			Object[] params = {goods.getGname(),goods.getGbrand(),goods.getGtype(),goods.getGpicpath(),goods.getGtime(),goods.getGoriprice(),goods.getGnowprice(),goods.getGdiscount(),goods.getGattention()};
			runner.update(sql, params);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Goods> getAllGoodsPageSize(int pageStart, int pageSize,String column) {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods ORDER BY "+column+" limit ?,?";
			Object[] params = {pageStart, pageSize };
			glist = runner.query(sql, new BeanListHandler<Goods>(Goods.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}

	@Override
	public int getGoodsCount() {
		int count = 0;
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select count(gid) from goods";
			count = Integer.valueOf(runner.query(sql,new ScalarHandler()).toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
//	@Override
//	public List<Goods> getAllPriceAsc() {
//		List<Goods> glist = new ArrayList<Goods>();
//		try {
//			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
//			String sql = "select * from goods order by gnowprice";
//			glist = runner.query(sql, new BeanListHandler<Goods>(Goods.class));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return glist;
//	}
//
//	@Override
//	public List<Goods> getAllDiscountAsc() {
//		List<Goods> glist = new ArrayList<Goods>();
//		try {
//			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
//			String sql = "select * from goods order by gdiscount";
//			glist = runner.query(sql, new BeanListHandler<Goods>(Goods.class));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return glist;
//	}

	@Override
	public List<Goods> getByTypeAndBrand(String gtype, String gbrand) {
		List<Goods> glist = new ArrayList<Goods>();
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "select * from goods where gtype=? and gbrand=?";
			Object[] params = {gtype,gbrand};
			glist = runner.query(sql,params, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return glist;
	}
	//做删除操作
	@Override
	public boolean dodelete(int gid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDs());
			String sql = "delete from goods where gid=?";
			runner.update(sql, gid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
