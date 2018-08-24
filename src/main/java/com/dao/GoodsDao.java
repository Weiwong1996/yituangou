package com.dao;

import java.util.List;
import com.entity.Goods;

/**
 * 商品接口类
 * @author Administrator
 *
 */
public interface GoodsDao {
	/**
	 * 查询所有的商品
	 * @return 商品的数据
	 */
	public List<Goods> getAll();
	/**
	 * 按照商品名称查询
	 * @param gname 所需要查询的商品名称
	 * @return 查询的结果
	 */
	public List<Goods> getByGname(String gname);
	/**
	 * 按照商品品牌查询
	 * @param gbrand 所需要查询的品牌
	 * @return 查询的结果
	 */
	public List<Goods> getByGbrand(String gbrand);
	/**
	 * 按照商品种类查询
	 * @param gtype所需要查询的商品种类
	 * @return
	 */
	public List<Goods> getByGtype(String gtype);
	/**
	 * 添加商品
	 * @param goods 所添加的商品
	 * @return	true 添加成功	false 添加失败
	 */
	public boolean addGoods(Goods goods);
	/**
	 * 每次获取n条商品数据
	 * @param pageStart 开始数
	 * @param pageSize	结束数
	 * @return	规定数量的商品
	 */
	public List<Goods> getAllGoodsPageSize(int pageStart, int pageSize,String column);
	/**
	 * 获得商品总数
	 * @return	商品总数值
	 */
	public int getGoodsCount();
	/**
	 * 对商品叠加查询
	 * @param gtype	商品的种类
	 * @param gbrand	商品的品牌
	 * @return	查询的结果
	 */
	public List<Goods> getByTypeAndBrand(String gtype,String gbrand);
	/**
	 * 通过gid删除商品
	 * ww 5-25-09:10
	 */
	public boolean dodelete(int gid);
}
